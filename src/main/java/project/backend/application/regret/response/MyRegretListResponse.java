package project.backend.application.regret.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyRegretListResponse {

  private boolean isLast;
  private int totalPage;
  private long totalElement;
  private List<MyRegretResponse> regrets;

  public static MyRegretListResponse from(boolean isLast, int totalPage, long totalElement,
      List<MyRegretResponse> regrets) {
    return MyRegretListResponse.builder()
                               .isLast(isLast)
                               .totalPage(totalPage)
                               .totalElement(totalElement)
                               .regrets(regrets)
                               .build();
  }
}
