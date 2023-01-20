package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentCalendarDTO {
    private Long carServiceId;
    private Long vehicleId;
    private Long employeeId;
    private Long serviceTypeId;
    private LocalDateTime appointmentTime;
}
