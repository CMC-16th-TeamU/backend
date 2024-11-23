package project.backend.application.regret.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegretCreateServiceRequest {

  private final Long userId;
  private final String regretContent;
}
