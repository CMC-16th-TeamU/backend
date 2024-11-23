package project.backend.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(nullable = false)
  private String nickname;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private Integer age;

  @Column
  private String gender;

  @Column
  private String major;

  @Column
  private String field;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserStatus status;

  @Builder
  private User(String nickname, String email, String profileImageUrl, Integer age, String gender, String major, String field, UserStatus status) {
    this.nickname = nickname;
    this.email = email;
    this.age = age;
    this.gender = gender;
    this.major = major;
    this.field = field;
    this.status = status;
  }

  public static User createUser(String email, String nickname, String profileImageUrl, Integer age, String gender, String major, String field, UserStatus status) {
    return User.builder()
               .email(email)
               .nickname(nickname)
               .profileImageUrl(profileImageUrl)
               .age(age)
               .gender(gender)
               .major(major)
               .field(field)
               .status(status)
               .build();
  }

  public void withdraw() {
    this.setActivated(false);
    this.email = null;
  }

  public enum UserStatus {
    STUDENT, EMPLOYEE
  }
}
