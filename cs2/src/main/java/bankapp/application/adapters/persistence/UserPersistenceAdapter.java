package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.UserPort;
import bankapp.domain.models.Role;
import bankapp.domain.models.User;
import bankapp.domain.models.UserState;
import bankapp.application.adapters.persistence.sql.repositories.UserRepository;
import bankapp.application.adapters.persistence.sql.entities.UserEntity;

@Service
public class UserPersistenceAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existsByDocument(String document) {
        return userRepository.existsByDocument(document);
    }

    @Override
    public void saveUser(User user) {
        UserEntity entity = mapToEntity(user);
        userRepository.save(entity);
        // Update the user ID if it was generated
        user.setId(entity.getId());
    }

    @Override
    public void updateUser(User user) {
        UserEntity entity = mapToEntity(user);
        userRepository.save(entity);
    }

    @Override
    public User findByDocument(String document) {
        UserEntity entity = userRepository.findByDocument(document)
            .orElseThrow(() -> new RuntimeException("User not found with document: " + document));
        return mapToDomain(entity);
    }

    @Override
    public void deleteUser(String document) {
        userRepository.deleteByDocument(document);
    }

    private UserEntity mapToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDocument(user.getDocument());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setBirthDate(user.getBirthDate());
        entity.setAddress(user.getAddress());
        entity.setRelationId(user.getRelationId());
        entity.setRole(user.getRole().toString());
        entity.setUserState(user.getUserState().toString());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return entity;
    }

    private User mapToDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setDocument(entity.getDocument());
        user.setEmail(entity.getEmail());
        user.setPhone(entity.getPhone());
        user.setBirthDate(entity.getBirthDate());
        user.setAddress(entity.getAddress());
        user.setRelationId(entity.getRelationId());
        user.setRole(Role.valueOf(entity.getRole()));
        user.setUserState(UserState.valueOf(entity.getUserState()));
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        return user;
    }
}
