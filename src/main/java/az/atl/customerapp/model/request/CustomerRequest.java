package az.atl.customerapp.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

    String name;
    String lastName;
    String email;
    String country;

}
