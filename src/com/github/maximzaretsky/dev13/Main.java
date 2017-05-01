import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "\\Courses_EPAM\\dev13\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    ArrayOfTests arrayOfTests = new ArrayOfTests();

    AuthorizationWithVoidFields authorizationWithVoidFields = new AuthorizationWithVoidFields(driver);
    AuthorizationWithTrueFields authorizationWithTrueFields = new AuthorizationWithTrueFields(driver);
    AuthorizationWithInvalidPassword authorizationWithInvalidPassword = new AuthorizationWithInvalidPassword(driver);
    AuthorizationWithInvalidLogin authorizationWithInvalidLogin = new AuthorizationWithInvalidLogin(driver);

    arrayOfTests.addTest(authorizationWithTrueFields);
    arrayOfTests.addTest(authorizationWithVoidFields);
    arrayOfTests.addTest(authorizationWithInvalidPassword);
    arrayOfTests.addTest(authorizationWithInvalidLogin);

    arrayOfTests.doTests();
  }
}
