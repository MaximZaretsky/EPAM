package Microframework.Handlers;

import Microframework.Commands.*;

/**
 * Handler for creation OpenCommand
 */
public class OpenHandler extends AbstractHandler {
  private String command;
  private String url;
  private int timeout;

  private ICommand concreteCommand;

  private String[] commandAndComponents;

  private final int INDEX_OF_COMMAND_COMPONENT = 0;
  private final int INDEX_OF_URL = 1;
  private final int INDEX_OF_TIMEOUT = 2;

  private final String OPEN = "Open";

  public OpenHandler() {

  }

  /**
   * Constructor
   * @param sucessor Handler, which will handle input string
   * if this handler can't
   */
  public OpenHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }

  /**
   * Create command for open necessary url with necessary timeout
   *
   * @param commandAndParameters received from fiile string
   * @return concrete command
   * @throws IllegalArgumentException if all handlers did not handle this command
   */
  public ICommand getCommand(String commandAndParameters) throws IllegalArgumentException {
    defineCommand(commandAndParameters);
    if (command.equals(OPEN)) {
      defineURL();
      defineTimeout();
      concreteCommand = new OpenCommand(url, timeout);
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

  private void defineURL() {
    url = commandAndComponents[INDEX_OF_URL].trim();
  }

  private void defineTimeout() {
    timeout = Integer.parseInt(commandAndComponents[INDEX_OF_TIMEOUT].trim());
  }
}
