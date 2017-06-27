package vagrantWP.Handlers;

import vagrantWP.Tests.ITest;
import vagrantWP.Tests.InvalidAuthorizationTest;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class InvalidAuthorizationTestHandler extends AbstractHandler{
  private final static String INVALID_AUTHORIZATION = "invalid_authorization";
  
  private final static int INDEX_OF_COMMAND = 0;
  private final static int INDEX_OF_LOGIN = 1;
  private final static int INDEX_OF_PASSWORD = 2;
  
  private String[] commandAndComponents;
  private String command;
  private String login;
  private String password;
  
  public InvalidAuthorizationTestHandler() {
  }
  
  public InvalidAuthorizationTestHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }
  
  @Override
  public ITest getTest(String commandAndParameters) throws IllegalArgumentException{
    defineCommand(commandAndParameters);
    if (command.equalsIgnoreCase(INVALID_AUTHORIZATION)) {
      defineLoginAndPassword();
      return new InvalidAuthorizationTest(login, password);
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
  
  private void defineLoginAndPassword() {
    login = commandAndComponents[INDEX_OF_LOGIN].trim();
    password = commandAndComponents[INDEX_OF_PASSWORD].trim();
  }
}
