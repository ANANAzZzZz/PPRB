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
import suai.vladislav.pprbhack.dto.CartAdvertisementDto;
import suai.vladislav.pprbhack.service.interfaces.CartAdvertisementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cart-advertisement")
public class CartAdvertisementController {

    private final CartAdvertisementService cartAdvertisementService;

    @GetMapping
    public List<CartAdvertisementDto> getCartAdvertisements() {
        return cartAdvertisementService.getCartAdvertisements();
    }

    @GetMapping("/{cartAdvertisementId}")
    public CartAdvertisementDto getCartAdvertisement(
        @PathVariable("cartAdvertisementId") Long cartAdvertisementId
    ) {
        return cartAdvertisementService.getCartAdvertisementById(cartAdvertisementId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartAdvertisementDto addCartAdvertisement(
        @Validated
        @RequestBody CartAdvertisementDto cartAdvertisementDto
    ) {
        return cartAdvertisementService.addCartAdvertisement(cartAdvertisementDto);
    }

    @PutMapping
    public CartAdvertisementDto updateCartAdvertisement(
        @Validated
        @RequestBody CartAdvertisementDto cartAdvertisementDto
    ) {
        return cartAdvertisementService.updateCartAdvertisement(cartAdvertisementDto);
    }

    @DeleteMapping("/{cartAdvertisementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartAdvertisement(
        @PathVariable("cartAdvertisementId") Long cartAdvertisementId
    ) {
        cartAdvertisementService.deleteCartAdvertisement(cartAdvertisementId);
    }
}
