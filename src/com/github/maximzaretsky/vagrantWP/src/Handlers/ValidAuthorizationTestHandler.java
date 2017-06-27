package vagrantWP.Handlers;

import vagrantWP.Tests.ITest;
import vagrantWP.Tests.ValidAuthorizationTest;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class ValidAuthorizationTestHandler extends AbstractHandler {
  private final static String VALID_AUTHORIZATION = "valid_authorization";
  
  private final static int INDEX_OF_COMMAND = 0;
  private final static int INDEX_OF_LOGIN = 1;
  private final static int INDEX_OF_PASSWORD = 2;
  
  private String[] commandAndComponents;
  private String command;
  private String login;
  private String password;
  
  public ValidAuthorizationTestHandler() {
  }
  
  public ValidAuthorizationTestHandler(AbstractHandler sucessor) {
    this.sucessor = sucessor;
  }
  
  @Override
  public ITest getTest(String commandAndParameters) throws IllegalArgumentException{
    defineCommand(commandAndParameters);
    if (command.equalsIgnoreCase(VALID_AUTHORIZATION)) {
      defineLoginAndPassword();
      return new ValidAuthorizationTest(login, password);
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
