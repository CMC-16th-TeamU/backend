package project.backend.api.regret.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MyRegretRequest {
  @NotNull(message = "회원 ID를 입력해주세요.")
  private Long userId;
}
