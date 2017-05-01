package Microframework.Commands;
import Microframework.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckPageContainsCommand implements ICommand{
  private String content;

  public CheckPageContainsCommand(String content) {
    this.content = content;
  }

  public void Execute() {
    BrowserProvider.getInstance().checkPageContains(content);
  }
}
