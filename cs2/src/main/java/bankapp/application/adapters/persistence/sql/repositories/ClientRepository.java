package bankapp.application.adapters.persistence.sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByDocument(String document);
    boolean existsByEmail(String email);

    Optional<ClientEntity> findByDocument(String document);

    void deleteByDocument(String document);
}