package project.backend.api.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import project.backend.application.user.request.UserCreateServiceRequest;

@Getter
public class UserCreateRequest {

  @NotBlank(message = "이메일을 입력해주세요.")
  @Email(message = "유효한 이메일을 입력해주세요.")
  private String email;

  @NotBlank(message = "비밀번호를 입력해주세요.")
  private String password;

  @NotBlank(message = "성별을 입력해주세요.")
  private String gender;

  @NotBlank(message = "태어난 연도를 입력해주세요.")
  private String birthDate;

  @NotBlank(message = "직업을 입력해주세요.")
  private String major;

  @NotBlank(message = "분야를 입력해주세요.")
  private String field;

  public UserCreateServiceRequest toServiceRequest() {
    return UserCreateServiceRequest.builder()
                                   .email(this.email)
                                   .password(this.password)
                                   .gender(this.gender)
                                   .birthDate(this.birthDate)
                                   .major(this.major)
                                   .field(this.field)
                                   .build();
  }
}
