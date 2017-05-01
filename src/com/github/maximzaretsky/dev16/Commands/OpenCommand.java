package Microframework.Commands;
import Microframework.*;

/**
 * Command for opening received url during received timeout
 */
public class OpenCommand implements ICommand {
  private String url;
  private int timeout;

  public OpenCommand(String url, int timeout) {
    this.url = url;
    this.timeout = timeout;
  }

  /**
   * Call method of WebDriverManager for opening received url during received timeout
   */
  public void Execute() {
    WebDriverManager.getInstance().openWithTimeout(url, timeout);
  }
}
