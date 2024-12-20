package com.jpetstore.util;
import com.jpetstore.driver.BrowserType;


public class SystemPropertyHelper {


    /**
     * Method to override (elementScreenShot) property using the command line.
     * If the property (elementScreenShot) is not overridden in the command line,
     * then the value of the property will be taken from the application.properties file.
     */
    public static String getElementScreenShotValue(){

        String msg = "";

        String valueFromPropFile = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREEN_SHOT.getPropVal());

        String valueFromSystemVariable = System.getProperty("elementScreenShot");

        if(!valueFromSystemVariable.isEmpty()){

            if(valueFromSystemVariable.equalsIgnoreCase("ENABLE") ||
                    valueFromSystemVariable.equalsIgnoreCase("DISABLE")){

                return valueFromSystemVariable;
            }
            else{

                msg = "Incorrect system property " + valueFromSystemVariable + " value specified for"
                        + PropKey.ELEMENT_SCREEN_SHOT.getPropVal() +
                        " ...defaulting to property provided by the application.properties file " +
                        PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;
                System.out.println(msg);
            }
        }

        msg =   "No system property specified" +
                " ...defaulting to application.properties file ->  " +
                PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;

        System.out.println(msg);
        return valueFromPropFile;
    }


    /**
     * Method to override remote value property from the command line.
     * If the property (remote) is not overridden in the command line,
     * then the value of the property will be taken from the application.properties file.
     * @return remote property - True/False
     */
    public static String getRemoteVal(){

        String msg = "";
        String valueFromPropFile = PropertyReader.getInstance()
                .getProperty(PropKey.REMOTE.getPropVal());

        String remoteVal = System.getProperty(PropKey.REMOTE.getPropVal());

        if(!remoteVal.isEmpty()){
            if(remoteVal.equalsIgnoreCase("TRUE") ||
                    remoteVal.equalsIgnoreCase("FALSE")){

                return remoteVal;
            }
            else{
                msg = "Incorrect system property " + remoteVal + " value specified for"
                        + PropKey.REMOTE.getPropVal() +
                        " ...defaulting to property provided by the application.properties file " +
                        PropKey.REMOTE.getPropVal() + " : " + valueFromPropFile;

                System.out.println(msg);
            }
        }

        msg =   "No system property specified" +
                " ...defaulting to application.properties file ->  " +
                PropKey.REMOTE.getPropVal() + " : " + valueFromPropFile;

        System.out.println(msg);

        return valueFromPropFile;
    }


    /**
     * Method to override hubUrl property from the command line.
     * If the property (remote) is not overridden in the command line,
     * then the value of the property will be taken from the application.properties file.
     * @return hubUrl property
     */
    public static String getHubUrl(){

        String hubUrl = System.getProperty(PropKey.HUB_URL.getPropVal());

        if(!hubUrl.isEmpty()){
            return hubUrl;
        }

        return PropertyReader.getInstance().getProperty(PropKey.HUB_URL.getPropVal());
    }


    /**
     * Method to override (browser) property from the command line.
     * This property is responsible for deciding on which browser the tests will run.
     * If the property (browser) is not overridden in the command line,
     * then the value of the property will be taken from the application.properties file.
     * @return browser property
     */
    public static BrowserType getBrowserFromSystemVariable(){

        String browser = System.getProperty(PropKey.BROWSER.getPropVal());
        if(browser.isEmpty()){
            browser = PropertyReader.getInstance().getProperty(PropKey.BROWSER.getPropVal());
        }

        if(browser.equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        }
        else if (browser.equalsIgnoreCase("FIREFOX")){
            return BrowserType.FIREFOX;
        }
        else {
            return null;
        }
    }
}
