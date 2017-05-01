package Microframework.Commands;
import Microframework.*;

/**
 * Command for comparing title of page with received title
 */
public class CheckPageTitleCommand implements ICommand {
  private String title;

  public CheckPageTitleCommand(String title) {
    this.title = title;
  }

  /**
   * Call method of WebDriverManager for comparing title of page with received title
   */
  public void Execute() {
    WebDriverManager.getInstance().checkPageTitle(title);
  }
}
