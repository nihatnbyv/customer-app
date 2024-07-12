package az.atl.customerapp.service.impl;

import az.atl.customerapp.dao.entity.CustomerEntity;
import az.atl.customerapp.dao.repository.CustomerRepository;
import az.atl.customerapp.exception.CustomerNotFoundException;
import az.atl.customerapp.mapper.CustomerMapper;
import az.atl.customerapp.model.dto.CustomerDto;
import az.atl.customerapp.model.request.CustomerRequest;
import az.atl.customerapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerRequest);
        return customerMapper.toDto(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id" + id));
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void updateCustomer(Long id, CustomerRequest customerRequest) {
        CustomerEntity customer = customerMapper.toEntity(customerRequest);
        customer.setId(id);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
