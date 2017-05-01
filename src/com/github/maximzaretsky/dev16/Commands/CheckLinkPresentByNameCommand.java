package Microframework.Commands;
import Microframework.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckLinkPresentByNameCommand implements ICommand {
  private String name;

  public CheckLinkPresentByNameCommand(String name) {
    this.name = name;
  }

  public void Execute() {
    BrowserProvider.getInstance().checkLinkPresentByName(name);
  }
}
