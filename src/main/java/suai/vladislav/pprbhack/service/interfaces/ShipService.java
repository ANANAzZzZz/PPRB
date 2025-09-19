package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.ShipDto;
import java.util.List;

public interface ShipService {
    List<ShipDto> getShips();
    ShipDto getShipById(Long id);
    ShipDto addShip(ShipDto shipDto);
    ShipDto updateShip(ShipDto shipDto);
    void deleteShip(Long id);
}
