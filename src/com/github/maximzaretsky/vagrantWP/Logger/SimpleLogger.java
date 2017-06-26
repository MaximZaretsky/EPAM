package vagrantWP.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class SimpleLogger implements ILogger {
  
  private List<ResultOfOperation> results = new ArrayList<>();
  
  private final String MESSAGE_TOTAL_TESTS = "Total tests: ";
  private final String MESSAGE_PASSED_FAILED = "Passed/Failed: ";
  private final String MESSAGE_TOTAL_TIME = "Total time: ";
  private final String MESSAGE_AVERAGE_TIME = "Average time: ";
  
  @Override
  public void addResultOfOperation(ResultOfOperation resultOfOperation) {
  
  }
  
  @Override
  public void saveLogsIntoFile() {
  
  }
}
