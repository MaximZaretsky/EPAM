package vagrantWP.Tests;

import vagrantWP.Logger.ILogger;
import vagrantWP.Logger.ResultOfOperation;
import vagrantWP.PageForTestsCreator;
import vagrantWP.PageObjects.AdminPage;

/**
 * Created by Lenovo on 25.06.2017.
 */
public class ValidAuthorizationTest implements ITest {
  private final static String  VALID_AUTHORIZATION = "[Valid authorization]";
  
  
  private PageForTestsCreator pageCreator = PageForTestsCreator.getInstance();
  
  private String login;
  private String password;
  
  private ILogger logger;
  
  public ValidAuthorizationTest(String login, String password) {
    this.login = login;
    this.password = password;
  }
  
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
  
  public void run() {
    String status;
    long startTime = System.currentTimeMillis();
    
    AdminPage adminPage = pageCreator.getLoginPage().authorization(login, password);
    if (adminPage.isAdminPage()) {
      status = TEST_PASSED;
    } else {
      status = TEST_FAILED;
    }
    
    logger.addResultOfOperation(new ResultOfOperation(VALID_AUTHORIZATION ,System.currentTimeMillis() - startTime ,status ));
    pageCreator.closeDriver();
  }
}
