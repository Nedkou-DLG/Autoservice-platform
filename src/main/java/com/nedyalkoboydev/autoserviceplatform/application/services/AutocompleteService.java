package com.nedyalkoboydev.autoserviceplatform.application.services;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IAutocompleteService;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AutocompleteDataDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.*;
import com.nedyalkoboydev.autoserviceplatform.domain.models.SearchModel;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.ICarServiceRepository;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IEmployeeRepository;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IServiceTypeRepository;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutocompleteService implements IAutocompleteService {

    private final ICarServiceRepository carServiceRepository;
    private final IEmployeeRepository employeeRepository;
    private final IServiceTypeRepository serviceTypeRepository;
    private final IVehicleRepository vehicleRepository;

    @Override
    public List<AutocompleteDataDTO> searchCarService(SearchModel model) {
        List<CarService> carServices = model.getSearchData().isBlank()
                ? carServiceRepository.findTop10ByOrderByNameAsc()
                : carServiceRepository.findByNameContaining(model.getSearchData());

        return carServices.stream().map(carService -> AutocompleteDataDTO.builder()
                .id(carService.getId())
                .displayValue(carService.getName())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<AutocompleteDataDTO> searchEmployee(SearchModel model) {
        List<Employee> employees = employeeRepository.findEmployeesInCarService(model.getSearchData(), model.getDependantId().get());
        return employees.stream().map(employee -> AutocompleteDataDTO.builder()
                .id(employee.getId())
                .displayValue(String.format("%s %s", employee.getFirstName(), employee.getLastName()))
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<AutocompleteDataDTO> searchServiceTypes(SearchModel model) {
        List<TypeOfServices> services = serviceTypeRepository.findByNameContaining(model.getSearchData());
        return  services.stream().map(service -> AutocompleteDataDTO.builder()
                .id(service.getId())
                .displayValue(service.getName())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<AutocompleteDataDTO> searchMyVehicles(SearchModel model) {
        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByOwnerIdAndLicensePlateContaining(currentUser.getId(), model.getSearchData());

        return vehicles.stream().map(vehicle -> AutocompleteDataDTO.builder()
                .id(vehicle.getId())
                .displayValue(vehicle.getLicensePlate())
                .build()).collect(Collectors.toList());
    }


}
