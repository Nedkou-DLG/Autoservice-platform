package com.nedyalkoboydev.autoserviceplatform.application.middlewares.exceptions.models;

import com.nedyalkoboydev.autoserviceplatform.domain.constants.ExceptionConstants;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String tableName){
        super(String.format("%s %s", tableName, ExceptionConstants.RECORD_NOT_FOUND));
    }
}
