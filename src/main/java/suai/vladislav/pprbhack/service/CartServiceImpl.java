package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.CartDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.CartMapper;
import suai.vladislav.pprbhack.model.Cart;
import suai.vladislav.pprbhack.repository.CartRepository;
import suai.vladislav.pprbhack.repository.UserRepository;
import suai.vladislav.pprbhack.service.interfaces.CartService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    @Override
    public List<CartDto> getCarts() {
        return cartRepository.findAll()
            .stream()
            .map(cartMapper::toDto)
            .toList();
    }

    @Override
    public CartDto getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_NOT_FOUND, id));
        return cartMapper.toDto(cart);
    }

    @Override
    public CartDto addCart(CartDto cartDto) {
        Cart cart = cartMapper.toEntity(cartDto);

        if (cartDto.userId() != null) {
            cart.setUser(userRepository.findById(cartDto.userId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, cartDto.userId())));
        }

        Cart savedCart = cartRepository.save(cart);
        return cartMapper.toDto(savedCart);
    }

    @Override
    public CartDto updateCart(CartDto cartDto) {
        if (cartDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        Cart existingCart = cartRepository.findById(cartDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.CART_NOT_FOUND, cartDto.id()));

        Cart updatedCart = cartMapper.toEntity(cartDto);

        if (cartDto.userId() != null) {
            updatedCart.setUser(userRepository.findById(cartDto.userId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, cartDto.userId())));
        }

        Cart savedCart = cartRepository.save(updatedCart);
        return cartMapper.toDto(savedCart);
    }

    @Override
    public void deleteCart(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.CART_NOT_FOUND, id);
        }
        cartRepository.deleteById(id);
    }
}
