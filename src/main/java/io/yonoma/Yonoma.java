package io.yonoma;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Yonoma {

    /**
     * Returns the current date and time as a formatted string.
     *
     * @return The current date-time in "yyyy-MM-dd HH:mm:ss" format.
     */
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
