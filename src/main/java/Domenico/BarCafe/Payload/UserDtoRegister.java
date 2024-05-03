package Domenico.BarCafe.Payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDtoRegister(@NotEmpty(message = "devi mettere il nome")String nome, @NotEmpty(message = "metti il cognome")String cognome, @NotEmpty(message = "metti un username") String username, @Email(message = "metti un eamil valida")String email,@NotEmpty(message = "metti una password valida")String password) {
}
