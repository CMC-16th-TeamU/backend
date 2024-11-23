package project.backend.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String gender;

  @Column(nullable = false)
  private String birthDate; // "생년월일"을 문자열로 저장 (예: "YYYY-MM-DD")

  @Column(nullable = false)
  private String major; // "직업"

  @Column(nullable = false)
  private String field; // "분야"

  @Builder
  private User(String email, String password, String gender, String birthDate, String major, String field) {
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.birthDate = birthDate;
    this.major = major;
    this.field = field;
  }

  public void updateFieldAndMajor(String major, String field) {
    if (major != null && !major.isBlank()) {
      this.major = major;
    }
    if (field != null && !field.isBlank()) {
      this.field = field;
    }
  }
}