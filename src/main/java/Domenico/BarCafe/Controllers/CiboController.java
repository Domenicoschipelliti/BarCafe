package Domenico.BarCafe.Controllers;

import Domenico.BarCafe.Enteties.Cibo;
import Domenico.BarCafe.Payload.CiboDto;
import Domenico.BarCafe.Service.CiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cibo")
public class CiboController {
    @Autowired
    private CiboService ciboService;

    @GetMapping
    public List<Cibo> ciboList(){
        return  ciboService.AllFood();
    }

    @GetMapping("/{idCibo}")
    public Cibo ciboId(@PathVariable UUID idCibo){
        return ciboService.foundById(idCibo);
    }

    @GetMapping("/nomeProdotto")
    public List<Cibo> filterByNameProduct(@RequestParam(name = "nomeProdotto")String nomeProdotto){
        return ciboService.foundByFoodName(nomeProdotto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('BARISTA')")
    @ResponseStatus(HttpStatus.CREATED)
    public  Cibo postCibo(@RequestBody CiboDto ciboDto){
        return ciboService.ciboPost(ciboDto);

    }

    @GetMapping("/costo")
    public List<Cibo> filterByCosto(@RequestParam(name = "costo")double costo){
        return ciboService.foundByCost(costo);
    }

    @PutMapping("/{idCibo}")
    @PreAuthorize("hasAuthority('BARISTA')")
    public Cibo ciboPut(@PathVariable UUID idCibo,@RequestBody Cibo cibo){
        return ciboService.ciboPut(idCibo,cibo);
    }


    @DeleteMapping("/{idCibo}")
    public void ciboDelete(@PathVariable UUID idCibo){
        ciboService.ciboDelete(idCibo);
    }


    //--------------upload immagini-------------\\


    @PatchMapping("/{idCibo}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('BARISTA')")
    public String uploadImg(@RequestParam("image")MultipartFile file,@PathVariable UUID idCibo) throws IOException {
        return ciboService.uploadImageAvatar(file,idCibo);

    }







}
