package Microframework.Handlers;

import Microframework.Commands.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckLinkPresentByHrefHandler extends AbstractHandler {
  private String command;
  private String href;
  private ICommand concreteCommand;

  private String[] commandAndComponents;

  private final int INDEX_OF_COMMAND_COMPONENT = 0;
  private final int INDEX_OF_HREF = 1;

  private final String CHECK_LINK_PRESENT_BY_HREF = "CheckLinkPresentByHref";

  public CheckLinkPresentByHrefHandler() {

  }

  /**
   * Constructor
   * @param sucessor Handler, which will handle input string
   * if this handler can't
   */
  public CheckLinkPresentByHrefHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }

  /**
   * Create command for finding webelement with necessary href tag
   *
   * @param commandAndParameters received from console string
   * @return concrete command
   * @throws IllegalArgumentException if all handlers did not handle this command
   */
  public ICommand getCommand(String commandAndParameters) throws IllegalArgumentException {
    defineCommand(commandAndParameters);
    if (command.equals(CHECK_LINK_PRESENT_BY_HREF)) {
      defineHref();
      concreteCommand = new CheckLinkPresentByHrefCommand(href);
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

  private void defineHref() {
    href = commandAndComponents[INDEX_OF_HREF].trim();
  }
}
