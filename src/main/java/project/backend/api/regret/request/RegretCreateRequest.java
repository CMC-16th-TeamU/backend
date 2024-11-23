package project.backend.api.regret.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import project.backend.application.regret.request.RegretCreateServiceRequest;

@Getter
public class RegretCreateRequest {

  @NotNull(message = "회원 ID를 입력해주세요.")
  private Long userId;

  @NotBlank(message = "회고 내용을 입력해주세요.")
  private String regretContent;

  public RegretCreateServiceRequest toServiceRequest() {
    return RegretCreateServiceRequest.builder()
                                     .userId(userId)
                                     .regretContent(regretContent)
                                     .build();
  }
}
