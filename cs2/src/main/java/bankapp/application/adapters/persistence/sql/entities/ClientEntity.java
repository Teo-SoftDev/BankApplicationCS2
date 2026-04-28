package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import bankapp.domain.models.ClientRole;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String clientRole;
}