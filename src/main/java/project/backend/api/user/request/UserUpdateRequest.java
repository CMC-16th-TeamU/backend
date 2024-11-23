package project.backend.api.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import project.backend.application.user.request.UserUpdateServiceRequest;

@Getter
public class UserUpdateRequest {

  @NotNull(message = "회원 ID를 입력해주세요.")
  private Long userId;

  @NotBlank(message = "직업을 입력해주세요.")
  private String major;

  @NotBlank(message = "분야를 입력해주세요.")
  private String field;

  public UserUpdateServiceRequest toServiceRequest() {
    return UserUpdateServiceRequest.builder()
                                   .userId(userId)
                                   .major(major)
                                   .field(field)
                                   .build();
  }
}
