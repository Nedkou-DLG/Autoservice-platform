package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UpdateVehicleDTO {

    private Long id;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;

    private LocalDate manufacturedDate;
    @NotBlank
    @Size(min = 4, max = 10)
    private String licensePlate;
}
