package Microframework.Commands;
import Microframework.*;

/**
 * Command for finding received string on page
 */
public class CheckPageContainsCommand implements ICommand{
  private String content;

  public CheckPageContainsCommand(String content) {
    this.content = content;
  }

  /**
   * Call method of WebDriverManager for finding received string on page
   */
  public void Execute() {
    WebDriverManager.getInstance().checkPageContains(content);
  }
}
