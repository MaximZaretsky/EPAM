import java.util.ArrayList;
import java.util.List;

/**
 * Contain all tests in list of tests
 */
public class ArrayOfTests {
  private List<AuthorizationTest> tests = new ArrayList<>();

  /**
   * Add test into list of tests
   * @param test test which will be added into list
   */
  public void addTest(AuthorizationTest test) {
    tests.add(test);
  }

  /**
   * Start execution of all tests from list
   */
  public void doTests() {
    for (AuthorizationTest test: tests) {
      test.doTest();
    }
  }
}
