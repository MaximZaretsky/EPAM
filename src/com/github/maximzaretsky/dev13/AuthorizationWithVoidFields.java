import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contain method for authorization with void fields
 * of login and password
 */
public class AuthorizationWithVoidFields implements AuthorizationTest{

  private String testableSite = "https://www.mail.ru/";

  private String idEnterButton = "mailbox__auth__button";
  private String idOfLoginField = "mailbox__login";
  private String idOfPasswordField = "mailbox__password";

  private String validLoginMailbox = "";
  private String validPasswordMailbox = "";

  private WebDriver driver;

  public AuthorizationWithVoidFields(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Connect to testableSite and trying to complete
   * authorization with void fields of login and password
   */
  public void doTest() {
    driver.get(testableSite);

    WebElement loginElement = driver.findElement(By.id(idOfLoginField));
    loginElement.clear();
    loginElement.sendKeys(validLoginMailbox);

    WebElement passwordElement = driver.findElement(By.id(idOfPasswordField));
    passwordElement.sendKeys(validPasswordMailbox);

    WebElement enterElement = driver.findElement(By.id(idEnterButton));
    enterElement.click();

    WebElement badAuthorizationElement = driver.findElement(By.xpath("//div[contains(@class, \"b-login__errors\")]"));

    if (badAuthorizationElement.isEnabled()) {
      System.out.println("Process of authorization with void fields work correct");
    } else {
      System.out.println("Process of authorization with void fields work incorrect!");
    }
  }
}
