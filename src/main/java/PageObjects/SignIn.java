package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    @FindBy(xpath = "//*[@name='email']")
    private WebElement email_field;

    @FindBy(xpath = "//*[contains(text(),'Send me a verification code')]")
    private WebElement sendMeAVerificationCode_button;

    @FindBy(xpath = "//*[@placeholder='Verification code']")
    private WebElement verificationCode_field;

    @FindBy(xpath = "//*[contains(text(),'Log In')]")
    private WebElement logIn_button;

    public SignIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        email_field.sendKeys(email);
    }

    public void clickOnSendMeAVerificationCodeButton() {
        sendMeAVerificationCode_button.click();
    }

    public void enterVerificationCode(String code) {
        verificationCode_field.sendKeys(code);
    }

    public void clickLoginButton() {
        logIn_button.click();
    }
}
