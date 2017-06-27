package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 21.06.2017.
 */
public class LoginPage {
  private WebDriver driver;
  
  private By loginFieldLocator = By.xpath(".//input[@id = \"user_login\"]");
  private By passwordFieldLocator = By.xpath(".//input[@id = \"user_pass\"]");
  private By logInKey = By.xpath(".//input[@type = \"submit\" and @value = \"Log In\"]");
  private By wrongLoginMessage = By.xpath(".//div[@id = \"login_error\"]");
  
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public AdminPage authorization(String login, String password) {
    sendLogin(login);
    sendPassword(password);
    clickLoginButton();
    return new AdminPage(driver);
  }
  
  public LoginPage incorrectAuthorization(String login, String password) {
    sendLogin(login);
    sendPassword(password);
    clickLoginButton();
    return new LoginPage(driver);
  }
  
  public boolean isWrongAuthorization() {
    boolean answer;
    try {
      driver.findElement(wrongLoginMessage);
      answer = true;
    } catch (NoSuchElementException e) {
      answer = false;
    }
    return answer;
  }
  
  private void sendLogin(String login) {
    driver.findElement(loginFieldLocator).sendKeys(login);
  }
  
  private void sendPassword(String password) {
    driver.findElement(passwordFieldLocator).sendKeys(password);
  }
  
  private void clickLoginButton() {
    driver.findElement(logInKey).click();
  }
}
