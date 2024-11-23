package project.backend.application.filtering.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RegretsListDto {
    private List<RegretsDto> regrets; // 여러 개의 회고를 담는 리스트
}
