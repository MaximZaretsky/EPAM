package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 22.06.2017.
 */
public class AllPostsPage {
  private WebDriver driver;
  
  private By addNewPostLocator = By.xpath(".//a[@href = \"post-new.php\" and text()= \"Add New\"]");
  
  public AllPostsPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public CreateNewPostPage addNewPost() {
    driver.findElement(addNewPostLocator).click();
    return new CreateNewPostPage(driver);
  }
  
  
}
