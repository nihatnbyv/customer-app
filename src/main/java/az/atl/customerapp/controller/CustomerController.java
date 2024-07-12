package az.atl.customerapp.controller;

import az.atl.customerapp.model.dto.CustomerDto;
import az.atl.customerapp.model.request.CustomerRequest;
import az.atl.customerapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long id,
                                               @Valid
                                               @RequestBody CustomerRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
