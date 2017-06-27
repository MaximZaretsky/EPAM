package vagrantWP.Handlers;

import vagrantWP.Tests.DeletePageTest;
import vagrantWP.Tests.ITest;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class DeletePageTestHandler extends AbstractHandler{
  private final static String DELETE_PAGE = "delete_page";
  
  private final static int INDEX_OF_COMMAND = 0;
  private final static int INDEX_OF_TITLE = 1;
  
  private String[] commandAndComponents;
  private String command;
  private String title;
  
  public DeletePageTestHandler() {
  }
  
  public DeletePageTestHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }
  
  @Override
  public ITest getTest(String commandAndParameters) throws IllegalArgumentException{
    defineCommand(commandAndParameters);
    if (command.equalsIgnoreCase(DELETE_PAGE)) {
      defineTitle();
      return new DeletePageTest(/*title*/);
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
  
  private void defineTitle() {
    title = commandAndComponents[INDEX_OF_TITLE].trim();
  }
}
