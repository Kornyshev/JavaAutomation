package me.kornyshev.utils;

public class DataUtils {

    public static synchronized String timestamp() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException ignored) { }
        return String.valueOf(System.currentTimeMillis());
    }

}
