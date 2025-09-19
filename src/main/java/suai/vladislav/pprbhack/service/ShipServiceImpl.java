package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.ShipDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.ShipMapper;
import suai.vladislav.pprbhack.model.Ship;
import suai.vladislav.pprbhack.repository.PaymentMethodRepository;
import suai.vladislav.pprbhack.repository.ShipRepository;
import suai.vladislav.pprbhack.repository.ShippingMethodRepository;
import suai.vladislav.pprbhack.service.interfaces.ShipService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ShippingMethodRepository shippingMethodRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final ShipMapper shipMapper;

    @Override
    public List<ShipDto> getShips() {
        return shipRepository.findAll()
            .stream()
            .map(shipMapper::toDto)
            .toList();
    }

    @Override
    public ShipDto getShipById(Long id) {
        Ship ship = shipRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIP_NOT_FOUND, id));
        return shipMapper.toDto(ship);
    }

    @Override
    public ShipDto addShip(ShipDto shipDto) {
        Ship ship = shipMapper.toEntity(shipDto);

        if (shipDto.shippingMethodId() != null) {
            ship.setShippingMethod(shippingMethodRepository.findById(shipDto.shippingMethodId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIPPING_METHOD_NOT_FOUND, shipDto.shippingMethodId())));
        }

        if (shipDto.paymentMethodId() != null) {
            ship.setPaymentMethod(paymentMethodRepository.findById(shipDto.paymentMethodId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.PAYMENT_METHOD_NOT_FOUND, shipDto.paymentMethodId())));
        }

        Ship savedShip = shipRepository.save(ship);
        return shipMapper.toDto(savedShip);
    }

    @Override
    public ShipDto updateShip(ShipDto shipDto) {
        if (shipDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        Ship existingShip = shipRepository.findById(shipDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIP_NOT_FOUND, shipDto.id()));

        Ship updatedShip = shipMapper.toEntity(shipDto);

        if (shipDto.shippingMethodId() != null) {
            updatedShip.setShippingMethod(shippingMethodRepository.findById(shipDto.shippingMethodId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.SHIPPING_METHOD_NOT_FOUND, shipDto.shippingMethodId())));
        }

        if (shipDto.paymentMethodId() != null) {
            updatedShip.setPaymentMethod(paymentMethodRepository.findById(shipDto.paymentMethodId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.PAYMENT_METHOD_NOT_FOUND, shipDto.paymentMethodId())));
        }

        Ship savedShip = shipRepository.save(updatedShip);
        return shipMapper.toDto(savedShip);
    }

    @Override
    public void deleteShip(Long id) {
        if (!shipRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.SHIP_NOT_FOUND, id);
        }
        shipRepository.deleteById(id);
    }
}
