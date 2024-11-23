package project.backend.application.regret.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class FilterOptionsDto { // 나이, 성별, 분야, 직군, 정렬방식(디폴트는 최신순)
    @NotNull
    private String birthDate;

    @NotNull
    private String gender;

    private String major;

    private String field;

    private String sortBy; // ASC, DESC
}
