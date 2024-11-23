package project.backend.application.regret;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.application.regret.request.FilterOptionsDto;
import project.backend.application.regret.request.RegretCreateServiceRequest;
import project.backend.application.regret.response.UserRegretListResponse;
import project.backend.application.regret.response.RegretCreateResponse;
import project.backend.application.regret.response.dto.UserRegretDto;
import project.backend.domain.regret.Regret;
import project.backend.domain.regret.repository.RegretRepository;
import project.backend.domain.user.User;
import project.backend.domain.user.repository.UserRepository;
import project.backend.exception.BusinessException;
import project.backend.exception.ErrorCode;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class RegretService {

  private final RegretRepository regretRepository;
  private final UserRepository userRepository;

  @Transactional
  public RegretCreateResponse createRegret(RegretCreateServiceRequest request) {
    User user = userRepository.findById(request.getUserId())
                              .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

    Regret regret = Regret.builder()
                          .regretContent(request.getRegretContent())
                          .user(user)
                          .build();

    Regret savedRegret = regretRepository.save(regret);
    return RegretCreateResponse.from(savedRegret);
  }

  public UserRegretListResponse getUserRegrets(Long userId, int page, int size) {
    User user = userRepository.findById(userId)
                              .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    PageRequest pageRequest = PageRequest.of(page, size);

    Page<Regret> userRegrets = regretRepository.findAllByUser(user, pageRequest);

    boolean isLast = userRegrets.isLast();
    int totalPages = userRegrets.getTotalPages();
    long totalElements = userRegrets.getTotalElements();

    List<UserRegretDto> regretResponses =
        userRegrets.stream().map(UserRegretDto::from).toList();

    return UserRegretListResponse.from(isLast, totalPages, totalElements, regretResponses);
  }

  public UserRegretListResponse findRegretsByUserAttributes(FilterOptionsDto filterOptionsDto, int page, int size) {

    String sortBy = filterOptionsDto.getSortBy() != null && filterOptionsDto.getSortBy().equalsIgnoreCase("ASC") ? "ASC" : "DESC";

    Sort sort = Sort.by(new Sort.Order(Sort.Direction.fromString(sortBy), "createdAt"));

    PageRequest pageRequest = PageRequest.of(page, size, sort);

    Page<Regret> regrets = regretRepository.findRegretsByUserAttributes(
            filterOptionsDto.getBirthDate(),
            filterOptionsDto.getGender(),
            filterOptionsDto.getField(),
            filterOptionsDto.getMajor(),
            pageRequest
    );

    boolean isLast = regrets.isLast();
    int totalPage = regrets.getTotalPages();
    long totalElement = regrets.getTotalElements();

    List<UserRegretDto> regretResponses = regrets.stream().map(UserRegretDto::from).toList();

    return UserRegretListResponse.from(isLast, totalPage, totalElement, regretResponses);
  }
}
