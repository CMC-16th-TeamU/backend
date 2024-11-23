package project.backend.domain.regret.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.regret.Regret;

@Repository
public interface RegretRepository extends JpaRepository<Regret, Long> {

}
