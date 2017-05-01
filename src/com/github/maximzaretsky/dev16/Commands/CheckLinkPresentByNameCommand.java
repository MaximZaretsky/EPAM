package Microframework.Commands;
import Microframework.*;

/**
 * Command for finding webelement with received name tag on page
 */
public class CheckLinkPresentByNameCommand implements ICommand {
  private String name;

  public CheckLinkPresentByNameCommand(String name) {
    this.name = name;
  }

  /**
   * Call method of WebDriverManager for finding webelement with received name tag on page
   */
  public void Execute() {
    WebDriverManager.getInstance().checkLinkPresentByName(name);
  }
}
