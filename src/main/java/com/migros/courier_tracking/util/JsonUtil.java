package com.migros.courier_tracking.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    public static String exceptionToString(Exception exception) {
        StringBuilder sb = new StringBuilder();
        sb.append(exception.toString()).append("\n");

        for (StackTraceElement element : exception.getStackTrace()) {
            sb.append("\t at ").append(element).append("\n");
        }

        return sb.toString();
    }
}
