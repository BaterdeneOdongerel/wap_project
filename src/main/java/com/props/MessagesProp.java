package com.props;

import com.db.ConnectionConfiguration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Van on 4/23/18.
 */
public enum MessagesProp {

    INSTANCE;
    private Properties prop;
    private MessagesProp() {
        prop = new Properties();
        try {
            prop.load(ConnectionConfiguration.class.getClassLoader().getResourceAsStream("messages.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getProp(String value) {
        return prop.getProperty(value);
    }
}
