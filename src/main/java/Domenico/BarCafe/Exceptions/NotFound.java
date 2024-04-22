package Domenico.BarCafe.Exceptions;

import java.util.UUID;

public class NotFound extends RuntimeException{
    public NotFound(UUID id){
        super("id "+ id +" non trovato");
    }

    public NotFound(String message){
        super(message);
    }
}
