package bankapp.application.adapters.api.request;

import bankapp.domain.models.Role;
import bankapp.domain.models.UserState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private Role role;
    private UserState userState;

    public static bankapp.domain.models.User toEntity(UserRequest request) {
        bankapp.domain.models.User user = new bankapp.domain.models.User();
        user.setDocument(request.getDocument());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setUserState(request.getUserState());
        return user;
    }
}
