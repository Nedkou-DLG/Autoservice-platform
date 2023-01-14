package com.nedyalkoboydev.autoserviceplatform.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car_services")
@RequiredArgsConstructor
public class CarService extends BaseEntity {
    private String name;

    @OneToOne
    private Employee boss;

    @OneToMany(mappedBy = "carService")
    @JsonIgnoreProperties("carService")
    private List<Employee> employees;

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
