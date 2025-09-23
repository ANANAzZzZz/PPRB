package suai.vladislav.pprbhack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import suai.vladislav.pprbhack.dto.UserDto;
import suai.vladislav.pprbhack.enums.ErrorType;
import suai.vladislav.pprbhack.exception.CommonPPRBApiException;
import suai.vladislav.pprbhack.mapper.UserMapper;
import suai.vladislav.pprbhack.model.User;
import suai.vladislav.pprbhack.repository.UserRepository;
import suai.vladislav.pprbhack.service.interfaces.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toDto)
            .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.email()).isPresent()) {
            throw new CommonPPRBApiException(ErrorType.USER_ALREADY_EXISTS, userDto.email());
        }

        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        if (userDto.id() == null) {
            throw new CommonPPRBApiException(ErrorType.ID_IS_MISSING);
        }

        User existingUser = userRepository.findById(userDto.id())
            .orElseThrow(() -> new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, userDto.id()));

        User updatedUser = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(updatedUser);
        return userMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new CommonPPRBApiException(ErrorType.USER_NOT_FOUND, id);
        }
        userRepository.deleteById(id);
    }
}
