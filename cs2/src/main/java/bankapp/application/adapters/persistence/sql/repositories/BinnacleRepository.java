package bankapp.application.adapters.persistence.sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bankapp.application.adapters.persistence.sql.entities.BinnacleEntity;

@Repository
public interface BinnacleRepository extends JpaRepository<BinnacleEntity, Long> {

}