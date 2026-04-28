package bankapp.application.adapters.api.response;

import bankapp.domain.models.Role;
import bankapp.domain.models.UserState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class UserResponse {
    private long id;
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String username;
    private Role role;
    private UserState userState;
}