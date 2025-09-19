package suai.vladislav.pprbhack.controller.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import suai.vladislav.pprbhack.dto.ErrorDto;
import suai.vladislav.pprbhack.exception.AbstractException;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonPPRBApiException.class)
    public final ResponseEntity<ErrorDto> handleCommonOnboardingApiException(AbstractException e) {
        log.error("Ошибка PPRBApi: ", e);

        return ResponseEntity.status(
            e.getErrorType()
                .getStatus()
                .value()
        ).body(getBody(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Ошибка валидации: ", e);

        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error ->
            errorMap.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    private ErrorDto getBody(String message) {
        return ErrorDto.builder()
            .errorMessage(message)
            .build();
    }
}