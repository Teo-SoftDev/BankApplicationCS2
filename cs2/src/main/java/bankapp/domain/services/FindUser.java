package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.UserPort;
import bankapp.domain.models.User;

@Service
public class FindUser {
    private final UserPort userPort;

    public FindUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public User findByDocument(String document) throws BusinessException {
        User user = userPort.findByDocument(document);

        if (user == null) {
            throw new BusinessException("There is no client with that document");
        }

        return user;
    }

    public User findByUsername(String username) throws BusinessException {
        User user = userPort.findByUsername(username);

        if (user == null) {
            throw new BusinessException("There is no client with that username");
        }

        return user;
    }

    public User findByEmail(String email) throws BusinessException {
        User user = userPort.findByEmail(email);

        if (user == null) {
            throw new BusinessException("There is no client with that email");
        }

        return user;
    }
}
