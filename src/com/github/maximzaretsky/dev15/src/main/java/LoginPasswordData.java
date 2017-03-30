import org.testng.annotations.DataProvider;

/**
 * Created by Aramorchi on 30.03.2017.
 */
public class LoginPasswordData {

  @DataProvider (name = "validLoginPasswordData")
  public static Object[][] validLoginPasswordData() {
    return new Object[][] {
      {"tat-dev13", "23.03.2017"}
    };
  }

  @DataProvider (name = "invalidLoginPasswordData")
  public static Object[][] invalidLoginPasswordData() {
    return new Object[][] {
        {"", ""},
        {"tattt-dev13", "23.03.2017"},
        {"tat-dev13", "glfkcjh"}
    };
  }
}
