package org.example.exception;

import org.example.enumeration.BusinessErrorCode;

public class BadArgumentException extends RuntimeException{

    private BusinessErrorCode errorCode;
    private String badArgument;

    public  BadArgumentException(BusinessErrorCode errorCode, String badArgument){
        super(errorCode.getValue());
        this.errorCode = errorCode;
        this.badArgument = badArgument;
    }
    public BusinessErrorCode getErrorCode() {
        return errorCode;
    }

    public String getBadArgument() {
        return badArgument;
    }
}
