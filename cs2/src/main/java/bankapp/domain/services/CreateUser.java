package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

public class CreateUser {
    private UserPort userPort;

    public void createUser(User user) throws BusinessException{

        if (userPort.existsByDocument(user.getDocument())) {
            throw new BusinessException("User already exists.");
        }

        userPort.saveUser(user);

    }
}
