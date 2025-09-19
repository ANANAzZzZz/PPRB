package suai.vladislav.pprbhack.exception;

import lombok.Getter;
import suai.vladislav.pprbhack.enums.ErrorType;

@Getter
public abstract class AbstractException extends RuntimeException {

    private final ErrorType errorType;
    private final String message;

    public AbstractException(ErrorType errorType, Object... params) {
        super(String.format(errorType.getMessage(), params));
        this.errorType = errorType;
        this.message = String.format(errorType.getMessage(), params);
    }

    public AbstractException(ErrorType errorType, Throwable ex, Object... params) {
        super(String.format(errorType.getMessage(), params), ex);
        this.errorType = errorType;
        this.message = String.format(errorType.getMessage(), params);
    }
}
