package com.nedyalkoboydev.autoserviceplatform.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateVehicleViewModel {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturedDate;
    private String licensePlate;
}
