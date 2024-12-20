package com.jpetstore.util;

public enum PropKey {

    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),

    //Driver Paths
    CHROME_DRIVER_PATH("chromeDriverPath"),
    GECKO_DRIVER_PATH("geckoDriverPath"),

    //TimeOuts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    //Screenshot
    SCREEN_SHOT("screenShot"),
    ELEMENT_SCREEN_SHOT("elementScreenShot"),

    ALLURE_REPORT_STEP_LOG("allureReportStepLog"),

    //Selenium Grid
    REMOTE("remote"),
    HUB_URL("hubUrl");


    private final String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
