package bankapp.application.adapters.api.request;

import java.time.LocalDate;

import bankapp.domain.models.Role;
import bankapp.domain.models.UserState;
import bankapp.domain.models.User;
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
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private String relationId;
    private String username;
    private String password;
    private Role role;
    private UserState userState;

    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setDocument(request.getDocument());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setBirthDate(request.getBirthDate());
        user.setRelationId(request.getRelationId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setUserState(request.getUserState());
        return user;
    }
}
