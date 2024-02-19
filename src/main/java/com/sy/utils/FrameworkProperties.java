package com.sy.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {

    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {

        try {
            Properties property = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if(inputStream != null){
                property.load(inputStream);
            }
            else {
                throw new FileNotFoundException(Constants.PROP_FILE_NOT_FOUND_EXCEPTION_MESSAGE);
            }

            this.result =  property.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
