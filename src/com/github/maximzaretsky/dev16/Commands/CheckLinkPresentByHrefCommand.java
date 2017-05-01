package Microframework.Commands;
import Microframework.*;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public class CheckLinkPresentByHrefCommand implements ICommand {
  private String href;

  public CheckLinkPresentByHrefCommand(String href) {
    this.href = href;
  }

  public void Execute() {
    BrowserProvider.getInstance().checkLinkPresentByHref(href);
  }
}
