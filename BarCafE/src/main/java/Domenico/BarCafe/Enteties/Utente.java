package Domenico.BarCafe.Enteties;

import Domenico.BarCafe.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue
    private UUID userId;
    private String nome;
    private String cognome;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role ruolo;

}
