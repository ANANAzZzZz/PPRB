package suai.vladislav.pprbhack.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
    String errorMessage
) {
}
