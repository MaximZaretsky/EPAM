package Microframework.Handlers;

import Microframework.Commands.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckPageContainsHandler extends AbstractHandler {
  private String command;
  private String content;
  private ICommand concreteCommand;

  private String[] commandAndComponents;

  private final int INDEX_OF_COMMAND_COMPONENT = 0;
  private final int INDEX_OF_CONTENT = 1;

  private final String CHECK_PAGE_CONTAINS = "CheckPageContains";

  public CheckPageContainsHandler() {

  }

  /**
   * Constructor
   * @param sucessor Handler, which will handle input string
   * if this handler can't
   */
  public CheckPageContainsHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }

  /**
   * Create command for finding necessary string on page
   *
   * @param commandAndParameters received from console string
   * @return concrete command
   * @throws IllegalArgumentException if all handlers did not handle this command
   */
  public ICommand getCommand(String commandAndParameters) throws IllegalArgumentException {
    defineCommand(commandAndParameters);
    if (command.equals(CHECK_PAGE_CONTAINS)) {
      defineContent();
      concreteCommand = new CheckPageContainsCommand(content);
      return concreteCommand;
    } else if (sucessor != null) {
      return sucessor.getCommand(commandAndParameters);
    } else {
      throw new IllegalArgumentException("Was entered wrong command!");
    }
  }

  private void defineCommand(String inputString) {
    commandAndComponents = inputString.split("[|]");

    command = commandAndComponents[INDEX_OF_COMMAND_COMPONENT].trim();
  }

  private void defineContent() {
    content = commandAndComponents[INDEX_OF_CONTENT].trim();
  }
}
