package com.nedyalkoboydev.autoserviceplatform.domain.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentCalendarViewModel {
    private Long carServiceId;
    private Long vehicleId;
    private Long employeeId;
    private Long serviceTypeId;
    private LocalDateTime appointmentTime;
}
