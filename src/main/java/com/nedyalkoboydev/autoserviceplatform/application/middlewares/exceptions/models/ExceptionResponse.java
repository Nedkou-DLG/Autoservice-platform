package com.nedyalkoboydev.autoserviceplatform.application.middlewares.exceptions.models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
