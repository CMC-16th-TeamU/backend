package project.backend.application.regret.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import project.backend.domain.regret.Regret;

@Getter
@Builder
public class UserRegretResponse {

  private LocalDateTime createdAt;
  private String regretContent;

  public static UserRegretResponse from(Regret regret) {
    return UserRegretResponse.builder()
                             .createdAt(regret.getCreatedAt())
                             .regretContent(regret.getRegretContent())
                             .build();
  }
}
