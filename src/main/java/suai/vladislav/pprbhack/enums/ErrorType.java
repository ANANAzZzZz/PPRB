package suai.vladislav.pprbhack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // User errors
    USER_NOT_FOUND("Пользователь не найден, id=%s", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("Пользователь уже существует, email=%s", HttpStatus.CONFLICT),
    WRONG_CREDENTIALS("Неверный логин или пароль", HttpStatus.UNAUTHORIZED),

    // Advertisement errors
    ADVERTISEMENT_NOT_FOUND("Объявление не найдено, id=%s", HttpStatus.NOT_FOUND),
    ADVERTISEMENT_ALREADY_EXISTS("Объявление уже существует, id=%s", HttpStatus.CONFLICT),

    // Cart errors
    CART_NOT_FOUND("Корзина не найдена, id=%s", HttpStatus.NOT_FOUND),
    CART_ALREADY_EXISTS("Корзина уже существует для пользователя, userId=%s", HttpStatus.CONFLICT),

    // CartAdvertisement errors
    CART_ADVERTISEMENT_NOT_FOUND("Объявление в корзине не найдено, id=%s", HttpStatus.NOT_FOUND),
    CART_ADVERTISEMENT_ALREADY_EXISTS("Объявление уже добавлено в корзину, cartId=%s, advertisementId=%s", HttpStatus.CONFLICT),

    // PaymentMethod errors
    PAYMENT_METHOD_NOT_FOUND("Способ оплаты не найден, id=%s", HttpStatus.NOT_FOUND),
    PAYMENT_METHOD_ALREADY_EXISTS("Способ оплаты уже существует, name=%s", HttpStatus.CONFLICT),

    // ShippingMethod errors
    SHIPPING_METHOD_NOT_FOUND("Способ доставки не найден, id=%s", HttpStatus.NOT_FOUND),
    SHIPPING_METHOD_ALREADY_EXISTS("Способ доставки уже существует, name=%s", HttpStatus.CONFLICT),

    // Ship errors
    SHIP_NOT_FOUND("Доставка не найдена, id=%s", HttpStatus.NOT_FOUND),
    SHIP_ALREADY_EXISTS("Доставка уже существует, id=%s", HttpStatus.CONFLICT),

    // General errors
    ID_IS_MISSING("Не передан id сущности", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST_DATA("Неверные данные запроса", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus status;
}