package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;

@Service
public class DeleteUser {
    private final UserPort userPort;

    public DeleteUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void deleteUser(String document) throws BusinessException {
        if (!userPort.existsByDocument(document)) {
            throw new BusinessException("There is no user with that document.");
        }
        
        userPort.deleteUser(document);
    }
}
