package Domenico.BarCafe.Exceptions;

import lombok.Getter;

import java.util.UUID;
@Getter
public class NotFound extends RuntimeException{
    public NotFound(UUID id){
        super("id "+ id +" non trovato");
    }

    public NotFound(String message){
        super(message);
    }
}
