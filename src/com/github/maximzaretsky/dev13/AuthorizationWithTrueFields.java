import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contain method for authorization with valid fields
 * of login and password
 */
public class AuthorizationWithTrueFields implements AuthorizationTest {
  private String testableSite = "https://www.mail.ru/";

  private String idEnterButton = "mailbox__auth__button";
  private String idOfLoginField = "mailbox__login";
  private String idOfPasswordField = "mailbox__password";
  private String idOfLogoutField = "PH_logoutLink";

  private String validLoginMailbox = "tat-dev13";
  private String validPasswordMailbox = "23.03.2017";

  private WebDriver driver;

  /**
   * Connect to testableSite and trying to complete
   * authorization with valid fields of login and password
   */
  public AuthorizationWithTrueFields(WebDriver driver) {
    this.driver = driver;
  }

  public void doTest() {
    driver.get(testableSite);

    WebElement loginElement = driver.findElement(By.id(idOfLoginField));
    loginElement.sendKeys(validLoginMailbox);

    WebElement passwordElement = driver.findElement(By.id(idOfPasswordField));
    passwordElement.sendKeys(validPasswordMailbox);

    driver.findElement(By.id(idEnterButton)).click();

    if (driver.getTitle().equals("Входящие - Почта Mail.Ru")) {
      System.out.println("Process of authorization with valid fields work correct");
    } else {
      System.out.println("Process of authorization with valid fields work incorrect!");
    }

    driver.findElement(By.id(idOfLogoutField)).click();
  }
}
