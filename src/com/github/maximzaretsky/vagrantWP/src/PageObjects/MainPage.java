package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 21.06.2017.
 */
public class MainPage {
  private WebDriver driver;
  
  private By searchFieldLocator = By.xpath(".//label[text() = \"Search for:\"]following-sibling::*[1]");
  private By searchButtonLocator = By.xpath(".//input[@value = \"Search\"]");
  private By logInLocator = By.xpath(".//a[text() = \"Log in\"]");
  
  public MainPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public LoginPage getLoginPage() {
    driver.findElement(logInLocator).click();
    return new LoginPage(driver);
  }
}
