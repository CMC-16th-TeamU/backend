package project.backend.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.application.user.UserService;
import project.backend.application.user.request.UserInfoDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody UserInfoDto userInfoDto) {
        userService.saveUser(userInfoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}