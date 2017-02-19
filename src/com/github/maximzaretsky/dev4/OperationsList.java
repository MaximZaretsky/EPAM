import java.util.ArrayList;
import java.util.List;

/**
 * This class contain operations, which we need
 * to make on received text
 */
public class OperationsList {
  private List<Operations> operationsList = new ArrayList<>();

  /**
   * Add received operation in list of operation
   *
   * @param operation
   */
  public void addOperation(Operations operation) {
    operationsList.add(operation);
  }

  /**
   * Execute all operations, which operationsList contain
   *
   * @param text is milled text, received from user
   */
  public void doOperations(List<String> text) {
    for (Operations operation: operationsList) {
      operation.doOperation(text);
    }
  }

  /**
   * Print result of executing each operation,
   * which contain operationsList
   */
  public void printResultsOfOperations(){
    for (Operations operation: operationsList) {
      operation.printResult();
    }
  }
}
