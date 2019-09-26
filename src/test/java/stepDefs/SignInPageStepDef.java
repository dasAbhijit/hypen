package stepDefs;

import Managers.TestContext;
import PageObjects.Home;
import PageObjects.SignIn;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;


public class SignInPageStepDef {
    private TestContext testContext;
    private SignIn signIn;
    private Home home;

    public SignInPageStepDef(TestContext context) {
        testContext = context;
        signIn = testContext.getPageObjectManager().getSignIn();
        home = testContext.getPageObjectManager().getHome();
    }

    @When("^user enters email \"([^\"]*)\"$")
    public void userEntersEmail(String email) throws Throwable {
        signIn.enterEmail(email);
    }

    @And("^user clicks on send me a verification code button$")
    public void userClicksOnSendMeAVerificationCodeButton() {
        signIn.clickOnSendMeAVerificationCodeButton();
    }

    @And("^user enters verification code \"([^\"]*)\"$")
    public void userEntersVerificationCode(String code) throws Throwable {
        signIn.enterVerificationCode(code);
    }

    @And("^user clicks on login button$")
    public void userClicksOnLoginButton() {
        signIn.clickLoginButton();
    }

    @Then("^ensure user is logged in$")
    public void ensureUserIsLoggedIn() {
        assertEquals(home.isSidebarPresent(),true);
    }

}
