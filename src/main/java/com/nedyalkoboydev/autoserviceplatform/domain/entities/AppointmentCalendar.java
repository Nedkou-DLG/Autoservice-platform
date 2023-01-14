package com.nedyalkoboydev.autoserviceplatform.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments_calendar")
public class AppointmentCalendar extends BaseEntity {
    @OneToOne(optional = false)
    @JoinColumn(name = "car_service_id", nullable = false)
    private CarService carService;

    @OneToOne(optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "service_type_id")
    private TypeOfServices serviceType;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    private Double price;
}

