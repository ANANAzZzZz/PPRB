package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.PaymentMethodDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.PaymentMethodMapper;
import suai.vladislav.pprbhack.model.PaymentMethod;
import suai.vladislav.pprbhack.repository.PaymentMethodRepository;
import suai.vladislav.pprbhack.service.interfaces.PaymentMethodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethodRepository.findAll()
            .stream()
            .map(paymentMethodMapper::toDto)
            .toList();
    }

    @Override
    public PaymentMethodDto getPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.PAYMENT_METHOD_NOT_FOUND, id));
        return paymentMethodMapper.toDto(paymentMethod);
    }

    @Override
    public PaymentMethodDto addPaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(paymentMethodDto);
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return paymentMethodMapper.toDto(savedPaymentMethod);
    }

    @Override
    public PaymentMethodDto updatePaymentMethod(PaymentMethodDto paymentMethodDto) {
        if (paymentMethodDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        PaymentMethod existingPaymentMethod = paymentMethodRepository.findById(paymentMethodDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.PAYMENT_METHOD_NOT_FOUND, paymentMethodDto.id()));

        PaymentMethod updatedPaymentMethod = paymentMethodMapper.toEntity(paymentMethodDto);
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(updatedPaymentMethod);
        return paymentMethodMapper.toDto(savedPaymentMethod);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        if (!paymentMethodRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.PAYMENT_METHOD_NOT_FOUND, id);
        }
        paymentMethodRepository.deleteById(id);
    }
}
