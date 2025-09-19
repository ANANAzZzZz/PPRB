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
import suai.vladislav.pprbhack.dto.AdvertisementDto;
import suai.vladislav.pprbhack.service.interfaces.AdvertisementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.getAdvertisements();
    }

    @GetMapping("/{advertisementId}")
    public AdvertisementDto getAdvertisement(
        @PathVariable("advertisementId") Long advertisementId
    ) {
        return advertisementService.getAdvertisementById(advertisementId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdvertisementDto addAdvertisement(
        @Validated
        @RequestBody AdvertisementDto advertisementDto
    ) {
        return advertisementService.addAdvertisement(advertisementDto);
    }

    @PutMapping
    public AdvertisementDto updateAdvertisement(
        @Validated
        @RequestBody AdvertisementDto advertisementDto
    ) {
        return advertisementService.updateAdvertisement(advertisementDto);
    }

    @DeleteMapping("/{advertisementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdvertisement(
        @PathVariable("advertisementId") Long advertisementId
    ) {
        advertisementService.deleteAdvertisement(advertisementId);
    }
}
