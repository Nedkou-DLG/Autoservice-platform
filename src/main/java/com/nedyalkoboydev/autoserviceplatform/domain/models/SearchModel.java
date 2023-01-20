package com.nedyalkoboydev.autoserviceplatform.domain.models;

import lombok.Data;

import java.util.Optional;

@Data
public class SearchModel {
    private String searchData;
    private Optional<Long> dependantId;
}

