package suai.vladislav.pprbhack.dto;

import java.math.BigDecimal;

public record ShippingMethodDto(
    Long id,
    String name,
    BigDecimal price
) {
}
