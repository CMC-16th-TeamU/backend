package project.backend.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.application.user.request.UserInfoDto;
import project.backend.domain.user.User;
import project.backend.domain.user.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserInfoDto infoDto) {
        if (userRepository.existsByEmail(infoDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        userRepository.save(User.createUser(infoDto));
    }

}

