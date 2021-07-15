package pagesTestsProject;

import mainProject.Data;
import mainProject.Locators;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
    public static final boolean isTest1 = true;


    @Test(description = "Registration process with Title,First Name,Surname", priority = 1, enabled = isTest1, groups = {"user", "admin", "ie"})


    public void testRegistration() {
        homePage.clickJoinNow();
        signUpPage.titleDropdownList();                     //Select a title value from the dropdown
        signUpPage.sendKeysFirstNameAndSurname();           //Enter your first name and surname in the form
        signUpPage.clickCheckbox();                         //Click checkbox
        String textTermAndConditions = homePage.getText(Locators.TEXT);
        Assert.assertEquals(textTermAndConditions,
                Data.textVerify,
                "Checkbox text doesn't match");      //Check the checkbox with text
        homePage.click(Locators.JOIN_BTN_FINAL);                       //Submit the form by clicking the  JOIN NOW button
        String textRequired = homePage.getText(Locators.TEXT_WARNING);
        Assert.assertEquals(textRequired,
                Data.textRequiredWarning,
                "The error message did not appears as expected");   //Validate that message with text ‘This field is required’ appears under the date of birth box
        System.out.println("Test has passed!");
    }
}
