package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.CartDto;
import java.util.List;

public interface CartService {
    List<CartDto> getCarts();
    CartDto getCartById(Long id);
    CartDto addCart(CartDto cartDto);
    CartDto updateCart(CartDto cartDto);
    void deleteCart(Long id);
}
