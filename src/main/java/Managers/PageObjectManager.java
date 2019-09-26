package Managers;

import PageObjects.GeneralPage;
import PageObjects.Home;
import PageObjects.SignIn;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private GeneralPage generalPage;
    private SignIn signIn;
    private Home home;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignIn getSignIn() {
        return (signIn == null) ? signIn = new SignIn(driver) : signIn;
    }

    public Home getHome() {
        return (home == null) ? home = new Home(driver) : home;
    }

    public GeneralPage getGeneralPage() {
        return (generalPage == null) ? generalPage = new GeneralPage(driver) : generalPage;
    }
}
