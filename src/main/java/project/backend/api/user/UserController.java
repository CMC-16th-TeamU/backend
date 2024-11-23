package project.backend.api.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.backend.api.ApiResponse;
import project.backend.api.user.request.UserCreateRequest;
import project.backend.api.user.request.UserUpdateRequest;
import project.backend.application.user.UserService;
import project.backend.application.user.response.UserCreateResponse;
import project.backend.application.user.response.UserUpdateResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "회원 관리", description = "회원 생성 및 관리 API")
public class UserController {

  private final UserService userService;

  @Operation(summary = "회원 생성 API", description = "회원 정보를 받아 회원을 생성합니다.")
  @PostMapping
  public ApiResponse<UserCreateResponse> createUser(
      @Valid @RequestBody UserCreateRequest request) {
    UserCreateResponse response = userService.createUser(request.toServiceRequest());
    return ApiResponse.OK(response);
  }

  @Operation(summary = "회원 분야 및 직업 수정 API", description = "회원의 분야와 직업을 수정합니다.")
  @PatchMapping("/{id}/field-major")
  public ApiResponse<UserUpdateResponse> updateFieldAndMajor(
      @PathVariable Long id,
      @Valid @RequestBody UserUpdateRequest request) {
    UserUpdateResponse response = userService.updateFieldAndMajor(request.toServiceRequest(id));
    return ApiResponse.OK(response);
  }
}
