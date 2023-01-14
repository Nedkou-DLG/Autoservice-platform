package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class EmployeeDTO {
    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;

    private CarServiceDTO carService;
    private AppointmentCalendarDTO schedule;

}

