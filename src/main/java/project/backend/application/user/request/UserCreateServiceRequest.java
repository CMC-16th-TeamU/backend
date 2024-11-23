package project.backend.application.user.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateServiceRequest {
  private final String email;
  private final String password;
  private final String nickname;
  private final Integer age;
  private final String gender;
  private final String major;
  private final String field;
  private final String status;
}
