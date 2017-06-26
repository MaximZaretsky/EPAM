package vagrantWP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 22.06.2017.
 */
public class AllPagesPage {
  private WebDriver driver;
  
  private By addNewPageLocator = By.xpath(".//a[@href = \"post-new.php?post_type=page\" and text()= \"Add New\"][1]");
  private By pageInListLocator;
  
  public AllPagesPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public CreateNewPagePage addNewPage() {
    driver.findElement(addNewPageLocator).click();
    return new CreateNewPagePage(driver);
  }
  
  public CreateNewPagePage choosePage(String title) {
    pageInListLocator = By.xpath(".//a[@class = \"row-title\" and text()=\"" + title + "\"]");
    driver.findElement(pageInListLocator).click();
    return new CreateNewPagePage(driver);
  }
}
