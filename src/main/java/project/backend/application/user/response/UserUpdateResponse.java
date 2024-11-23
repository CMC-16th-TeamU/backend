package project.backend.application.user.response;

import lombok.Builder;
import lombok.Getter;
import project.backend.domain.user.User;

@Getter
@Builder
public class UserUpdateResponse {
  private final Long id;
  private final String major;
  private final String field;

  public static UserUpdateResponse from(User user) {
    return UserUpdateResponse.builder()
                             .id(user.getId())
                             .major(user.getMajor())
                             .field(user.getField())
                             .build();
  }
}
