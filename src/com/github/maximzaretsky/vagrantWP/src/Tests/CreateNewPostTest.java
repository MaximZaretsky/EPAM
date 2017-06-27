package vagrantWP.Tests;

import vagrantWP.Logger.ILogger;
import vagrantWP.Logger.ResultOfOperation;
import vagrantWP.PageForTestsCreator;
import vagrantWP.PageObjects.AllPostsPage;

/**
 * Created by Lenovo on 25.06.2017.
 */
public class CreateNewPostTest implements ITest{
  private final static String CREATE_NEW_POST = "[Create new post]";
  private final static String NO_TITLE = "(no title)";
  
  private PageForTestsCreator pageCreator = PageForTestsCreator.getInstance();
  
  private String title;
  private String content;
  private ILogger logger;
  
  public CreateNewPostTest(String title, String content) {
    this.title = title.trim();
    this.content = content;
  }
  
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
  
  public void run() {
    long startTime = System.currentTimeMillis();
    String status;
    
    pageCreator.getCreateNewPostPage().publishPost(title, content);
    pageCreator.closeDriver();
    AllPostsPage allPostsPage = pageCreator.getAllPostsPage();
    
    if(title.isEmpty()) {
      if (allPostsPage.isPostExist(NO_TITLE)) {
        status = TEST_PASSED;
      } else {
        status = TEST_FAILED;
      }
    } else {
      if (allPostsPage.isPostExist(title)) {
        status = TEST_PASSED;
      } else {
        status = TEST_FAILED;
      }
    }
  
    logger.addResultOfOperation(new ResultOfOperation(CREATE_NEW_POST,System.currentTimeMillis() - startTime ,status ));
    pageCreator.closeDriver();
  }
}
