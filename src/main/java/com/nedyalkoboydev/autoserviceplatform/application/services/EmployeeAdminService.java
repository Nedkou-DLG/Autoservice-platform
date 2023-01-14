package com.nedyalkoboydev.autoserviceplatform.application.services;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IEmployeeAdminService;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CreateCarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.CarService;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.Employee;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.ICarServiceRepository;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class EmployeeAdminService extends AuthProvider<Employee> implements IEmployeeAdminService {

    private final IEmployeeRepository employeeRepository;
    private final ICarServiceRepository carServiceRepository;
    private final ModelMapper modelMapper;
    @Override
    public CarServiceDTO createCarService(CreateCarServiceDTO model) {
        CarService carService = modelMapper.map(model, CarService.class);
        carService.addEmployee(getCurrentUser());
        return modelMapper.map(carServiceRepository.save(carService), CarServiceDTO.class);
    }


}
