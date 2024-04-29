package Domenico.BarCafe.Exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequest extends RuntimeException {
    private List<ObjectError> errorList;

    public BadRequest(String message){
        super(message);
    }

    public BadRequest(List<ObjectError> errorList) {
        this.errorList = errorList;
    }


}
