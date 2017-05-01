package Microframework.Loggers;

/**
 * Created by Aramorchi on 01.05.2017.
 */
public class ResultOfOperation {
  private String command;
  private double executionTime;
  private String result;

  public ResultOfOperation(String command, double executionTime, String result) {
    this.command = command;
    this.executionTime = executionTime;
    this.result = result;
    System.out.println(command + " " + executionTime + " " + result);
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
