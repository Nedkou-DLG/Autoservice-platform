package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCarServiceDTO {
    @NotBlank
    private String name;
}
