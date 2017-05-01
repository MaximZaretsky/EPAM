package Microframework;

import Microframework.Handlers.*;
import Microframework.Loggers.*;
import Microframework.Commands.*;
import java.util.List;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class Main {
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
    BrowserProvider.getInstance().setLogger(logger);

    for (String commandString: commands) {
      ICommand concrecteCommand = concreteHandler.getCommand(commandString);
      concrecteCommand.Execute();
    }
    BrowserProvider.getInstance().close();
    BrowserProvider.getInstance().saveLogs();
  }
}
