package project.backend.api.regret.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import project.backend.application.regret.request.UserRegretServiceRequest;

@Getter
public class UserRegretRequest {

  @NotNull(message = "회원 ID를 입력해주세요.")
  private Long userId;

  public UserRegretServiceRequest toServiceRequest() {
    return UserRegretServiceRequest.builder()
                                   .userId(userId)
                                   .build();
  }
}
