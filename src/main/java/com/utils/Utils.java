package com.utils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by admin on 4/23/18.
 */
public class Utils {
    public static Timestamp convertTime(LocalDate date) {
        return Timestamp.valueOf(date.atStartOfDay());
    }

    public static <T> T extractValue(HttpServletRequest request, String name, T defaultValue) {
        String param = request.getParameter(name);
        boolean hasValue = param != null && !param.isEmpty();
        return hasValue ? (T) param : defaultValue;
    }
}