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
}
