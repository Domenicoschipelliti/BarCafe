package Domenico.BarCafe.Payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserDtoLogin(@NotEmpty(message = "devi mettere qualcosa")String password, @Email(message = "l'email non è corretta")String email) {
}
