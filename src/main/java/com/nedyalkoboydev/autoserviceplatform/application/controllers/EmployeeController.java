package com.nedyalkoboydev.autoserviceplatform.application.controllers;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IEmployeeService;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AppointmentCalendarDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CompleteAppoinmentDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.models.CompleteAppointmentViewModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final ModelMapper modelMapper;
    @RequestMapping(method = RequestMethod.GET, value = "/schedule")
    public List<AppointmentCalendarDTO> getVehiclesSchedule(){
        return employeeService.getSchedule();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/schedule")
    public void completeAppointment(CompleteAppointmentViewModel model){
        employeeService.completeAppointment(modelMapper.map(model, CompleteAppoinmentDTO.class));
    }
}
