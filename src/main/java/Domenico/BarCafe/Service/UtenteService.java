package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.UtenteDAO;
import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public Page<Utente> utentiList(int page, int size, String order){

        Pageable pageable= PageRequest.of(page,size, Sort.by(order));
        return  utenteDAO.findAll(pageable);
    }

    public Utente uteneById(UUID userId){
        return utenteDAO.findById(userId).orElseThrow(()->new NotFound(userId));
    }

    public Utente utenteUpdate(UUID userId,Utente body){
        Utente utente=new Utente();
        utente.setNome(body.getNome());
        utente.setEmail(body.getEmail());
        utente.setCognome(body.getCognome());
        utente.setAvatar(body.getAvatar());
        utente.setUsername(body.getUsername());
        utente.setRuolo(body.getRuolo());
        return  utenteDAO.save(utente);
    }

    public void utenteDelete(UUID userId){
        Utente utente=this.uteneById(userId);
        utenteDAO.delete(utente);
    }


    public Utente findByEmail(String email){
        return utenteDAO.findByEmail(email).orElseThrow(()->new NotFound("questa mail non esiste"));
    }








}
