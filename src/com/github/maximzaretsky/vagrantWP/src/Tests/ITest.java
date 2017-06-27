package vagrantWP.Tests;

import vagrantWP.Logger.ILogger;

/**
 * Created by Lenovo on 27.06.2017.
 */
public interface ITest {
  String TEST_PASSED = "[Passed]";
  String TEST_FAILED = "[Failed]";
  
  void run();
  void setLogger(ILogger logger);
}
