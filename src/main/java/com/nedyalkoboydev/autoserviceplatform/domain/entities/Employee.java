package com.nedyalkoboydev.autoserviceplatform.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
@SuperBuilder
public class Employee extends User {
    @ManyToMany
    @JoinTable(
            name = "employees_qualifications",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id")
    )
    private Set<TypeOfServices> qualifications;
    @ManyToOne
    @JoinColumn(name = "car_service_id")
    private CarService carService;

    @OneToMany(mappedBy = "employee")
    private List<AppointmentCalendar> schedule;

}
