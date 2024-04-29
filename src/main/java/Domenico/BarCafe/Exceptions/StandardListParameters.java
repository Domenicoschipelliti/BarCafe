package Domenico.BarCafe.Exceptions;

import java.time.LocalDate;
import java.util.List;

public record StandardListParameters(List<String> errorsList, String message, LocalDate time) {
}
