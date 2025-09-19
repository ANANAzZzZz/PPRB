package suai.vladislav.pprbhack.exception;

import lombok.Getter;
import suai.vladislav.pprbhack.enums.ErrorType;

@Getter
public class CommonPPRBApiException extends AbstractException {

    public CommonPPRBApiException(ErrorType errorType, Object... params) {
        super(errorType, params);
    }

    public CommonPPRBApiException(ErrorType errorType, Throwable ex, Object... params) {
        super(errorType, ex, params);
    }
}