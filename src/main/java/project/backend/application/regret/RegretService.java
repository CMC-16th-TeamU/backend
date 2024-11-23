package project.backend.application.regret;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.application.regret.request.RegretCreateServiceRequest;
import project.backend.application.regret.response.RegretCreateResponse;
import project.backend.domain.regret.Regret;
import project.backend.domain.regret.repository.RegretRepository;
import project.backend.domain.user.User;
import project.backend.domain.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class RegretService {

  private final RegretRepository regretRepository;
  private final UserRepository userRepository;

  @Transactional
  public RegretCreateResponse createRegret(RegretCreateServiceRequest request) {
    //Todo : 예외 처리 예정
    User user =
        userRepository.findById(request.getUserId())
                      .orElseThrow(RuntimeException::new);

    Regret regret = Regret.builder()
                          .regretContent(request.getRegretContent())
                          .user(user)
                          .build();

    Regret savedRegret = regretRepository.save(regret);
    return RegretCreateResponse.from(savedRegret);
  }
}
