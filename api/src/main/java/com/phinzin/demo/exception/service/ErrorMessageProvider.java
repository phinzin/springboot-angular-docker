package com.phinzin.demo.exception.service;

import com.phinzin.demo.util.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component("errorMessageProvider")
public class ErrorMessageProvider {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ErrorMessageProvider.class);
    @Autowired
    private MessageSource msgSource;
    public String formattedLocaleSpecificMessage(final String messageKey,
                                                 final Object[] messageParams, final String technicalMessage) {
        HttpServletRequest curRequest =
                ((ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes()).getRequest();

        LOGGER.debug("============> httpServletRequest.getLocale(): "
                + curRequest.getLocale());
        String messageForUser = msgSource.getMessage(messageKey, messageParams,
                curRequest.getLocale());
        String formattedErrorMsg = Utilities
                .getFormattedErrorMsg(messageForUser, technicalMessage);

        return formattedErrorMsg;

    }
}
