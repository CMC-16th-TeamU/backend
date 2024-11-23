package project.backend.application.regret.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegretServiceRequest {
  private Long userId;
  private String regretContent;

  public static UserRegretServiceRequest from(Long userId, String regretContent) {
    return UserRegretServiceRequest.builder()
                                   .userId(userId)
                                   .regretContent(regretContent)
                                   .build();
  }
}
