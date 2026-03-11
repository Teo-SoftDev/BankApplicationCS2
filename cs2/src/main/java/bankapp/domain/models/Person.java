package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor

public abstract class Person {

    private long id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private Date birthDate;
    private String address;
    
}