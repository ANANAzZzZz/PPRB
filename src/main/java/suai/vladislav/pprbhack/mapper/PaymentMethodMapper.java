package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.PaymentMethodDto;
import suai.vladislav.pprbhack.model.PaymentMethod;

@Component
public class PaymentMethodMapper {

    public PaymentMethodDto toDto(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }

        return new PaymentMethodDto(
            paymentMethod.getId(),
            paymentMethod.getName(),
            paymentMethod.getImage()
        );
    }

    public PaymentMethod toEntity(PaymentMethodDto paymentMethodDto) {
        if (paymentMethodDto == null) {
            return null;
        }

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(paymentMethodDto.id());
        paymentMethod.setName(paymentMethodDto.name());
        paymentMethod.setImage(paymentMethodDto.image());

        return paymentMethod;
    }
}
