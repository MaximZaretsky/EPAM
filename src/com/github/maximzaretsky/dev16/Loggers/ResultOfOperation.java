package Microframework.Loggers;

/**
 * Class contains result of executing of command
 */
public class ResultOfOperation {
  private String command;
  private double executionTime;
  private String result;

  public ResultOfOperation(String command, double executionTime, String result) {
    this.command = command;
    this.executionTime = executionTime;
    this.result = result;
  }

  public double getExecutionTime() {
    return executionTime;
  }

  public String getResult() {
    return result;
  }

  public String getCommand() {
    return command;
  }
}
