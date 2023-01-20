package com.nedyalkoboydev.autoserviceplatform.application.services;

import com.nedyalkoboydev.autoserviceplatform.application.middlewares.exceptions.models.RecordNotFoundException;
import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IEmployeeService;
import com.nedyalkoboydev.autoserviceplatform.domain.constants.ExceptionConstants;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AppointmentCalendarDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CompleteAppoinmentDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.AppointmentCalendar;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.Employee;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IAppointmentCalendarRepository;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService extends AuthProvider<Employee> implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final IAppointmentCalendarRepository appointmentCalendarRepository;
    @Override
    public List<AppointmentCalendarDTO> getSchedule() {
        Employee currentEmployee = employeeRepository.findById(getCurrentUser().getId()).orElseThrow(() -> new BadCredentialsException(ExceptionConstants.USER_NOT_FOUND));

        return currentEmployee.getSchedule().stream().map(schedule-> AppointmentCalendarDTO.builder()
                .id(schedule.getId())
                .employeeId(schedule.getEmployee().getId())
                .employeeName(String.format("%s %s", schedule.getEmployee().getFirstName(), schedule.getEmployee().getLastName()))
                .carServiceName(schedule.getCarService().getName())
                .carServiceId(schedule.getCarService().getId())
                .appointmentTime(schedule.getAppointmentTime())
                .price(schedule.getPrice())
                .status(schedule.getStatus().name())
                .vehicleId(schedule.getVehicle().getId())
                .vehicleLicensePlate(schedule.getVehicle().getLicensePlate())
                .build()).collect(Collectors.toList());
    }

    @Override
    public void completeAppointment(CompleteAppoinmentDTO model) {
        AppointmentCalendar appointmentCalendar = appointmentCalendarRepository.findById(model.getId()).orElseThrow(() -> new RecordNotFoundException("Appointment"));
        appointmentCalendar.setPrice(model.getPrice());
        appointmentCalendar.setComment(model.getComment());
        appointmentCalendarRepository.save(appointmentCalendar);
    }
}
