package vagrantWP.Logger;

/**
 * Created by Lenovo on 27.06.2017.
 */
public interface ILogger {
  void addResultOfOperation(ResultOfOperation resultOfOperation);
  void saveLogsIntoFile();
}
