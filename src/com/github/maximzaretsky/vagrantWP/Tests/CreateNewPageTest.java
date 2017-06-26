package vagrantWP.Tests;

import org.openqa.selenium.WebDriver;
import vagrantWP.PageForTestsCreator;

/**
 * Created by Lenovo on 25.06.2017.
 */
public class CreateNewPageTest {
  private PageForTestsCreator pageCreator;
  
  public CreateNewPageTest(PageForTestsCreator pageCreator) {
    this.pageCreator = pageCreator;
  }
  
  public void createNewPage(String title, String author) {
    pageCreator.getCreateNewPagePage().publishPage(title, author);
  }
}
