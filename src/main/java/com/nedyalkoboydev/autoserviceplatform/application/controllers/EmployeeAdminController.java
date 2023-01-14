package com.nedyalkoboydev.autoserviceplatform.application.controllers;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IEmployeeAdminService;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CreateCarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.EmployeeDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.models.AddCarServiceViewModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeAdminController {
    private final IEmployeeAdminService employeeAdminService;
    private final ModelMapper modelMapper;

    public CarServiceDTO createService(AddCarServiceViewModel model){
        return employeeAdminService.createCarService(modelMapper.map(model, CreateCarServiceDTO.class));
    }
}
