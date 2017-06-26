package Microframework.Commands;
import Microframework.*;

/**
 * Command for finding webelement with received href tag on page
 */
public class CheckLinkPresentByHrefCommand implements ICommand {
  private String href;

  public CheckLinkPresentByHrefCommand(String href) {
    this.href = href;
  }

  /**
   * Call method of WebDriverManager for finding webelement with received href tag on page
   */
  public void Execute() {
    WebDriverManager.getInstance().checkLinkPresentByHref(href);
  }
}
