package Microframework.Loggers;

/**
 * Created by Aramorchi on 01.05.2017.
 */
public interface ILogger {
  void addResultOfOperation(ResultOfOperation resultOfOperation);
  void saveLogsIntoFile();
}
