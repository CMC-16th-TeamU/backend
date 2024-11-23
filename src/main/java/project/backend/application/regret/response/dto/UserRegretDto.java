package project.backend.application.regret.response.dto;

import lombok.Builder;
import lombok.Getter;
import project.backend.domain.regret.Regret;

@Getter
@Builder
public class UserRegretDto {

  private String regretContent;

  public static UserRegretDto from(Regret regret) {
    return UserRegretDto.builder()
                        .regretContent(regret.getRegretContent())
                        .build();
  }
}
