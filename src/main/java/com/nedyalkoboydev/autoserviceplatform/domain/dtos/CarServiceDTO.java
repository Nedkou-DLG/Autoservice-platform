package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.AppointmentCalendar;
import lombok.Data;

import java.util.List;

@Data
public class CarServiceDTO {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees;
    private List<AppointmentCalendarDTO> schedule;
}
