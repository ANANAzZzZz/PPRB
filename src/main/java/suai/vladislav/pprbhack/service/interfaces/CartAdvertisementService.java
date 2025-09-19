package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.CartAdvertisementDto;
import java.util.List;

public interface CartAdvertisementService {
    List<CartAdvertisementDto> getCartAdvertisements();
    CartAdvertisementDto getCartAdvertisementById(Long id);
    CartAdvertisementDto addCartAdvertisement(CartAdvertisementDto cartAdvertisementDto);
    CartAdvertisementDto updateCartAdvertisement(CartAdvertisementDto cartAdvertisementDto);
    void deleteCartAdvertisement(Long id);
}
