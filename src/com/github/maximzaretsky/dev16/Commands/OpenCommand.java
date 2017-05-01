package Microframework.Commands;
import Microframework.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class OpenCommand implements ICommand {
  private String url;
  private int timeout;

  public OpenCommand(String url, int timeout) {
    this.url = url;
    this.timeout = timeout;
  }

  public void Execute() {
    BrowserProvider.getInstance().openWithTimeout(url, timeout);
  }
}
