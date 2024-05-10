package Domenico.BarCafe.Controllers;

import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    @PreAuthorize("hasAuthority('BARISTA')")
    public Page<Utente> getUtenti(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "userId") String order){
       return utenteService.utentiList(page, size, order);
    }

    @GetMapping("/{userId}")
    public  Utente utenteId(@PathVariable UUID userId){
        return utenteService.uteneById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('BARISTA')")
    public  Utente utentePut(@PathVariable UUID userId,@RequestBody Utente body){
        return utenteService.utenteUpdate(userId,body);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('BARISTA')")
    public void utenteDelete(@PathVariable UUID userId){
        utenteService.utenteDelete(userId);
    }

    //---------------/me------------\\

    @GetMapping("/me")
    public  Utente pageUser(@AuthenticationPrincipal Utente utente){
        return  utente;
    }

    @PutMapping("/me")
    public  Utente putPageUser(@AuthenticationPrincipal Utente userId,@RequestBody Utente body){
        return  utenteService.utenteUpdate(userId.getUserId(),body);
    }



    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteUserPage(@AuthenticationPrincipal Utente userId){
        utenteService.utenteDelete(userId.getUserId());
    }


    //----------------user uplaod avatar-------------\\

    @PatchMapping("/{userId}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadAvatarImg(@RequestParam("image") MultipartFile file, @PathVariable UUID userId) throws Exception {
        return utenteService.uploadImageAvatar(file,userId);
    }





}
