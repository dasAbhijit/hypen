package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    @FindBy(xpath = "//*[@id='sidebar']")
    private WebElement sidebar_div;

    @FindBy(xpath = "//*[contains(text(),'Create new post')]")
    private WebElement createNewPost_button;

    @FindBy(xpath = "//*[contains(text(),'OPEN')]")
    private WebElement open_button;

    @FindBy(xpath = "//*[contains(text(),'Select...')]")
    private WebElement selectGroup_dropdown;

    @FindBy(xpath = "//button[contains(text(),'Select')]")
    private WebElement select_button;

    @FindBy(xpath = "//*[@name='question']")
    private WebElement question_textArea;

    @FindBy(xpath = "//button[contains(text(),'Publish post')]")
    private WebElement publishPost_button;

    @FindBy(xpath = "//*[@class='Linkify']/span")
    private WebElement lastPublishedPostTitle_label;

    @FindBy(xpath = "//*[@id='modal-root-container']/div[3]/div/div/div/div[2]/form/div[2]/div[1]/div/div/div[2]/div")
    private WebElement option_label;


    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateNewPost() {
        createNewPost_button.click();
    }

    public void clickOnOpenButton() {
        open_button.click();
    }

    public void selectAGroup() {
        selectGroup_dropdown.click();
        option_label.click();
    }

    public void clickOnSelect() {
        select_button.click();
    }

    public void enterTextInQuestionTextArea(String question) {
        question_textArea.sendKeys(question);
    }

    public void publishPost() {
        publishPost_button.click();
    }

    public String findLatestPostTitleText() {
        return lastPublishedPostTitle_label.getText();
    }

    public boolean isSidebarPresent() {
        if (sidebar_div.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
