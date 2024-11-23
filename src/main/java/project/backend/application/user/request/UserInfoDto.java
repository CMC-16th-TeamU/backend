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
    private Integer age;

    @NotNull
    private String gender;

    // 선택정보
    private String major;

    private String field;

    private User.UserStatus status;

    public static UserInfoDto of(String email, String password, Integer age, String gender, String major, String field, User.UserStatus status) {
        return UserInfoDto.builder()
                .email(email)
                .password(password)
                .age(age)
                .gender(gender)
                .major(major)
                .field(field)
                .status(status)
                .build();
    }

}