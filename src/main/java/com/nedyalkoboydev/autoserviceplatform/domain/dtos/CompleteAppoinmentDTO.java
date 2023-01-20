package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Data;

@Data
public class CompleteAppoinmentDTO {
    private Long id;
    private String comment;
    private Double price;
}
