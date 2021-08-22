package com.phinzin.demo.exception.domain;

public class CustomRuntimeException extends RuntimeException{
    private String messageKey;
    public CustomRuntimeException(){
        super();
    }
    public CustomRuntimeException(final String technicalErrorMsg,
                                  final String messageKey){
        super(technicalErrorMsg);
        this.messageKey=messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
