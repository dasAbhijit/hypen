package stepDefs;

import Managers.TestContext;
import PageObjects.Home;
import PageObjects.SignIn;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class HomePageStepDef {
    private TestContext testContext;
    private SignIn signIn;
    private Home home;
    String text;

    public HomePageStepDef(TestContext context) {
        testContext = context;
        signIn = testContext.getPageObjectManager().getSignIn();
        home = testContext.getPageObjectManager().getHome();
    }

    @Given("^user logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void thatTheUserLogsInWithAnd(String email, String code) throws Throwable {
        signIn.enterEmail(email);
        signIn.clickOnSendMeAVerificationCodeButton();
        signIn.enterVerificationCode(code);
        signIn.clickLoginButton();
    }

    @When("^user clicks on create new post button$")
    public void userClicksOnCreateNewPostButton() {
        home.clickOnCreateNewPost();
    }

    @And("^user clicks on Open button$")
    public void userClicksOnOpenButton() {
        home.clickOnOpenButton();
    }

    @And("^user selects an option from dropdown$")
    public void userSelectsFromDropdown() throws Throwable {
        home.selectAGroup();
    }

    @And("^user clicks on select button$")
    public void userClicksOnSelectButton() {
        home.clickOnSelect();
    }

    @And("^user types \"([^\"]*)\" opinion or question or feedback$")
    public void userTypesOpinionOrQuestionOrFeedback(String text) throws Throwable {
        this.text = text;
        home.enterTextInQuestionTextArea(text);
    }

    @And("^user clicks on publish button$")
    public void userClicksOnPublishButton() {
        home.publishPost();
    }

    @Then("^user should be able to create post$")
    public void userShouldBeAbleToCreatePost() {
        assertEquals(home.findLatestPostTitleText(), text);
    }
}
