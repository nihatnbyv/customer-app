package az.atl.customerapp.mapper;

import az.atl.customerapp.dao.entity.CustomerEntity;
import az.atl.customerapp.model.dto.CustomerDto;
import az.atl.customerapp.model.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
@Mapping(target = "role", constant = "USER")
    CustomerEntity toEntity(CustomerRequest customerRequest);

    CustomerDto toDto(CustomerEntity customerEntity);


}
