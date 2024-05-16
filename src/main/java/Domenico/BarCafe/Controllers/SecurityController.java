package Domenico.BarCafe.Controllers;

import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.BadRequest;
import Domenico.BarCafe.Payload.UserDtoLogin;
import Domenico.BarCafe.Payload.UserDtoLoginResponse;
import Domenico.BarCafe.Payload.UserDtoRegister;
import Domenico.BarCafe.Payload.UserDtoRegisterResponse;
import Domenico.BarCafe.Service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    public UserDtoLoginResponse login(@RequestBody UserDtoLogin userDtoLogin){
        String tokenAccess=securityService.userResponse(userDtoLogin);
        return new UserDtoLoginResponse(tokenAccess);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoRegisterResponse register(@RequestBody @Validated UserDtoRegister userDtoRegister, BindingResult validation){
        if(validation.hasErrors()){
            System.out.println(validation.hasErrors());
            throw new BadRequest(validation.getAllErrors());

        }else {
            Utente nuovoUtente=securityService.saveUser(userDtoRegister);
            return new UserDtoRegisterResponse(nuovoUtente.getUserId());
        }

    }
}
