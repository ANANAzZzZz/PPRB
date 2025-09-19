package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.AdvertisementDto;
import suai.vladislav.pprbhack.model.Advertisement;

@Component
public class AdvertisementMapper {

    public AdvertisementDto toDto(Advertisement advertisement) {
        if (advertisement == null) {
            return null;
        }

        return new AdvertisementDto(
            advertisement.getId(),
            advertisement.getName(),
            advertisement.getDescription(),
            advertisement.getOwner() != null ? advertisement.getOwner().getId() : null
        );
    }

    public Advertisement toEntity(AdvertisementDto advertisementDto) {
        if (advertisementDto == null) {
            return null;
        }

        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementDto.id());
        advertisement.setName(advertisementDto.name());
        advertisement.setDescription(advertisementDto.description());

        return advertisement;
    }
}
