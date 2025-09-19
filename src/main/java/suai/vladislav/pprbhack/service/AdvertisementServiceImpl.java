package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.AdvertisementDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.AdvertisementMapper;
import suai.vladislav.pprbhack.model.Advertisement;
import suai.vladislav.pprbhack.repository.AdvertisementRepository;
import suai.vladislav.pprbhack.repository.UserRepository;
import suai.vladislav.pprbhack.service.interfaces.AdvertisementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserRepository userRepository;
    private final AdvertisementMapper advertisementMapper;

    @Override
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementRepository.findAll()
            .stream()
            .map(advertisementMapper::toDto)
            .toList();
    }

    @Override
    public AdvertisementDto getAdvertisementById(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.ADVERTISEMENT_NOT_FOUND, id));
        return advertisementMapper.toDto(advertisement);
    }

    @Override
    public AdvertisementDto addAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = advertisementMapper.toEntity(advertisementDto);

        if (advertisementDto.ownerId() != null) {
            advertisement.setOwner(userRepository.findById(advertisementDto.ownerId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, advertisementDto.ownerId())));
        }

        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        return advertisementMapper.toDto(savedAdvertisement);
    }

    @Override
    public AdvertisementDto updateAdvertisement(AdvertisementDto advertisementDto) {
        if (advertisementDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        Advertisement existingAdvertisement = advertisementRepository.findById(advertisementDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.ADVERTISEMENT_NOT_FOUND, advertisementDto.id()));

        Advertisement updatedAdvertisement = advertisementMapper.toEntity(advertisementDto);

        if (advertisementDto.ownerId() != null) {
            updatedAdvertisement.setOwner(userRepository.findById(advertisementDto.ownerId())
                .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, advertisementDto.ownerId())));
        }

        Advertisement savedAdvertisement = advertisementRepository.save(updatedAdvertisement);
        return advertisementMapper.toDto(savedAdvertisement);
    }

    @Override
    public void deleteAdvertisement(Long id) {
        if (!advertisementRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.ADVERTISEMENT_NOT_FOUND, id);
        }
        advertisementRepository.deleteById(id);
    }
}
