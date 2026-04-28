package bankapp.application.adapters.api.response;

import java.time.LocalDate;

import bankapp.domain.models.ClientRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ClientResponse {
    private long id;
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private ClientRole clientRole;
}