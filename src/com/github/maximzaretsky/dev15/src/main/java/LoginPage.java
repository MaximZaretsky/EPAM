import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Aramorchi on 30.03.2017.
 */
public class LoginPage {

  By passwordLocator = By.id("mailbox__password");
  By loginLocator = By.id("mailbox__login");
  By loginButtonLocator = By.id("mailbox__auth__button");

  private final WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage typePassword(String password) {
    driver.findElement(passwordLocator).sendKeys(password);
    return this;
  }

  public LoginPage typeLogin(String login) {
    driver.findElement(loginLocator);
    return this;
  }

  public AuthorizedPage clickLoginButton() {
    driver.findElement(loginButtonLocator).submit();
    return new AuthorizedPage(driver);
  }
}
