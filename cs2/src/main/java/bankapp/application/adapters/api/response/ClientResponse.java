package bankapp.application.adapters.api.response;

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
public class ClientResponse {
    private long id;
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private Role role;

    public static ClientResponse fromClient(bankapp.domain.models.Client client) {
        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setDocument(client.getDocument());
        response.setName(client.getName());
        response.setEmail(client.getEmail());
        response.setPhone(client.getPhone());
        response.setAddress(client.getAddress());
        response.setBirthDate(client.getBirthDate());
        response.setRole(client.getRole());
        return response;
    }
}
