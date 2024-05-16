package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.UtenteDAO;
import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Enum.Role;
import Domenico.BarCafe.Exceptions.BadRequest;
import Domenico.BarCafe.Exceptions.Unauthorized;
import Domenico.BarCafe.Payload.UserDtoLogin;
import Domenico.BarCafe.Payload.UserDtoRegister;
import Domenico.BarCafe.Security.JwtsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private JwtsClass jwts;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteDAO utenteDAO;


   public String userResponse(UserDtoLogin userDtoLogin){
       Utente user=utenteService.findByEmail(userDtoLogin.email());
       if (passwordEncoder.matches(userDtoLogin.password(), user.getPassword())){
           return jwts.createToken(user);
       }else {
           throw new Unauthorized("Credenziali non valide");
       }
   }


    public Utente saveUser(UserDtoRegister body){

        utenteDAO.findByEmail(body.email()).ifPresent(user->{
            throw  new BadRequest("email "+ user.getEmail()+" già in uso");
        });
        utenteDAO.findByUsername(body.username()).ifPresent(username->{
            throw new BadRequest("Lo username "+username.getUsername()+" è già in uso");
        });

        Utente newUser=new Utente();

        newUser.setNome(body.nome());
        newUser.setCognome(body.cognome());
        newUser.setEmail(body.email());
        newUser.setUsername(body.username());
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setRuolo(Role.CLIENTE);
        return utenteDAO.save(newUser);
    }





}
