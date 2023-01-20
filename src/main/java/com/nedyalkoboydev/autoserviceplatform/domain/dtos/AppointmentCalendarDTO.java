package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentCalendarDTO {
    private Long id;

    private Long carServiceId;
    private String carServiceName;

    private Long vehicleId;
    private String vehicleLicensePlate;

    private Long employeeId;
    private String employeeName;

    private Long serviceTypeId;
    private String serviceType;

    private LocalDateTime appointmentTime;

    private Double price;

    private String status;
}
