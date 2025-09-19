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
import suai.vladislav.pprbhack.dto.PaymentMethodDto;
import suai.vladislav.pprbhack.service.interfaces.PaymentMethodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment-method")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethodService.getPaymentMethods();
    }

    @GetMapping("/{paymentMethodId}")
    public PaymentMethodDto getPaymentMethod(
        @PathVariable("paymentMethodId") Long paymentMethodId
    ) {
        return paymentMethodService.getPaymentMethodById(paymentMethodId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethodDto addPaymentMethod(
        @Validated
        @RequestBody PaymentMethodDto paymentMethodDto
    ) {
        return paymentMethodService.addPaymentMethod(paymentMethodDto);
    }

    @PutMapping
    public PaymentMethodDto updatePaymentMethod(
        @Validated
        @RequestBody PaymentMethodDto paymentMethodDto
    ) {
        return paymentMethodService.updatePaymentMethod(paymentMethodDto);
    }

    @DeleteMapping("/{paymentMethodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaymentMethod(
        @PathVariable("paymentMethodId") Long paymentMethodId
    ) {
        paymentMethodService.deletePaymentMethod(paymentMethodId);
    }
}
