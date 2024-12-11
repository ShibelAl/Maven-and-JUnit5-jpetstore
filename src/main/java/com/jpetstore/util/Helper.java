package com.jpetstore.util;

import java.io.IOException;

public class Helper {

    public static boolean isWebDriverManager() throws IOException {
        return PropertyReader.getInstance().getProperty(PropKey.BROWSER_MANAGER.getPropVal()).
                equalsIgnoreCase("webDriverManager");
    }
}
