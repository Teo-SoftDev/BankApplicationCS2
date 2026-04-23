package bankapp.application.adapters.persistence.sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bankapp.application.adapters.persistence.sql.entities.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}
