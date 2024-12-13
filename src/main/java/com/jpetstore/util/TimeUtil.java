package com.jpetstore.util;

public class TimeUtil {

    /**
     * Method to return implicit wait
     * @return implicit wait
     */
    public static int getImplicitWait() {
        return Integer.parseInt(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    /**
     * Method to return implicit wait
     * @return implicit wait
     */
    public static int getExplicitWait() {
        return Integer.parseInt(PropertyReader.getInstance().getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
