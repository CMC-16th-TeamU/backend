package project.backend.api.regret.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import project.backend.application.regret.request.RegretFilterServiceRequest;

@Getter
public class RegretFilterRequest {

  @NotBlank(message = "생년월일을 입력해주세요.")
  private String birthDate;

  @NotBlank(message = "성별을 입력해주세요.")
  private String gender;

  private String major;

  private String field;

  private String sortBy;

  public RegretFilterServiceRequest toServiceRequest() {
    return RegretFilterServiceRequest.builder()
                                     .birthDate(birthDate)
                                     .gender(gender)
                                     .major(major)
                                     .field(field)
                                     .sortBy(sortBy)
                                     .build();
  }
}
