package project.backend.application.user.response;

import lombok.Builder;
import lombok.Getter;
import project.backend.domain.user.User;

@Getter
@Builder
public class UserCreateResponse {
  private final Long id;
  private final String email;
  private final String gender;
  private final String birthDate;

  public static UserCreateResponse from(User user) {
    return UserCreateResponse.builder()
                             .id(user.getId())
                             .email(user.getEmail())
                             .gender(user.getGender())
                             .birthDate(user.getBirthDate())
                             .build();
  }
}
