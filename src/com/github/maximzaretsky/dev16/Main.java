package Microframework;

import Microframework.Handlers.*;
import Microframework.Loggers.*;
import Microframework.Commands.*;
import java.util.List;

/**
 * Contain main method of program
 */
public class Main {

  /**
   * This method is set property for webdriver, create chain of responsibilities
   * start executing of program and save logs in logfile
   */
  public static void main(String[] args){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    AbstractHandler concreteHandler = new OpenHandler(
                                        new CheckLinkPresentByHrefHandler(
                                          new CheckPageContainsHandler(
                                            new CheckLinkPresentByNameHandler(
                                              new CheckPageTitleHandler()))));

    CommandsReader commandsReader = new CommandsReader();
    List<String> commands = commandsReader.getCommandsExtractedFromFile();

    Logger logger = new Logger();
    WebDriverManager.getInstance().setLogger(logger);

    for (String commandString: commands) {
      ICommand concrecteCommand = concreteHandler.getCommand(commandString);
      concrecteCommand.Execute();
    }
    WebDriverManager.getInstance().close();
    WebDriverManager.getInstance().saveLogs();
  }
}
