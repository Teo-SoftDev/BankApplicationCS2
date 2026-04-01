package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

public class FindUser {
    private UserPort userPort;

    public User findByDocument(String document) throws BusinessException {
        User user = userPort.findByDocument(document);

        if (user == null) {
            throw new BusinessException("There is no client with that document");
        }

        return user;
    }
}
