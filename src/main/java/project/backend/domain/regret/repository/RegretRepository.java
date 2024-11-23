package project.backend.domain.regret.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.backend.domain.regret.Regret;
import project.backend.domain.user.User;

@Repository
public interface RegretRepository extends JpaRepository<Regret, Long> {
  Page<Regret> findAllByUser(User user, Pageable pageable);

  @Query("SELECT r FROM Regret r JOIN r.user u " +
          "WHERE u.birthDate = :birthDate AND u.gender = :gender AND (u.field = :field OR u.major = :major)")
  Page<Regret> findRegretsByUserAttributes(@Param("birthDate") String birthDate,
                                                   @Param("gender") String gender,
                                                   @Param("field") String field,
                                                   @Param("major") String major,
                                                   Pageable pageable);
}
