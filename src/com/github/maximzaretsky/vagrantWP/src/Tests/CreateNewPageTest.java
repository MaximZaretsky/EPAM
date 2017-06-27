package vagrantWP.Tests;

import vagrantWP.Logger.*;
import vagrantWP.PageForTestsCreator;
import vagrantWP.PageObjects.AllPagesPage;

/**
 * Created by Lenovo on 25.06.2017.
 */
public class CreateNewPageTest implements ITest{
  private final static String CREATE_NEW_PAGE = "[Create new page]";
  private final static String NO_TITLE = "(no title)";
  
  private PageForTestsCreator pageCreator = PageForTestsCreator.getInstance();
  
  private String title;
  private String content;
  private ILogger logger;
  
  public CreateNewPageTest(String title, String content) {
    this.title = title.trim();
    this.content = content;
  }
  
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
  
  public void run() {
    long startTime = System.currentTimeMillis();
    String status;
    
    pageCreator.getCreateNewPagePage().publishPage(title, content);
    pageCreator.closeDriver();
    
    AllPagesPage allPagesPage = pageCreator.getAllPagesPage();
    if(title.isEmpty()) {
      if (allPagesPage.isPageExist(NO_TITLE)) {
        status = TEST_PASSED;
      } else {
        status = TEST_FAILED;
      }
    } else {
      if (allPagesPage.isPageExist(title)) {
        status = TEST_PASSED;
      } else {
        status = TEST_FAILED;
      }
    }
  
    logger.addResultOfOperation(new ResultOfOperation(CREATE_NEW_PAGE,System.currentTimeMillis() - startTime ,status ));
    pageCreator.closeDriver();
  }
  
}
