package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.CartAdvertisementDto;
import suai.vladislav.pprbhack.model.CartAdvertisement;

@Component
public class CartAdvertisementMapper {

    public CartAdvertisementDto toDto(CartAdvertisement cartAdvertisement) {
        if (cartAdvertisement == null) {
            return null;
        }

        return new CartAdvertisementDto(
            cartAdvertisement.getId(),
            cartAdvertisement.getCart() != null ? cartAdvertisement.getCart().getId() : null,
            cartAdvertisement.getAdvertisement() != null ? cartAdvertisement.getAdvertisement().getId() : null
        );
    }

    public CartAdvertisement toEntity(CartAdvertisementDto cartAdvertisementDto) {
        if (cartAdvertisementDto == null) {
            return null;
        }

        CartAdvertisement cartAdvertisement = new CartAdvertisement();
        cartAdvertisement.setId(cartAdvertisementDto.id());

        return cartAdvertisement;
    }
}
