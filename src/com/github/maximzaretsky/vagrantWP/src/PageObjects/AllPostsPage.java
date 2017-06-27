package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
  
  public CreateNewPostPage choosePost(String title) {
    By pageInListLocator = By.xpath(".//a[@class = \"row-title\" and text()=\"" + title + "\"]");
    driver.findElement(pageInListLocator).click();
    return new CreateNewPostPage(driver);
  }
  
  public boolean isPostExist(String title) {
    boolean answer;
    
    By pageInListLocator = By.xpath(".//a[@class = \"row-title\" and text()=\"" + title + "\"]");
    try {
      driver.findElement(pageInListLocator);
      answer = true;
    } catch (NoSuchElementException e) {
      answer = false;
    }
    return answer;
  }
}
