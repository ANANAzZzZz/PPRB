package suai.vladislav.pprbhack.dto;

public record ShipDto(
    Long id,
    String name,
    Long shippingMethodId,
    Long paymentMethodId,
    Long receiverId,
    String address
) {
}
