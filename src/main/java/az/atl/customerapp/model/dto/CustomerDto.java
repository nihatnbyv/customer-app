package az.atl.customerapp.model.dto;


import az.atl.customerapp.dao.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {

    Long id;
    String name;
    String lastName;
    String email;
    String country;
    Role role;
}
