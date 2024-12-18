package com.jpetstore.util;


public class SystemPropertyHelper {


    /**
     * Method to get value for elementScreenShot
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
}
