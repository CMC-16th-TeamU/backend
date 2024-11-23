package project.backend.application.regret.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import project.backend.application.regret.response.dto.UserRegretDto;

@Getter
@Builder
public class UserRegretListResponse {

  private boolean isLast;
  private int totalPage;
  private long totalElement;
  private List<UserRegretDto> regrets;

  public static UserRegretListResponse from(boolean isLast, int totalPage, long totalElement,
      List<UserRegretDto> regrets) {
    return UserRegretListResponse.builder()
                                 .isLast(isLast)
                                 .totalPage(totalPage)
                                 .totalElement(totalElement)
                                 .regrets(regrets)
                                 .build();
  }
}
