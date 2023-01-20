package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutocompleteDataDTO {
    private Long id;
    private String displayValue;
}
