package suai.vladislav.pprbhack.dto;

public record AdvertisementDto(
    Long id,
    String name,
    String description,
    Long ownerId
) {
}
