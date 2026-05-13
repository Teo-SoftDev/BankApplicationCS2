package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

@Service
public class CreateUser {
    private final UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void createUser(User user) throws BusinessException{

        if (userPort.existsByDocument(user.getDocument())) {
            throw new BusinessException("User already exists.");
        }

        userPort.saveUser(user);

    }
}
