package project.backend.api.regret;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.backend.api.ApiResponse;
import project.backend.api.regret.request.RegretCreateRequest;
import project.backend.application.regret.request.FilterOptionsDto;
import project.backend.application.regret.RegretService;
import project.backend.application.regret.response.UserRegretListResponse;
import project.backend.application.regret.response.RegretCreateResponse;

@RestController
@RequestMapping("/regrets")
@RequiredArgsConstructor
@Tag(name = "회고 관련 기능", description = "회고 관련 API 입니다.")
public class RegretController {

  private final RegretService regretService;

  @Operation(summary = "회고 등록 API")
  @PostMapping
  public ApiResponse<RegretCreateResponse> createRegret(
      @Valid @RequestBody RegretCreateRequest regretCreateRequest) {
    return ApiResponse.OK(regretService.createRegret(regretCreateRequest.toServiceRequest()));
  }

  @Operation(summary = "사용자의 회고 조회 API")
  @GetMapping("/users/{userId}")
  public ApiResponse<UserRegretListResponse> getUserRegrets(
      @PathVariable Long userId,
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    return ApiResponse.OK(regretService.getUserRegrets(userId, page, size));
  }

  @Operation(summary = "회고 필터 api")
  @PostMapping("/filter")
  public ApiResponse<UserRegretListResponse> getRegretsFilter(@Valid @RequestBody FilterOptionsDto filterOptionsDto,
                                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "10") int size) {

    return ApiResponse.OK(regretService.findRegretsByUserAttributes(filterOptionsDto, page, size));
  }
}
