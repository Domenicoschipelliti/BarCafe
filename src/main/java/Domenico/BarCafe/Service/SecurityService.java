package Domenico.BarCafe.Service;

import Domenico.BarCafe.DAO.UtenteDAO;
import Domenico.BarCafe.Security.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private Jwts jwts;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteDAO utenteDAO;





}
