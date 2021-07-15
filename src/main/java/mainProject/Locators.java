package mainProject;

import org.openqa.selenium.By;

public class Locators {
    public static final By JOIN_BTN = By.xpath("//a[contains(text(),'Join Now!')]");
    public static final By TITLE_SELECT = By.xpath("//select[@id='title']");
    public static final By FIRST_NAME_INPUT = By.xpath("//input[@id='forename']");
    public static final By SURNAME_INPUT = By.xpath("//input[@name='map(lastName)']");
    public static final By CHECKBOX = By.cssSelector("#checkbox[value='true'][name='map(terms)']");
    public static final By TEXT = By.xpath("//div[@id='termsCheckbox']");
    public static final By JOIN_BTN_FINAL = By.cssSelector("#form");
    public static final By TEXT_WARNING = By.xpath("//label[@for='dob']");

}
