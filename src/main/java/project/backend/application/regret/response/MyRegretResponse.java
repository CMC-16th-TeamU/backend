package project.backend.application.regret.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import project.backend.domain.regret.Regret;

@Getter
@Builder
public class MyRegretResponse {

  private LocalDateTime createdAt;
  private String regretContent;

  public static MyRegretResponse from(Regret regret) {
    return MyRegretResponse.builder()
                           .createdAt(regret.getCreatedAt())
                           .regretContent(regret.getRegretContent())
                           .build();
  }
}
