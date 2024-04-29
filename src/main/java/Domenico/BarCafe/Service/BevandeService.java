package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.BevandeDAO;
import Domenico.BarCafe.Enteties.Bevande;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BevandeService {

    @Autowired
    private BevandeDAO bevandeDAO;


    public List<Bevande> Alldrinks(){
        return bevandeDAO.findAll();
    }

    public Bevande findByIdBevande(UUID bevandeId){
        return bevandeDAO.findById(bevandeId).orElseThrow(()->new NotFound(bevandeId));
    }

    public List<Bevande> foundByDrinksName(String bevanda){
        return bevandeDAO.listBevande(bevanda);
    }

    public List<Bevande> foundByCostDrinks(double costo){
        return bevandeDAO.BevandeList(costo);
    }


    public Bevande bevandePut(UUID bevandeId,Bevande body){
        Bevande bevande=this.findByIdBevande(bevandeId);
        bevande.setCosto(body.getCosto());
        bevande.setDescrizione(body.getDescrizione());
        bevande.setUser(body.getUser());
        bevande.setImmagine(body.getImmagine());
        bevande.setNomeProdotto(bevande.getNomeProdotto());
        return bevandeDAO.save(bevande);
    }


    public void bevandeDelete(UUID bevandeId){
        Bevande bevande=this.findByIdBevande(bevandeId);
        bevandeDAO.delete(bevande);
    }


}
