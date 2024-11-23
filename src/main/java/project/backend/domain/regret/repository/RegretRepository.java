package project.backend.domain.regret.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.regret.Regret;
import project.backend.domain.user.User;

@Repository
public interface RegretRepository extends JpaRepository<Regret, Long> {
  Page<Regret> findAllByUser(User user, Pageable pageable);
}
