package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

public class UpdateUser {
    private UserPort userPort;

    public void updateUser(User user) throws BusinessException {
        if (!userPort.existsByDocument(user.getDocument())) {
            throw new BusinessException("There is no user with that document.");
        }
        
        userPort.updateUser(user);
    }
    
}