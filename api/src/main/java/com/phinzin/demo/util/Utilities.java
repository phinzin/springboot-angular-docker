package com.phinzin.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;

public final class Utilities {

    /** */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Utilities.class);

    /**  */
    private static final String IV_USER = "iv-user";
    /**  */
    private static final int BUCKET_SIZE = 2048;
    /**  */
    private static final int FOUR_DIGIT_RANDOM_LIMIT = 10000;

    /**  */
    private static Random random = new Random();
    /**  */
    private static final int FIVE_HUNDRED = 500;

    /**
     * public empty constructor.
     */
    private Utilities() {
    }

    /**
     * @param locale
     * @return language part of locale
     */
    public static String getLanguagePartOfLocale(final String locale) {

        return locale.split("-")[0];
    }

    /**
     * @param is
     * @return Stream converted into String
     */
    public static String convertStream2String(final InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bucket = new byte[BUCKET_SIZE];
        int bytesRead;

        try {
            while ((bytesRead = is.read(bucket, 0, BUCKET_SIZE)) != -1) {
                baos.write(bucket, 0, bytesRead);
            }
        } catch (IOException e) {
            LOGGER.error("Error converting Stream to string: {}",
                    e.getMessage());
        }

        return new String(baos.toByteArray());
    }

    /**
     * @param httpReq
     * @return iv-user
     */
    public static String getIvUser(final HttpServletRequest httpReq) {

        String ivUser = httpReq.getHeader(IV_USER);

        if (StringUtils.isEmpty(ivUser)) {
            ivUser = httpReq.getParameter(IV_USER);
        }

        if (StringUtils.isEmpty(ivUser)) {
            HttpSession session = httpReq.getSession(false);
            if (session != null) {
                ivUser = (String) session.getAttribute(IV_USER);
            }
        }

        return ivUser;

    }

    /**
     * @param userErrMsg
     * @param techErrMsg
     * @return formatted error msg
     */
    public static String getFormattedErrorMsg(final String userErrMsg,
                                              final String techErrMsg) {

        StringBuilder errorBuilder = new StringBuilder();

        errorBuilder.append(userErrMsg);
        errorBuilder.append(" ( MessageId :");
        errorBuilder.append(Calendar.getInstance().getTimeInMillis());
        errorBuilder.append("#");
        errorBuilder.append(
                String.format("%04d", random.nextInt(FOUR_DIGIT_RANDOM_LIMIT)));

        if (!StringUtils.isEmpty(techErrMsg)) {
            errorBuilder.append(", Message :");
            errorBuilder.append(techErrMsg);
        }
        errorBuilder.append(" )");

        return errorBuilder.toString();
    }

    /**
     * @param standardErrorCode
     * @return Custom Error Code
     */
    public static int generateCustomErrorCode(final int standardErrorCode) {
        return (standardErrorCode + FIVE_HUNDRED) * 2;
    }

}
