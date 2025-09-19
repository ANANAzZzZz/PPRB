package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.ShippingMethodDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.ShippingMethodMapper;
import suai.vladislav.pprbhack.model.ShippingMethod;
import suai.vladislav.pprbhack.repository.ShippingMethodRepository;
import suai.vladislav.pprbhack.service.interfaces.ShippingMethodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingMethodServiceImpl implements ShippingMethodService {

    private final ShippingMethodRepository shippingMethodRepository;
    private final ShippingMethodMapper shippingMethodMapper;

    @Override
    public List<ShippingMethodDto> getShippingMethods() {
        return shippingMethodRepository.findAll()
            .stream()
            .map(shippingMethodMapper::toDto)
            .toList();
    }

    @Override
    public ShippingMethodDto getShippingMethodById(Long id) {
        ShippingMethod shippingMethod = shippingMethodRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIPPING_METHOD_NOT_FOUND, id));
        return shippingMethodMapper.toDto(shippingMethod);
    }

    @Override
    public ShippingMethodDto addShippingMethod(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = shippingMethodMapper.toEntity(shippingMethodDto);
        ShippingMethod savedShippingMethod = shippingMethodRepository.save(shippingMethod);
        return shippingMethodMapper.toDto(savedShippingMethod);
    }

    @Override
    public ShippingMethodDto updateShippingMethod(ShippingMethodDto shippingMethodDto) {
        if (shippingMethodDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        ShippingMethod existingShippingMethod = shippingMethodRepository.findById(shippingMethodDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIPPING_METHOD_NOT_FOUND, shippingMethodDto.id()));

        ShippingMethod updatedShippingMethod = shippingMethodMapper.toEntity(shippingMethodDto);
        ShippingMethod savedShippingMethod = shippingMethodRepository.save(updatedShippingMethod);
        return shippingMethodMapper.toDto(savedShippingMethod);
    }

    @Override
    public void deleteShippingMethod(Long id) {
        if (!shippingMethodRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.SHIPPING_METHOD_NOT_FOUND, id);
        }
        shippingMethodRepository.deleteById(id);
    }
}
