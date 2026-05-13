package bankapp.application.adapters.api.request;

import java.time.LocalDate;

import bankapp.domain.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ClientRequest {
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private Role role;
}