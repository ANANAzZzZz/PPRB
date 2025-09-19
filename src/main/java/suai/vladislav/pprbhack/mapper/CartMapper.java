package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.CartDto;
import suai.vladislav.pprbhack.model.Cart;

@Component
public class CartMapper {

    public CartDto toDto(Cart cart) {
        if (cart == null) {
            return null;
        }

        return new CartDto(
            cart.getId(),
            cart.getUser() != null ? cart.getUser().getId() : null
        );
    }

    public Cart toEntity(CartDto cartDto) {
        if (cartDto == null) {
            return null;
        }

        Cart cart = new Cart();
        cart.setId(cartDto.id());

        return cart;
    }
}
