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
import suai.vladislav.pprbhack.dto.ShipDto;
import suai.vladislav.pprbhack.service.interfaces.ShipService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ship")
public class ShipController {

    private final ShipService shipService;

    @GetMapping
    public List<ShipDto> getShips() {
        return shipService.getShips();
    }

    @GetMapping("/{shipId}")
    public ShipDto getShip(
        @PathVariable("shipId") Long shipId
    ) {
        return shipService.getShipById(shipId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipDto addShip(
        @Validated
        @RequestBody ShipDto shipDto
    ) {
        return shipService.addShip(shipDto);
    }

    @PutMapping
    public ShipDto updateShip(
        @Validated
        @RequestBody ShipDto shipDto
    ) {
        return shipService.updateShip(shipDto);
    }

    @DeleteMapping("/{shipId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShip(
        @PathVariable("shipId") Long shipId
    ) {
        shipService.deleteShip(shipId);
    }
}
