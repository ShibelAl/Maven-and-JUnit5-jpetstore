package com.jpetstore.util;

import java.io.IOException;

public class TimeUtil {

    /**
     * Method to return implicit wait
     * @return implicit wait
     */
    public static int getImplicitWait() throws IOException {
        return Integer.parseInt(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    /**
     * Method to return implicit wait
     * @return implicit wait
     */
    public static int getExplicitWait() {
        try {
            return Integer.parseInt(PropertyReader.getInstance().getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
