package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.ShippingMethodDto;
import java.util.List;

public interface ShippingMethodService {
    List<ShippingMethodDto> getShippingMethods();
    ShippingMethodDto getShippingMethodById(Long id);
    ShippingMethodDto addShippingMethod(ShippingMethodDto shippingMethodDto);
    ShippingMethodDto updateShippingMethod(ShippingMethodDto shippingMethodDto);
    void deleteShippingMethod(Long id);
}
