package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.AdvertisementDto;
import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> getAdvertisements();
    AdvertisementDto getAdvertisementById(Long id);
    AdvertisementDto addAdvertisement(AdvertisementDto advertisementDto);
    AdvertisementDto updateAdvertisement(AdvertisementDto advertisementDto);
    void deleteAdvertisement(Long id);
}
