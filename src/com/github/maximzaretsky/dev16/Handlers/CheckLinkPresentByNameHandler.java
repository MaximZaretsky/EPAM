package Microframework.Handlers;

import Microframework.Commands.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckLinkPresentByNameHandler extends AbstractHandler {
  private String command;
  private String name;
  private ICommand concreteCommand;

  private String[] commandAndComponents;

  private final int INDEX_OF_COMMAND_COMPONENT = 0;
  private final int INDEX_OF_NAME = 1;

  private final String CHECK_LINK_PRESENT_BY_NAME = "CheckLinkPresentByName";

  public CheckLinkPresentByNameHandler() {

  }

  /**
   * Constructor
   * @param sucessor Handler, which will handle input string
   * if this handler can't
   */
  public CheckLinkPresentByNameHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }

  /**
   * Create command for adding note in notebook
   *
   * @param commandAndParameters received from console string
   * @return concrete command
   * @throws IllegalArgumentException if all handlers did not handle this command
   */
  public ICommand getCommand(String commandAndParameters) throws IllegalArgumentException {
    defineCommand(commandAndParameters);
    if (command.equals(CHECK_LINK_PRESENT_BY_NAME)) {
      defineName();
      concreteCommand = new CheckLinkPresentByNameCommand(name);
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

  private void defineName() {
    name = commandAndComponents[INDEX_OF_NAME].trim();
  }
}
