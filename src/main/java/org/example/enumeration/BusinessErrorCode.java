package org.example.enumeration;

public enum BusinessErrorCode {

    NEGATIVE_INPUT_NOT_ALLOWED("Negative input values not allowed."); //TODO Externalize message in property files
    private String value;

    BusinessErrorCode(String value){
        this.value =value;
    }

    public String getValue(){
        return this.value;
    }
}
