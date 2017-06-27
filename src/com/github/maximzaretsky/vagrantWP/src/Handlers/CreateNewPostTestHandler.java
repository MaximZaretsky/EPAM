package vagrantWP.Handlers;

import vagrantWP.Tests.CreateNewPostTest;
import vagrantWP.Tests.ITest;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class CreateNewPostTestHandler extends AbstractHandler {
  private final static String CREATE_NEW_POST = "create_new_post";
  
  private final static int INDEX_OF_COMMAND = 0;
  private final static int INDEX_OF_TITLE = 1;
  private final static int INDEX_OF_CONTENT = 2;
  
  private String[] commandAndComponents;
  private String command;
  private String title;
  private String content;
  
  public CreateNewPostTestHandler() {
  }
  
  public CreateNewPostTestHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }
  
  @Override
  public ITest getTest(String commandAndParameters) throws IllegalArgumentException{
    defineCommand(commandAndParameters);
    if (command.equalsIgnoreCase(CREATE_NEW_POST)) {
      defineTitleAndContent();
      return new CreateNewPostTest(title, content);
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
  
  private void defineTitleAndContent() {
    title = commandAndComponents[INDEX_OF_TITLE];
    content = commandAndComponents[INDEX_OF_CONTENT];
  }
}
