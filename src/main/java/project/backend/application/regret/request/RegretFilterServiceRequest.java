package project.backend.application.regret.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegretFilterServiceRequest {

  private final String birthDate;
  private final String gender;
  private final String major;
  private final String field;
  private final String sortBy;
}
