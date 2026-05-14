package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor

public abstract class Person {

    private Long id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String address;
    
}