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
import suai.vladislav.pprbhack.dto.ShippingMethodDto;
import suai.vladislav.pprbhack.service.interfaces.ShippingMethodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shipping-method")
public class ShippingMethodController {

    private final ShippingMethodService shippingMethodService;

    @GetMapping
    public List<ShippingMethodDto> getShippingMethods() {
        return shippingMethodService.getShippingMethods();
    }

    @GetMapping("/{shippingMethodId}")
    public ShippingMethodDto getShippingMethod(
        @PathVariable("shippingMethodId") Long shippingMethodId
    ) {
        return shippingMethodService.getShippingMethodById(shippingMethodId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShippingMethodDto addShippingMethod(
        @Validated
        @RequestBody ShippingMethodDto shippingMethodDto
    ) {
        return shippingMethodService.addShippingMethod(shippingMethodDto);
    }

    @PutMapping
    public ShippingMethodDto updateShippingMethod(
        @Validated
        @RequestBody ShippingMethodDto shippingMethodDto
    ) {
        return shippingMethodService.updateShippingMethod(shippingMethodDto);
    }

    @DeleteMapping("/{shippingMethodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShippingMethod(
        @PathVariable("shippingMethodId") Long shippingMethodId
    ) {
        shippingMethodService.deleteShippingMethod(shippingMethodId);
    }
}
