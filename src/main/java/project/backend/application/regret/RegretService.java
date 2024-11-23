package project.backend.application.regret;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.application.regret.request.RegretCreateServiceRequest;
import project.backend.application.regret.request.RegretFilterServiceRequest;
import project.backend.application.regret.response.RegretCreateResponse;
import project.backend.application.regret.response.UserRegretListResponse;
import project.backend.application.regret.response.dto.UserRegretDto;
import project.backend.domain.regret.Regret;
import project.backend.domain.regret.repository.RegretRepository;
import project.backend.domain.user.User;
import project.backend.domain.user.repository.UserRepository;
import project.backend.exception.BusinessException;
import project.backend.exception.ErrorCode;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegretService {

  private final RegretRepository regretRepository;
  private final UserRepository userRepository;

  @Transactional
  public RegretCreateResponse createRegret(RegretCreateServiceRequest request) {
    User user = getUserById(request.getUserId());

    Regret regret = buildRegret(request.getRegretContent(), user);

    Regret savedRegret = regretRepository.save(regret);
    return RegretCreateResponse.from(savedRegret);
  }

  @Transactional
  public UserRegretListResponse getUserRegrets(Long userId, int page, int size) {
    User user = getUserById(userId);

    PageRequest pageRequest = PageRequest.of(page, size);

    Page<Regret> userRegrets = regretRepository.findAllByUser(user, pageRequest);

    if (userRegrets.isEmpty()) {
      throw new BusinessException(ErrorCode.NO_REGRETS_FOUND);
    }

    return buildUserRegretListResponse(userRegrets);
  }

  @Transactional
  public UserRegretListResponse getRegretsByFilter(RegretFilterServiceRequest request, int page, int size) {
    Sort sort = getSortOrder(request.getSortBy());
    PageRequest pageRequest = PageRequest.of(page, size, sort);

    Page<Regret> regrets = regretRepository.findRegretsByUserAttributes(
        request.getBirthDate(),
        request.getGender(),
        request.getField(),
        request.getMajor(),
        pageRequest
    );

    if (regrets.isEmpty()) {
      throw new BusinessException(ErrorCode.NO_REGRETS_FOUND);
    }

    return buildUserRegretListResponse(regrets);
  }

  private User getUserById(Long userId) {
    return userRepository.findById(userId)
                         .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
  }

  private Regret buildRegret(String regretContent, User user) {
    return Regret.builder()
                 .regretContent(regretContent)
                 .user(user)
                 .build();
  }

  private Sort getSortOrder(String sortBy) {
    String sortDirection = (sortBy != null && sortBy.equalsIgnoreCase("ASC")) ? "ASC" : "DESC";
    return Sort.by(Sort.Direction.fromString(sortDirection), "createdAt");
  }

  private UserRegretListResponse buildUserRegretListResponse(Page<Regret> regrets) {
    boolean isLast = regrets.isLast();
    int totalPages = regrets.getTotalPages();
    long totalElements = regrets.getTotalElements();

    List<UserRegretDto> regretResponses = regrets.stream()
                                                 .map(UserRegretDto::from)
                                                 .toList();

    return UserRegretListResponse.from(isLast, totalPages, totalElements, regretResponses);
  }
}
