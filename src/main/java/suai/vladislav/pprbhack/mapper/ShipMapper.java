package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.ShipDto;
import suai.vladislav.pprbhack.model.Ship;

@Component
public class ShipMapper {

    public ShipDto toDto(Ship ship) {
        if (ship == null) {
            return null;
        }

        return new ShipDto(
            ship.getId(),
            ship.getName(),
            ship.getShippingMethod() != null ? ship.getShippingMethod().getId() : null,
            ship.getPaymentMethod() != null ? ship.getPaymentMethod().getId() : null,
            ship.getReceiverId(),
            ship.getAddress()
        );
    }

    public Ship toEntity(ShipDto shipDto) {
        if (shipDto == null) {
            return null;
        }

        Ship ship = new Ship();
        ship.setId(shipDto.id());
        ship.setName(shipDto.name());
        ship.setReceiverId(shipDto.receiverId());
        ship.setAddress(shipDto.address());

        return ship;
    }
}
