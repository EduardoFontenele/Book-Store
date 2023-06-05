package spring6api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ID must not be a negative number or null")
public class NullPathVarException extends RuntimeException{
    public NullPathVarException() {
        super();
    }

    public NullPathVarException(String message) {
        super(message);
    }

    public NullPathVarException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPathVarException(Throwable cause) {
        super(cause);
    }

    protected NullPathVarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
