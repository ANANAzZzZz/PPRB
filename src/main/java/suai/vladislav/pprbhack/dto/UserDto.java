package suai.vladislav.pprbhack.dto;

import suai.vladislav.pprbhack.enums.UserRole;

public record UserDto(
    Long id,
    UserRole role,
    String email,
    String password,
    String lastName,
    String firstName,
    String address,
    Float rating
) {
}
