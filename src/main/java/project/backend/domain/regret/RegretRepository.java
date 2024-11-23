package project.backend.domain.regret;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.backend.application.filtering.response.RegretsListDto;
import project.backend.domain.user.User;

import java.util.List;

public interface RegretRepository extends JpaRepository<Regret, Long> {

    @Query("SELECT r FROM Regret r JOIN r.user u " +
            "WHERE u.birthDate = :birthDate AND u.gender = :gender AND u.field = :field AND u.major = :major")
    Page<RegretsListDto> findRegretsByUserAttributes(@Param("age") String birthDate,
                                                     @Param("gender") String gender,
                                                     @Param("field") String field,
                                                     @Param("major") String major,
                                                     Pageable pageable);
}
