package Domenico.BarCafe.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardListParameters badRequest( BadRequest e){
        List<String> errorsMessages=new ArrayList<>();
        if (e.getErrorList()!=null)
            errorsMessages=e.getErrorList().stream().map(err->err.getDefaultMessage()).toList();
        return new StandardListParameters(errorsMessages,e.getMessage() ,LocalDate.now());


    }

    @ExceptionHandler(Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public StandardParameters unathorized(Unauthorized e){
        return new StandardParameters(e.getMessage(),LocalDate.now());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public StandardParameters accessDenied(){
        return new StandardParameters("non puoi usare questa cosa per via del tuo ruolo",LocalDate.now());
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardParameters notFound(NotFound e){
      return new StandardParameters(e.getMessage(),LocalDate.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public StandardParameters internalServerError(Exception e){
        e.printStackTrace();
        return new StandardParameters("errore di sistema nel server per favore controlla il backEnd",LocalDate.now());
    }


}
