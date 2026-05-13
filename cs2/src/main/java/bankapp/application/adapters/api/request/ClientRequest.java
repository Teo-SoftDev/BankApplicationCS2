package bankapp.application.adapters.api.request;

import java.time.LocalDate;

import bankapp.domain.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private Role role;

    public static bankapp.domain.models.Client toEntity(ClientRequest request) {
        bankapp.domain.models.Client client = new bankapp.domain.models.Client();
        client.setDocument(request.getDocument());
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setAddress(request.getAddress());
        client.setBirthDate(request.getBirthDate());
        client.setRole(request.getRole());
        return client;
    }
}
