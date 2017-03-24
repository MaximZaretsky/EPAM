import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contain method for authorization with invalid field
 * of password and valid field of login
 */
public class AuthorizationWithInvalidPassword implements AuthorizationTest{
  private String testableSite = "https://www.mail.ru/";

  private String idEnterButton = "mailbox__auth__button";
  private String idOfLoginField = "mailbox__login";
  private String idOfPasswordField = "mailbox__password";

  private String validLoginMailbox = "tat-dev13";
  private String invalidPasswordMailbox = "glfkcjh";

  private WebDriver driver;

  public AuthorizationWithInvalidPassword(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Connect to testableSite and trying to complete
   * authorization with valid field of login
   * and invalid field of password
   */
  public void doTest() {
    driver.get(testableSite);

    WebElement loginElement = driver.findElement(By.id(idOfLoginField));
    loginElement.clear();
    loginElement.sendKeys(validLoginMailbox);

    WebElement passwordElement = driver.findElement(By.id(idOfPasswordField));
    passwordElement.sendKeys(invalidPasswordMailbox);

    WebElement enterElement = driver.findElement(By.id(idEnterButton));
    enterElement.click();

    WebElement badAuthorizationElement = driver.findElement(By.xpath("//div[contains(@class, \"b-login__errors\")]"));

    if (badAuthorizationElement.isEnabled()) {
      System.out.println("Process of authorization with invalid password work correct");
    } else {
      System.out.println("Process of authorization with invalid password work incorrect!");
    }
  }
}
