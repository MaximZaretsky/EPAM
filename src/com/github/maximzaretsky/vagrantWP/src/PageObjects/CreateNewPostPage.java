package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 22.06.2017.
 */
public class CreateNewPostPage {
  private WebDriver driver;
  
  private By publishButtonLocator = By.xpath(".//input[@id = \"publish\"]");
  private By deleteButtonLocator = By.xpath(".//a[@class = \"submitdelete deletion\" and text()= \"Move to Trash\"]");
  private By textButtonLocator = By.xpath(".//a[@id = \"content-html\" and text() = \"Text\"]");
  private By postTitleLocator = By.xpath(".//input[@name = \"post_title\"]");
  private By postContentLocator = By.xpath(".//textarea[@class = \"wp-editor-area\" and @name = \"content\"]");
  
  public CreateNewPostPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void publishPost(String title, String content) {
    setTitle(title);
    driver.findElement(textButtonLocator).click();
    setContent(content);
    driver.findElement(publishButtonLocator).click();
  }
  
  public void deletePost() {
    driver.findElement(deleteButtonLocator).click();
  }
  
  private void setTitle(String title) {
    driver.findElement(postTitleLocator).sendKeys(title);
  }
  
  private void setContent(String content) {
    driver.findElement(postContentLocator).sendKeys(content);
  }
}
