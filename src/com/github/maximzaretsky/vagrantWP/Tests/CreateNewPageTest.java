package vagrantWP.Tests;

import vagrantWP.Logger.*;
import vagrantWP.PageForTestsCreator;

/**
 * Created by Lenovo on 25.06.2017.
 */
public class CreateNewPageTest implements ITest{
  private PageForTestsCreator pageCreator = PageForTestsCreator.getInstance();
  
  private String title;
  private String content;
  private ILogger logger;
  
  public CreateNewPageTest(String title, String content) {
    this.title = title;
    this.content = content;
  }
  
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
  
  public void run() {
    pageCreator.getCreateNewPagePage().publishPage(title, content);
  }
}
