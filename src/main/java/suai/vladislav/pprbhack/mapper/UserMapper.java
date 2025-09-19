package suai.vladislav.pprbhack.mapper;

import org.springframework.stereotype.Component;
import suai.vladislav.pprbhack.dto.UserDto;
import suai.vladislav.pprbhack.model.User;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
            user.getId(),
            user.getRole(),
            user.getEmail(),
            user.getPassword(),
            user.getLastName(),
            user.getFirstName(),
            user.getAddress(),
            user.getRating()
        );
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.id());
        user.setRole(userDto.role());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setLastName(userDto.lastName());
        user.setFirstName(userDto.firstName());
        user.setAddress(userDto.address());
        user.setRating(userDto.rating());

        return user;
    }
}
