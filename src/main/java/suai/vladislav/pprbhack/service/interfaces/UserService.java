package suai.vladislav.pprbhack.service.interfaces;

import suai.vladislav.pprbhack.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(Long id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
}
