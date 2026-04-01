package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;

public class DeleteUser {
    private UserPort userPort;

    public void deleteUser(String document) throws BusinessException {
        if (!userPort.existsByDocument(document)) {
            throw new BusinessException("There is no user with that document.");
        }
        
        userPort.deleteUser(document);
    }
}
