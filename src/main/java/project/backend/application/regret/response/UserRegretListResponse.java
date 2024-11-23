package project.backend.application.regret.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegretListResponse {

  private boolean isLast;
  private int totalPage;
  private long totalElement;
  private List<UserRegretResponse> regrets;

  public static UserRegretListResponse from(boolean isLast, int totalPage, long totalElement,
      List<UserRegretResponse> regrets) {
    return UserRegretListResponse.builder()
                                 .isLast(isLast)
                                 .totalPage(totalPage)
                                 .totalElement(totalElement)
                                 .regrets(regrets)
                                 .build();
  }
}
