package project.backend.api.regret;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.regret.request.MyRegretRequest;
import project.backend.api.regret.request.RegretCreateRequest;
import project.backend.application.regret.RegretService;
import project.backend.application.regret.response.MyRegretListResponse;
import project.backend.application.regret.response.RegretCreateResponse;

@RestController
@RequestMapping("/regrets")
@RequiredArgsConstructor
@Tag(name="회고 관련 기능", description = "회고 관련 API 입니다.")
public class RegretController {

  private final RegretService regretService;

  @Operation(summary = "회고 등록 api")
  @PostMapping
  public RegretCreateResponse createRegret(@Valid @RequestBody RegretCreateRequest regretCreateRequest) {
    return regretService.createRegret(regretCreateRequest.toServiceRequest());
  }

  @Operation(summary = "회고 등록 api")
  @GetMapping("/my")
  public MyRegretListResponse getMyRegrets(@Valid @RequestBody MyRegretRequest request,
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    return regretService.getMyRegrets(request.getUserId(), page, size);
  }
}
