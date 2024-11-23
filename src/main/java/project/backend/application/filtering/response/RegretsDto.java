package project.backend.application.filtering.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.regret.Regret;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RegretsDto {

    private String content;

    public static RegretsDto of(Regret regret) {
        return RegretsDto.builder()
                .content(regret.getRegretContent())
                .build();
    }


}
