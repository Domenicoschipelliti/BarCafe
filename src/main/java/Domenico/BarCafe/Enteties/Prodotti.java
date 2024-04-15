package Domenico.BarCafe.Enteties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Prodotti {

    private double costo;
    private String nomeProdotto;
    private  String immagine;
    private String descrizione;

}
