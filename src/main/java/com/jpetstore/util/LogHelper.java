package com.jpetstore.util;
import io.qameta.allure.Step;

public class LogHelper {

    /**
     * Method to log step information to reports
     *
     * @param message: the message to be reported.
     */
    public static synchronized void logToReport(String message){

        boolean isLogEnabled = PropertyReader.getInstance()
                .getProperty(PropKey.ALLURE_REPORT_STEP_LOG
                        .getPropVal()).equalsIgnoreCase("ENABLE");

        if(isLogEnabled){
            logToAllureReport(message);
        }
    }

    @Step("{0}")
    private static synchronized void logToAllureReport(String message){

    }
}
