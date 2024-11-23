package project.backend.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {

  private final int code;
  private final String message;
  private final T data;

  private ApiResponse(HttpStatus status, String message, T data) {
    this.code = status.value();
    this.message = message;
    this.data = data;
  }

  public static <T> ApiResponse<T> OK(T data) {
    return new ApiResponse<>(HttpStatus.OK, "요청이 성공적으로 처리되었습니다.", data);
  }

  public static ApiResponse<Void> OK() {
    return new ApiResponse<>(HttpStatus.OK, "요청이 성공적으로 처리되었습니다.", null);
  }

  public static <T> ApiResponse<T> OK(HttpStatus status, String message, T data) {
    return new ApiResponse<>(status, message, data);
  }

  public static ApiResponse<Void> OK(HttpStatus status, String message) {
    return new ApiResponse<>(status, message, null);
  }
}
