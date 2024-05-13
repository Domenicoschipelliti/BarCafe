package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.BevandeDAO;
import Domenico.BarCafe.Enteties.Bevande;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Exceptions.NotFound;
import Domenico.BarCafe.Payload.BevandaDto;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BevandeService {

    @Autowired
    private BevandeDAO bevandeDAO;

    @Autowired
    private Cloudinary cloudinary;


    public List<Bevande> Alldrinks(){
        return bevandeDAO.findAll();
    }

    public Bevande findByIdBevande(UUID idBevande){
        return bevandeDAO.findById(idBevande).orElseThrow(()->new NotFound(idBevande));
    }

    public List<Bevande> foundByDrinksName(String bevanda){
        return bevandeDAO.listBevande(bevanda);
    }

    public List<Bevande> foundByCostDrinks(double costo){
        return bevandeDAO.BevandeList(costo);
    }


    public Bevande bevandePut(UUID idBevande,Bevande body){
        Bevande bevande=this.findByIdBevande(idBevande);
        bevande.setCosto(body.getCosto());
        bevande.setDescrizione(body.getDescrizione());
        bevande.setUser(body.getUser());
        bevande.setImmagine(body.getImmagine());
        bevande.setNomeProdotto(bevande.getNomeProdotto());
        return bevandeDAO.save(bevande);
    }

    public Bevande bevandeSave(Bevande bevande){
        return  bevandeDAO.save(bevande);
    }

    public Bevande bevandePost(BevandaDto bevandaDto){
        Bevande newBevande=new Bevande();

        newBevande.setCosto(bevandaDto.costo());
        newBevande.setImmagine(bevandaDto.immagine());
        newBevande.setDescrizione(bevandaDto.descrizione());
        newBevande.setNomeProdotto(bevandaDto.nomeProdotto());

        return bevandeDAO.save(newBevande);
    }


    public void bevandeDelete(UUID idBevande){
        Bevande bevande=this.findByIdBevande(idBevande);
        bevandeDAO.delete(bevande);
    }

    public  String uploadImageAvatar(MultipartFile file, UUID idBevande) throws IOException {
        Bevande found = this.findByIdBevande(idBevande);
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setImmagine(url);
        bevandeDAO.save(found);
        return url;
    }

}
