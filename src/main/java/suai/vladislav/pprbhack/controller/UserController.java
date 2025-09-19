//package suai.vladislav.pprbhack.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import suai.vladislav.pprbhack.dto.UserDto;
//import suai.vladislav.pprbhack.service.interfaces.UserService;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/user")
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping
//    public List<UserDto> getUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{userId}")
//    public UserDto getUser(
//        @PathVariable("userId") Long userId
//    ) {
//        return userService.getUserById(userId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserDto addUser(
//        @Validated
//        @RequestBody UserDto userDto
//    ) {
//        return userService.addUser(userDto);
//    }
//
//    @PutMapping
//    public UserDto updateUser(
//        @Validated
//        @RequestBody UserDto userDto
//    ) {
//        return userService.updateUser(userDto);
//    }
//
//    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUser(
//        @PathVariable("userId") Long userId
//    ) {
//        userService.deleteUser(userId);
//    }
//}
