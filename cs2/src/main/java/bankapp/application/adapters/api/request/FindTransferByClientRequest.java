package bankapp.application.adapters.api.request;

import bankapp.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindTransferByClientRequest {
    private String document;
    private User user;
}
