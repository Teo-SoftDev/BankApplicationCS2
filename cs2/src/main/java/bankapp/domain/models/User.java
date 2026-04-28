package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class User extends Person {
    private String relationId;
    private Role role;
    private UserState userState;
    private String username;
    private String password;
}
