package Microframework.Loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization of logger
 */
public class Logger implements ILogger {

  private List<ResultOfOperation> results = new ArrayList<>();

  private final String MESSAGE_TOTAL_TESTS = "Total tests: ";
  private final String MESSAGE_PASSED_FAILED = "Passed/Failed: ";
  private final String MESSAGE_TOTAL_TIME = "Total time: ";
  private final String MESSAGE_AVERAGE_TIME = "Average time: ";


  /**
   * Add received result of executing of command into list with results
   * @param resultOfOperation
   */
  public void addResultOfOperation(ResultOfOperation resultOfOperation) {
    results.add(resultOfOperation);
  }

  /**
   * Save information about executed command into file
   */
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

  /**
   * Return number of all executed tests
   * @return number of all executed tests
   */
  public int calculateNumberOfTests() {
    return results.size();
  }

  /**
   * Return number of all passed tests
   * @return number of all passed tests
   */
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

  /**
   * Return average time of executing test
   * @return average time of executing test
   */
  public double calculateAverageTime() {
    return calculateTotalTime()/calculateNumberOfTests();
  }

  /**
   * Return number of all failed tests
   * @return number of all failed tests
   */
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
