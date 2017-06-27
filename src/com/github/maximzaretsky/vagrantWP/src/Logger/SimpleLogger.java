package vagrantWP.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 27.06.2017.
 */
public class SimpleLogger implements ILogger {
  
  private List<ResultOfOperation> results = new ArrayList<>();
  
  private static final String MESSAGE_TOTAL_TESTS = "Total tests: ";
  private static final String MESSAGE_PASSED_FAILED = "Passed/Failed: ";
  private static final String MESSAGE_TOTAL_TIME = "Total time: ";
  private static final String PASSED_TEST = "[Passed]";
  private static final String FAILED_TEST = "[Failed]";
  
  @Override
  public void addResultOfOperation(ResultOfOperation resultOfOperation) {
    results.add(resultOfOperation);
  }
  
  @Override
  public void saveLogsIntoFile() {
    try (FileWriter writer = new FileWriter("log.txt")) {
      writer.write(MESSAGE_TOTAL_TESTS + results.size() + "\n");
      writer.write(MESSAGE_PASSED_FAILED + countPassedTests() + "/" + countFailedTests() + "\n");
      for(ResultOfOperation resultOfOperation: results) {
        writer.write(resultOfOperation.getCommand() + " " + resultOfOperation.getResult() + " " + resultOfOperation.getExecutionTime() + " ms \n");
      }
      writer.write(MESSAGE_TOTAL_TIME + getTotalTime() + " ms");
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
  }
  
  private int countPassedTests() {
    int passedTests = 0;
    for(ResultOfOperation resultOfOperation: results) {
      if(resultOfOperation.getResult().equalsIgnoreCase(PASSED_TEST)) {
        passedTests++;
      }
    }
    return passedTests;
  }
  
  private int countFailedTests() {
    int failedTests = 0;
    for(ResultOfOperation resultOfOperation: results) {
      if(resultOfOperation.getResult().equalsIgnoreCase(FAILED_TEST)) {
        failedTests++;
      }
    }
    return failedTests;
  }
  
  private double getTotalTime() {
    double totalTime = 0;
    
    for(ResultOfOperation resultOfOperation: results) {
      totalTime += resultOfOperation.getExecutionTime();
    }
    return totalTime;
  }
}
