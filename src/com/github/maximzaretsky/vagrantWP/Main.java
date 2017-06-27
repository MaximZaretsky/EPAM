package vagrantWP;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import vagrantWP.Logger.ILogger;
import vagrantWP.Logger.SimpleLogger;
import vagrantWP.Tests.ITest;
import vagrantWP.Tests.InvalidAuthorizationTest;
import vagrantWP.Tests.ValidAuthorizationTest;

/**
 * Created by Lenovo on 20.06.2017.
 */
public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver",
        "chromedriver.exe");
  
    ILogger logger = new SimpleLogger();
  
    List<ITest> tests = new ArrayList<>();
    tests.add(new ValidAuthorizationTest("admin", "admin"));
    tests.add(new InvalidAuthorizationTest("arar", "qqq"));
    
    for(ITest test: tests) {
      test.setLogger(logger);
      test.run();
    }
    
    logger.saveLogsIntoFile();
  }
}
