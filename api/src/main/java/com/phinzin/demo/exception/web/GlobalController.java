package com.phinzin.demo.exception.web;

import com.phinzin.demo.exception.service.ErrorMessageProvider;
import com.phinzin.demo.util.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalController {
    private static final String GLOBAL_UNEXPECTED_ERROR =
            "global.unexpected.error";

    private static final String RUNTIME_EXCEPTION = "RuntimeException";
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalController.class);
    @Autowired
    private MessageSource msgSource;
    @Autowired
    private ErrorMessageProvider errorMessageProvider;
    private static final String ERROR_MSG_FORMAT =
            "event=exception exceptionType={} code={} message={} timestampInMillisecs={}";
    @ExceptionHandler(
            value = {
                    Exception.class,
                    RuntimeException.class
            })
    void handleUnhandledException(final HttpServletRequest request,
                                  final HttpServletResponse response, final Exception e)
            throws IOException {

        String message = msgSource.getMessage(GLOBAL_UNEXPECTED_ERROR,
                new Object[] {}, request.getLocale());
        String formattedErrorMsg =
                Utilities.getFormattedErrorMsg(message, e.getMessage());
        LOGGER.error(formattedErrorMsg);
//        SPLUNK_LOGGER.error(ERROR_MSG_FORMAT, RUNTIME_EXCEPTION,
//                generateCustomErrorCode(
//                        HttpStatus.INTERNAL_SERVER_ERROR.value()),
//                formattedErrorMsg, System.currentTimeMillis());
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                formattedErrorMsg);

    }
}
