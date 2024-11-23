package project.backend.application.regret.response;

import lombok.Builder;
import lombok.Getter;
import project.backend.domain.regret.Regret;

@Getter
@Builder
public class RegretCreateResponse {
  private final Long regretId;

  public static RegretCreateResponse from(Regret regret) {
    return RegretCreateResponse.builder()
                               .regretId(regret.getId())
                               .build();
  }
}
