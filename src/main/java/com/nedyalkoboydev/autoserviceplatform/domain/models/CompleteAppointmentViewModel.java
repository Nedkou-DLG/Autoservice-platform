package com.nedyalkoboydev.autoserviceplatform.domain.models;

import lombok.Data;

@Data
public class CompleteAppointmentViewModel {
    private Long id;
    private String comment;
    private Double price;
}
