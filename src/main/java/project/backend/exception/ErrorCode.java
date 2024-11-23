package project.backend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
  DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "중복된 이메일입니다."),
  NO_REGRETS_FOUND(HttpStatus.NOT_FOUND, "조회된 회고가 없습니다."),
  EMPTY_RESPONSE(HttpStatus.NO_CONTENT, "결과가 비어 있습니다.");

  private final HttpStatus status;
  private final String message;
}
