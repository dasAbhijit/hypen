package stepDefs;

import Managers.TestContext;
import PageObjects.GeneralPage;
import cucumber.api.java.en.Given;

public class GeneralPageStepDef {
    private TestContext testContext;
    private GeneralPage generalPage;

    public GeneralPageStepDef(TestContext context) {
        testContext = context;
        generalPage = testContext.getPageObjectManager().getGeneralPage();
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void thatTheUserIsOn(String url) throws Throwable {
        generalPage.navigateTo(url);
    }
}
