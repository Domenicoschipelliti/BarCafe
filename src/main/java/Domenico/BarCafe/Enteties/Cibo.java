package Domenico.BarCafe.Enteties;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cibo{
    @Id
    @GeneratedValue
    private UUID idCibo;
    private double costo;
    private String nomeProdotto;
    private  String immagine;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Utente user;

}
