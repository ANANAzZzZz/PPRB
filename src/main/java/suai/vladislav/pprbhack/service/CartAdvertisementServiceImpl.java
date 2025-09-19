package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.CartAdvertisementDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.CartAdvertisementMapper;
import suai.vladislav.pprbhack.model.CartAdvertisement;
import suai.vladislav.pprbhack.repository.AdvertisementRepository;
import suai.vladislav.pprbhack.repository.CartAdvertisementRepository;
import suai.vladislav.pprbhack.repository.CartRepository;
import suai.vladislav.pprbhack.service.interfaces.CartAdvertisementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartAdvertisementServiceImpl implements CartAdvertisementService {

    private final CartAdvertisementRepository cartAdvertisementRepository;
    private final CartRepository cartRepository;
    private final AdvertisementRepository advertisementRepository;
    private final CartAdvertisementMapper cartAdvertisementMapper;

    @Override
    public List<CartAdvertisementDto> getCartAdvertisements() {
        return cartAdvertisementRepository.findAll()
            .stream()
            .map(cartAdvertisementMapper::toDto)
            .toList();
    }

    @Override
    public CartAdvertisementDto getCartAdvertisementById(Long id) {
        CartAdvertisement cartAdvertisement = cartAdvertisementRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_ADVERTISEMENT_NOT_FOUND, id));
        return cartAdvertisementMapper.toDto(cartAdvertisement);
    }

    @Override
    public CartAdvertisementDto addCartAdvertisement(CartAdvertisementDto cartAdvertisementDto) {
        CartAdvertisement cartAdvertisement = cartAdvertisementMapper.toEntity(cartAdvertisementDto);

        if (cartAdvertisementDto.cartId() != null) {
            cartAdvertisement.setCart(cartRepository.findById(cartAdvertisementDto.cartId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_NOT_FOUND, cartAdvertisementDto.cartId())));
        }

        if (cartAdvertisementDto.advertisementId() != null) {
            cartAdvertisement.setAdvertisement(advertisementRepository.findById(cartAdvertisementDto.advertisementId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.ADVERTISEMENT_NOT_FOUND, cartAdvertisementDto.advertisementId())));
        }

        CartAdvertisement savedCartAdvertisement = cartAdvertisementRepository.save(cartAdvertisement);
        return cartAdvertisementMapper.toDto(savedCartAdvertisement);
    }

    @Override
    public CartAdvertisementDto updateCartAdvertisement(CartAdvertisementDto cartAdvertisementDto) {
        if (cartAdvertisementDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        CartAdvertisement existingCartAdvertisement = cartAdvertisementRepository.findById(cartAdvertisementDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_ADVERTISEMENT_NOT_FOUND, cartAdvertisementDto.id()));

        CartAdvertisement updatedCartAdvertisement = cartAdvertisementMapper.toEntity(cartAdvertisementDto);

        if (cartAdvertisementDto.cartId() != null) {
            updatedCartAdvertisement.setCart(cartRepository.findById(cartAdvertisementDto.cartId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_NOT_FOUND, cartAdvertisementDto.cartId())));
        }

        if (cartAdvertisementDto.advertisementId() != null) {
            updatedCartAdvertisement.setAdvertisement(advertisementRepository.findById(cartAdvertisementDto.advertisementId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.ADVERTISEMENT_NOT_FOUND, cartAdvertisementDto.advertisementId())));
        }

        CartAdvertisement savedCartAdvertisement = cartAdvertisementRepository.save(updatedCartAdvertisement);
        return cartAdvertisementMapper.toDto(savedCartAdvertisement);
    }

    @Override
    public void deleteCartAdvertisement(Long id) {
        if (!cartAdvertisementRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.CART_ADVERTISEMENT_NOT_FOUND, id);
        }
        cartAdvertisementRepository.deleteById(id);
    }
}
