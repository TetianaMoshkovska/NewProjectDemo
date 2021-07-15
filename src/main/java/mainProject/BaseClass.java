package mainProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class BaseClass {
    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;

    private void loadProperties() {
        FileInputStream fis = null;
        try {
            properties = new Properties();
            fis = new FileInputStream("C:\\Users\\tatta\\GitHub\\newProjectGit\\src\\main\\java\\mainProject\\config\\config.properties");
            properties.load(fis);
            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void openBrowser() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();         //Open Chrome browser

            ChromeOptions options = new ChromeOptions();     // Disable message 'Chrome is being controlled by automated test software'
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            driver = new ChromeDriver(options);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();                //Maximize window
        driver.manage().deleteAllCookies();

    }

    public void closeBrowser() {
        driver.quit();
    }

    public Boolean goToHomepage() {                         //Navigate to: https://moneygaming.qa.gameaccount.com/
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        } catch (Exception e) {
            System.out.println("Unable to navigate to the homepage");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }

    public void clickUnselectedCheckbox(By checkbox) {
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isSelected()) {
            (currentCheckbox).click();
        }
    }

    public String getText(By locator) {
        String displayedText = driver.findElement(locator).getText();
        if (displayedText.isEmpty()) {
            return driver.findElement(locator).getAttribute("value");
        } else {
            return displayedText;
        }
    }

    /*public void javaWaitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

}
