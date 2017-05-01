package Microframework.Loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aramorchi on 01.05.2017.
 */
public class Logger implements ILogger {

  private List<ResultOfOperation> results = new ArrayList<>();

  private final String MESSAGE_TOTAL_TESTS = "Total tests: ";
  private final String MESSAGE_PASSED_FAILED = "Passed/Failed: ";
  private final String MESSAGE_TOTAL_TIME = "Total time: ";
  private final String MESSAGE_AVERAGE_TIME = "Average time: ";


  @Override
  public void addResultOfOperation(ResultOfOperation resultOfOperation) {
    results.add(resultOfOperation);
  }

  @Override
  public void saveLogsIntoFile() {
    try (FileWriter fileWriter = new FileWriter("log.txt", false)) {
      for (ResultOfOperation resultOfOperation: results) {
        fileWriter.write(resultOfOperation.getResult() +
                             " " + resultOfOperation.getCommand() +
                             " " + resultOfOperation.getExecutionTime() +"\n");
      }
      fileWriter.write(MESSAGE_TOTAL_TESTS + calculateNumberOfTests() + "\n");
      fileWriter.write(MESSAGE_PASSED_FAILED + calculateNumberOfPassedTests() + "/" + calculateNumberOfFailedTests() + "\n");
      fileWriter.write(MESSAGE_TOTAL_TIME + calculateTotalTime() + "\n");
      fileWriter.write(MESSAGE_AVERAGE_TIME + calculateAverageTime() + "\n");
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
  }

  public int calculateNumberOfTests() {
    return results.size();
  }

  public int calculateNumberOfPassedTests() {
    int passedTests = 0;

    for (ResultOfOperation resultOfOperation : results) {
      if (resultOfOperation.getResult().equals("+")) {
        passedTests++;
      }
    }
    return passedTests;
  }

  public double calculateTotalTime() {
    double totalTime = 0;

    for (ResultOfOperation resultOfOperation : results) {
      totalTime += resultOfOperation.getExecutionTime();
    }
    return totalTime;
  }

  public double calculateAverageTime() {
    return calculateTotalTime()/calculateNumberOfTests();
  }

  public int calculateNumberOfFailedTests() {
    int passedTests = 0;

    for (ResultOfOperation resultOfOperation : results) {
      if (resultOfOperation.getResult().equals("!")) {
        passedTests++;
      }
    }
    return passedTests;
  }
}
