package Managers;

import enums.DriverType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.browserDrivers.ie.driver";
    DriverType driverType;
    private WebDriver driver;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        return driver = createLocalDriver();
    }

    private WebDriver createLocalDriver() {
        String osName = System.getProperty("os.name");
        switch (driverType) {
            case FIREFOX:
                switch (osName) {
                    case "Mac OS X":
                        System.setProperty(FIREFOX_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.FIREFOX) + "geckodriver_mac64");
                        driver = new FirefoxDriver();
                        break;
                    case "Windows":
                        System.setProperty(FIREFOX_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.FIREFOX) + "geckodriver_win32.exe");
                        driver = new FirefoxDriver();
                        break;
                    case "Linux":
                        System.setProperty(FIREFOX_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.FIREFOX) + "geckodriver_linux64");
                        driver = new FirefoxDriver();
                        break;
                }
                break;
            case CHROME:
                switch (osName) {
                    case "Mac OS X":
                        System.setProperty(CHROME_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.CHROME) + "chromedriver_mac64");
                        driver = new ChromeDriver();
                        break;
                    case "Windows":
                        System.setProperty(CHROME_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.CHROME) + "chromedriver_win32.exe");
                        driver = new ChromeDriver();
                        break;
                    case "Linux":
                        System.setProperty(CHROME_DRIVER_PROPERTY,
                                FileReaderManager.getInstance().getConfigReader().getDriverPath(DriverType.CHROME) + "chromedriver_linux64");
                        driver = new ChromeDriver();
                        break;
                }
        }
        settingUpWaits();
        return driver;
    }

    private void settingBrowserSize() {
        String browserSize = FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize();
        String[] dim = browserSize.split("\\*");
        int width = Integer.parseInt(dim[0]);
        int height = Integer.parseInt(dim[1]);
        Dimension d = new Dimension(width, height);
        // Resize the current window to the given dimension
        driver.manage().window().setSize(d);
    }

    private void settingUpWaits() {
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
                TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout(), TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.close();
    }

}
