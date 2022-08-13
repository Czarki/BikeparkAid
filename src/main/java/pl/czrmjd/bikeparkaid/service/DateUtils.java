package pl.czrmjd.bikeparkaid.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String convertToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date convertToDate(String dateAsString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateAsString);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
