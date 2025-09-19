package suai.vladislav.pprbhack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.pprbhack.dto.CartDto;
import suai.vladislav.pprbhack.service.interfaces.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<CartDto> getCarts() {
        return cartService.getCarts();
    }

    @GetMapping("/{cartId}")
    public CartDto getCart(
        @PathVariable("cartId") Long cartId
    ) {
        return cartService.getCartById(cartId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addCart(
        @Validated
        @RequestBody CartDto cartDto
    ) {
        return cartService.addCart(cartDto);
    }

    @PutMapping
    public CartDto updateCart(
        @Validated
        @RequestBody CartDto cartDto
    ) {
        return cartService.updateCart(cartDto);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(
        @PathVariable("cartId") Long cartId
    ) {
        cartService.deleteCart(cartId);
    }
}
