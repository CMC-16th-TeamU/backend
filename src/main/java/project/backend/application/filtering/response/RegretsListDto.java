package project.backend.application.filtering.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RegretsListDto {
    private boolean isLast;
    private int totalPage;
    private long totalElement;
    private List<RegretsDto> regrets;

    public static RegretsListDto of(boolean isLast, int totalPage, long totalElement,List<RegretsDto> regrets ){
        return RegretsListDto.builder()
                .isLast(isLast)
                .totalPage(totalPage)
                .totalElement(totalElement)
                .regrets(regrets)
                .build();
    }
}
