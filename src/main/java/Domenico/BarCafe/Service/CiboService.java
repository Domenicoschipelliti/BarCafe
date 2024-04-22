package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.CiboDAO;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CiboService {
 @Autowired
 private CiboDAO ciboDAO;
 public List<Cibo> AllFood(){
     return ciboDAO.findAll();
 }

 public  Cibo foundById(UUID ciboId){
     return ciboDAO.findById(ciboId).orElseThrow(()->new NotFound(ciboId));
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

}
