package project.backend.api.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import project.backend.application.user.request.UserCreateServiceRequest;

@Getter
public class UserCreateRequest {

  @NotBlank(message = "이메일을 입력해주세요.")
  private String email;

  @NotBlank(message = "비밀번호를 입력해주세요.")
  private String password;

  @NotBlank(message = "닉네임을 입력해주세요.")
  private String nickname;

  @NotNull(message = "나이를 입력해주세요.")
  private Integer age;

  private String gender;

  private String major;

  private String field;

  @NotBlank(message = "상태를 입력해주세요.")
  @Pattern(regexp = "STUDENT|EMPLOYEE", message = "올바른 상태값을 입력해주세요.")
  private String status;

  public UserCreateServiceRequest toServiceRequest() {
    return UserCreateServiceRequest.builder()
                                   .email(this.email)
                                   .password(this.password)
                                   .nickname(this.nickname)
                                   .age(this.age)
                                   .gender(this.gender)
                                   .major(this.major)
                                   .field(this.field)
                                   .status(this.status)
                                   .build();
  }
}
