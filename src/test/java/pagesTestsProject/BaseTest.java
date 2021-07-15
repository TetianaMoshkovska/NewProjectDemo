package pagesTestsProject;

import mainProject.BaseClass;
import mainProject.HomePage;
import mainProject.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest extends BaseClass {

    protected HomePage homePage;
    protected SignUpPage signUpPage;

    @BeforeSuite(groups = {"user", "admin", "ie"}, alwaysRun = true)
    public void setup() {

        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the the homepage");

        homePage = new HomePage();
        signUpPage = new SignUpPage();

    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
