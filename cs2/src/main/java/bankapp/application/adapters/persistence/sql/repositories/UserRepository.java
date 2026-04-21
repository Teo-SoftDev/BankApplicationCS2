package bankapp.application.adapters.persistence.sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bankapp.application.adapters.persistence.sql.entities.UserEntity;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByDocument(String document);

    Optional<UserEntity> findByDocument(String document);

    void deleteByDocument(String document);
}
