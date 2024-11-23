package project.backend.application.user.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateServiceRequest {
  private final Long userId;
  private final String major;
  private final String field;
}
