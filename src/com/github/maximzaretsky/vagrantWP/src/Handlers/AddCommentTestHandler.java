package vagrantWP.Handlers;

import vagrantWP.Tests.AddCommentTest;
import vagrantWP.Tests.ITest;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class AddCommentTestHandler extends AbstractHandler {
  private final static String ADD_COMMENT = "add_comment";
  
  private final static int INDEX_OF_COMMAND = 0;
  private final static int INDEX_OF_COMMENT = 1;
  
  private String[] commandAndComponents;
  private String command;
  private String comment;
  
  public AddCommentTestHandler() {
  }
  
  public AddCommentTestHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }
  
  @Override
  public ITest getTest(String commandAndParameters) throws IllegalArgumentException{
    defineCommand(commandAndParameters);
    if (command.equalsIgnoreCase(ADD_COMMENT)) {
      defineComment();
      return new AddCommentTest(comment);
    } else if (sucessor != null) {
      return sucessor.getTest(commandAndParameters);
    } else {
      throw new IllegalArgumentException("Wrong command!");
    }
  }
  
  private void defineCommand(String commandAndParameters) {
    commandAndComponents = commandAndParameters.split("[|]");
    command = commandAndComponents[INDEX_OF_COMMAND].trim();
  }
  
  private void defineComment() {
    comment = commandAndComponents[INDEX_OF_COMMENT].trim();
  }
}
