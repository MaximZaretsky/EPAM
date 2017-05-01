package Microframework.Commands;
import Microframework.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckPageTitleCommand implements ICommand {
  private String title;

  public CheckPageTitleCommand(String title) {
    this.title = title;
  }

  public void Execute() {
    BrowserProvider.getInstance().checkPageTitle(title);
  }
}
