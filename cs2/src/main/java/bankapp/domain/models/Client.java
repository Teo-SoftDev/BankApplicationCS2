package bankapp.domain.models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Client extends Person{
    private Role role;
    private ArrayList<Product> productsList = new ArrayList<>();
}
