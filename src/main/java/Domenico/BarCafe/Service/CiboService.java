package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.CiboDAO;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.NotFound;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CiboService {
 @Autowired
 private CiboDAO ciboDAO;

 @Autowired
 private Cloudinary cloudinary;

 public List<Cibo> AllFood(){
     return ciboDAO.findAll();
 }

 public  Cibo foundById(UUID ciboId){
     return ciboDAO.findById(ciboId).orElseThrow(()->new NotFound(ciboId));
 }

 public List<Cibo> foundByFoodName(String cibo){
     return ciboDAO.listCibo(cibo);
 }

 public List<Cibo> foundByCost(double costo){
     return ciboDAO.CostoCibo(costo);
 }

public Cibo ciboPut(UUID ciboId,Cibo body){
     Cibo cibo=this.foundById(ciboId);
     cibo.setCosto(body.getCosto());
     cibo.setDescrizione(body.getDescrizione());
     cibo.setImmagine(body.getImmagine());
     cibo.setNomeProdotto(body.getNomeProdotto());
     return ciboDAO.save(cibo);
}

public void ciboDelete(UUID ciboId){
    Cibo cibo=this.foundById(ciboId);
    ciboDAO.delete(cibo);
}

    public  String uploadImageAvatar(MultipartFile file, UUID userId) throws IOException {
        Cibo found = this.foundById(userId);
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setImmagine(url);
        ciboDAO.save(found);
        return url;
    }


}
