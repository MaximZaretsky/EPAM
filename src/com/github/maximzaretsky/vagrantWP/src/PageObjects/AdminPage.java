package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 21.06.2017.
 */
public class AdminPage {
  private WebDriver driver;
  
  private By postsLocator = By.xpath(".//div[text()= \"Posts\"]");
  private By pagesLocator = By.xpath(".//div[text()= \"Pages\"]");
  private By adminLocator = By.xpath(".//div[@id = \"adminmenuback\"]");
  
  public AdminPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public AllPostsPage getAllPostsPage() {
    driver.findElement(postsLocator).click();
    return new AllPostsPage(driver);
  }
  
  public AllPagesPage getAllPagesPage() {
    driver.findElement(pagesLocator).click();
    return new AllPagesPage(driver);
  }
  
  public boolean isAdminPage() {
    boolean answer;
    try {
      driver.findElement(adminLocator);
      answer = true;
    } catch (NoSuchElementException e) {
      answer = false;
    }
    return answer;
  }
}
