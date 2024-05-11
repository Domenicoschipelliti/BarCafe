package Domenico.BarCafe.Payload;

import jakarta.validation.constraints.NotEmpty;

public record BevandaDto(@NotEmpty(message = "nome del prodotto")String nomeProdotto, @NotEmpty(message = "la descrizione della bevanda")String descrizione, @NotEmpty(message = "il costo per far sapere quanto costa")double costo, @NotEmpty(message = "metti una foto per capire di cosa si beve")String immagine) {
}
