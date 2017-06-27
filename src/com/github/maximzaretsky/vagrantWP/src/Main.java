package vagrantWP;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import vagrantWP.Handlers.*;
import vagrantWP.Logger.*;
import vagrantWP.Tests.*;

/**
 * Created by Lenovo on 20.06.2017.
 */
public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver",
        "chromedriver.exe");
  
    ILogger logger = new SimpleLogger();
    CommandsReader commandsReader = new CommandsReader();
  
    AbstractHandler handler = new CreateNewPageTestHandler(
                                  new CreateNewPostTestHandler(
                                      new ValidAuthorizationTestHandler(
                                          new InvalidAuthorizationTestHandler())));
    
    List<String> commands = commandsReader.getCommandsExtractedFromFile();
    List<ITest> tests = new ArrayList<>();
    
    for(String command: commands) {
      tests.add(handler.getTest(command));
    }
  
    try {
      for (ITest test : tests) {
        test.setLogger(logger);
        test.run();
      }
    } catch (Throwable e) {
      logger.addResultOfOperation(new ResultOfOperation(e.getMessage(), 0, "!"));
    }
    
    logger.saveLogsIntoFile();
  }
}
