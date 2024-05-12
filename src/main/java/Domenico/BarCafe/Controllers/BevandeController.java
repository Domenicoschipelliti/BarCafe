package Domenico.BarCafe.Controllers;

import Domenico.BarCafe.Enteties.Bevande;
import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Service.BevandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bevande")
public class BevandeController {

    @Autowired
    private BevandeService bevandeService;

    @GetMapping
    public List<Bevande> bevandeList(){
        return bevandeService.Alldrinks();
    }

    @GetMapping("/idBevande")
    public Bevande bevandeId(@PathVariable UUID idBevande){
        return bevandeService.findByIdBevande(idBevande);
    }

    @GetMapping("/nomeProdotto")
    public List<Bevande> filterByNameProduct(@RequestParam(name = "nomeProdotto")String nomeProdotto){
        return bevandeService.foundByDrinksName(nomeProdotto);
    }

    @GetMapping("/costo")
    public List<Bevande> filterByCosto(@RequestParam(name = "costo")double costo){
        return bevandeService.foundByCostDrinks(costo);
    }

    @PutMapping("/{idBevande}")
    @PreAuthorize("hasAuthority('BARISTA')")
    public Bevande bevandePut(@PathVariable UUID idBevande,@RequestBody Bevande bevande){
        return bevandeService.bevandePut(idBevande,bevande);
    }

    @DeleteMapping("/{idBevande}")
    public void bevandeDelete(@PathVariable UUID idBevande){
        bevandeService.bevandeDelete(idBevande);
    }

    //--------------upload immagini-------------\\


    @PatchMapping("/{idBevande}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('BARISTA')")
    public String uploadImg(@RequestParam("image") MultipartFile file, @PathVariable UUID idBevande) throws IOException {
        return bevandeService.uploadImageAvatar(file, idBevande);
    }






}
