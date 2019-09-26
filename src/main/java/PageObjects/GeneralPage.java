package PageObjects;

import org.openqa.selenium.WebDriver;

public class GeneralPage {
    WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }
    public void  navigateTo(String url){
        driver.navigate().to(url);
    }
}
