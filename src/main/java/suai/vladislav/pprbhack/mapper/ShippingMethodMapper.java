package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.ShippingMethodDto;
import suai.vladislav.pprbhack.model.ShippingMethod;

@Component
public class ShippingMethodMapper {

    public ShippingMethodDto toDto(ShippingMethod shippingMethod) {
        if (shippingMethod == null) {
            return null;
        }

        return new ShippingMethodDto(
            shippingMethod.getId(),
            shippingMethod.getName(),
            shippingMethod.getPrice()
        );
    }

    public ShippingMethod toEntity(ShippingMethodDto shippingMethodDto) {
        if (shippingMethodDto == null) {
            return null;
        }

        ShippingMethod shippingMethod = new ShippingMethod();
        shippingMethod.setId(shippingMethodDto.id());
        shippingMethod.setName(shippingMethodDto.name());
        shippingMethod.setPrice(shippingMethodDto.price());

        return shippingMethod;
    }
}
