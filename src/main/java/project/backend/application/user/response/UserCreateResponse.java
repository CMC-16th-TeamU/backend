package project.backend.application.user.response;

import lombok.Builder;
import lombok.Getter;
import project.backend.domain.user.User;

@Getter
@Builder
public class UserCreateResponse {
  private final Long id;
  private final String email;
  private final String nickname;
  private final String status;

  public static UserCreateResponse from(User user) {
    return UserCreateResponse.builder()
                             .id(user.getId())
                             .email(user.getEmail())
                             .nickname(user.getNickname())
                             .status(user.getStatus().name())
                             .build();
  }
}
