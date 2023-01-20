package com.nedyalkoboydev.autoserviceplatform.domain.entities;

import com.nedyalkoboydev.autoserviceplatform.domain.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments_calendar")
@SuperBuilder
public class AppointmentCalendar extends BaseEntity {
    @OneToOne(optional = false)
    @JoinColumn(name = "car_service_id", nullable = false)
    private CarService carService;

    @OneToOne(optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "service_type_id")
    private TypeOfServices serviceType;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comment;
}

