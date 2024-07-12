package az.atl.customerapp.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "lastName", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "country", nullable = false)
    String country;

    @Enumerated(EnumType.STRING)
    Role role;
}
