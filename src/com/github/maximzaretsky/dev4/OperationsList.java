import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aramorchi on 18.02.2017.
 */
public class OperationsList {
  private List<Operations> operationsList = new ArrayList<>();

  public void addOperation(Operations operation) {
    operationsList.add(operation);
  }
  
  public void doOperations(List<String> text) {
    for (Operations operation: operationsList) {
      operation.doOperation(text);
    }
  }

  public void printResultsOfOperations(){
    for (Operations operation: operationsList) {
      operation.printResult();
    }
  }
}
