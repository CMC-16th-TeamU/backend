package project.backend.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.application.user.request.UserCreateServiceRequest;
import project.backend.application.user.request.UserUpdateServiceRequest;
import project.backend.application.user.response.UserCreateResponse;
import project.backend.application.user.response.UserUpdateResponse;
import project.backend.domain.user.User;
import project.backend.domain.user.repository.UserRepository;
import project.backend.exception.BusinessException;
import project.backend.exception.ErrorCode;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserCreateResponse createUser(UserCreateServiceRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .major(request.getMajor())
                .field(request.getField())
                .build();

        User savedUser = userRepository.save(user);

        return UserCreateResponse.from(savedUser);
    }

    @Transactional
    public UserUpdateResponse updateFieldAndMajor(UserUpdateServiceRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        user.updateFieldAndMajor(request.getMajor(), request.getField());

        return UserUpdateResponse.from(user);
    }
}