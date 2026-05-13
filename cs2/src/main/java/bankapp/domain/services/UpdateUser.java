package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

@Service
public class UpdateUser {
    private final UserPort userPort;

    public UpdateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void updateUser(User user) throws BusinessException {
        if (!userPort.existsByDocument(user.getDocument())) {
            throw new BusinessException("There is no user with that document.");
        }
        
        userPort.updateUser(user);
    }
    
}