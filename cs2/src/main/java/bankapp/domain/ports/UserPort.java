package bankapp.domain.ports;

import bankapp.domain.models.User;

public interface UserPort {
    public boolean existsByDocument(String document);
    public void saveUser(User user);
    public User findByDocument(User user);
}
