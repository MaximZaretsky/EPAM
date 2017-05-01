package Microframework.Handlers;

import Microframework.Commands.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckPageTitleHandler extends AbstractHandler {
  private String command;
  private String title;
  private ICommand concreteCommand;

  private String[] commandAndComponents;

  private final int INDEX_OF_COMMAND_COMPONENT = 0;
  private final int INDEX_OF_TITLE = 1;

  private final String CHECK_PAGE_TITLE = "CheckPageTitle";

  public CheckPageTitleHandler() {

  }

  /**
   * Constructor
   * @param sucessor Handler, which will handle input string
   * if this handler can't
   */
  public CheckPageTitleHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }

  /**
   * Create command for comparing title of page with necessary title
   *
   * @param commandAndParameters received from fiile string
   * @return concrete command
   * @throws IllegalArgumentException if all handlers did not handle this command
   */
  public ICommand getCommand(String commandAndParameters) throws IllegalArgumentException {
    defineCommand(commandAndParameters);
    if (command.equals(CHECK_PAGE_TITLE)) {
      defineTitle();
      concreteCommand = new CheckPageTitleCommand(title);
      return concreteCommand;
    } else if (sucessor != null) {
      return sucessor.getCommand(commandAndParameters);
    } else {
      throw new IllegalArgumentException("Was entered wrong command!");
    }
  }

  /**
   * Extract command from received from console string
   *
   * @param inputString received from console string
   */
  private void defineCommand(String inputString) {
    commandAndComponents = inputString.split("[|]");

    command = commandAndComponents[INDEX_OF_COMMAND_COMPONENT].trim();
  }

  private void defineTitle() {
    title = commandAndComponents[INDEX_OF_TITLE].trim();
  }
}
