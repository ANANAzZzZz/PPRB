package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.PaymentMethodDto;
import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodDto> getPaymentMethods();
    PaymentMethodDto getPaymentMethodById(Long id);
    PaymentMethodDto addPaymentMethod(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto updatePaymentMethod(PaymentMethodDto paymentMethodDto);
    void deletePaymentMethod(Long id);
}
