package com.jpetstore.util;

public enum PropKey {

    URL("url"),
    PORT("port");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
