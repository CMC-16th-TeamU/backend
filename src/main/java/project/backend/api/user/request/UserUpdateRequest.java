package project.backend.api.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import project.backend.application.user.request.UserUpdateServiceRequest;

@Getter
public class UserUpdateRequest {

  @NotBlank(message = "직업을 입력해주세요.")
  private String major;

  @NotBlank(message = "분야를 입력해주세요.")
  private String field;

  public UserUpdateServiceRequest toServiceRequest(Long userId) {
    return UserUpdateServiceRequest.builder()
                                   .userId(userId)
                                   .major(this.major)
                                   .field(this.field)
                                   .build();
  }
}
