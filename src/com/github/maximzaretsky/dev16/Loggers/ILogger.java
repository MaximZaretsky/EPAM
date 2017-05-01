package Microframework.Loggers;

/**
 * Interface of logger
 */
public interface ILogger {
  void addResultOfOperation(ResultOfOperation resultOfOperation);
  void saveLogsIntoFile();
}
