package project.backend.application.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.backend.domain.user.User;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoDto {
    // 필수정보
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    private String birthDate;

    @NotNull
    private String gender;

    // 선택정보
    private String major;

    private String field;

    public static UserInfoDto of(String email, String password, String birthDate, String gender, String major, String field) {
        return UserInfoDto.builder()
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .gender(gender)
                .major(major)
                .field(field)
                .build();
    }

}