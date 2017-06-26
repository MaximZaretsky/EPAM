package vagrantWP;

import java.lang.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Lenovo on 20.06.2017.
 */
public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver",
        "chromedriver.exe");
    
    PageForTestsCreator pageCreator = PageForTestsCreator.getInstance();
    pageCreator.getAdminPage();
    pageCreator.closeDriver();
    pageCreator.getMainPage();
    pageCreator.closeDriver();
    pageCreator.getAllPostsPage();
  }
}
