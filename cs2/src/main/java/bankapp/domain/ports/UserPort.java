package bankapp.domain.ports;

import bankapp.domain.models.User;

public interface UserPort {
    public boolean existsByDocument(String document);

    // CRUD
    public void saveUser(User user);
    public void updateUser(User user);
    public User findByDocument(String document);
    public void deleteUser(String document);
}
