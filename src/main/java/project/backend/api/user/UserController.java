package project.backend.api.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="로그인 기능", description = "사용자 정보를 받아 DB에 저장합니다. ")
public class UserController {

    private final UserService userService;

    @Operation(summary = "사용자 등록 api")
    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody UserInfoDto userInfoDto) {
        userService.saveUser(userInfoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}