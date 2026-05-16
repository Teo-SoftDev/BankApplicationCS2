package bankapp.application.adapters.api.response;

import bankapp.domain.models.User;

import java.time.LocalDate;

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
public class UserResponse {
    private Long id;
    private String document;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private String relationId;
    private String username;
    private Role role;
    private UserState userState;

    public static UserResponse fromUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setDocument(user.getDocument());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        response.setBirthDate(user.getBirthDate());
        response.setRelationId(user.getRelationId());
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());
        response.setUserState(user.getUserState());
        return response;
    }
}
