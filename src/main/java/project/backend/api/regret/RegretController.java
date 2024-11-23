package project.backend.api.regret;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.regret.request.RegretCreateRequest;
import project.backend.application.regret.RegretService;
import project.backend.application.regret.response.RegretCreateResponse;

@RestController
@RequestMapping("/regrets")
@RequiredArgsConstructor
public class RegretController {

  private final RegretService regretService;

  @PostMapping
  public RegretCreateResponse createRegret(@RequestBody RegretCreateRequest regretCreateRequest) {
    return regretService.createRegret(regretCreateRequest.toServiceRequest());
  }
}
