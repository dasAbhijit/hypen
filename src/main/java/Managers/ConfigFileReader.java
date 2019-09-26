package Managers;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String propertyFilePath = "configs//appConfig.properties";
    Properties properties;

    public ConfigFileReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath(DriverType driverType) {
        switch (driverType) {
            case FIREFOX:
                String firefoxDriverPath = properties.getProperty("firefoxDriverPath");
                if (firefoxDriverPath != null) {
                    return firefoxDriverPath;
                } else {
                    throw new RuntimeException(
                            "Firefox Driver Path not specified in the configuration.properties file for the Key : firefoxDriverPath");
                }
            case CHROME:
                String chromeDriverPath = properties.getProperty("chromeDriverPath");
                if (chromeDriverPath != null) {
                    return chromeDriverPath;
                } else {
                    throw new RuntimeException(
                            "Chrome Driver Path not specified in the configuration.properties file for the Key : chromeDriverPath");
                }
            default:
                String defaultChromeDriverPath = properties.getProperty("chromeDriverPath");
                if (defaultChromeDriverPath != null)
                    return defaultChromeDriverPath;
                else
                    throw new RuntimeException(
                            "Default : Driver Path not specified in the configuration.properties file for the Key : chromeDriverPath");
        }

    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if (pageLoadTimeout != null) {
            try {
                return Long.parseLong(pageLoadTimeout);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + pageLoadTimeout + " in to Long");
            }
        }
        return 30;
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else
            throw new RuntimeException(
                    "Browser Name Key value in configuration.properties is not matched : " + browserName);
    }


    public String getBrowserWindowSize() {
        return properties.getProperty("windowSize");
    }

}