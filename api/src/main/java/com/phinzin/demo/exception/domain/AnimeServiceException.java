package com.phinzin.demo.exception.domain;

public class AnimeServiceException extends CustomRuntimeException {
    public AnimeServiceException(String messageKey, String technicalErrorMsg) {
        super(technicalErrorMsg, messageKey);
    }
}
