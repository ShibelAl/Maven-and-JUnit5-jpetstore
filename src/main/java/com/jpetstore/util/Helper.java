package com.jpetstore.util;

public class Helper {

    public static boolean isWebDriverManager() {
        return PropertyReader.getInstance().getProperty(PropKey.BROWSER_MANAGER.getPropVal()).
                equalsIgnoreCase("webDriverManager");
    }

    /**
     * Method to obtain app url from.
     * @return url of the application.
     */
    public static String getAppUrl() {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        return baseUrl + port;
    }
}
