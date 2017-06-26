package vagrantWP;

import java.lang.*;
import vagrantWP.PageObjects.*;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Lenovo on 20.06.2017.
 */
public class Main {
  public static void main(String[] args) {
    Properties props = System.getProperties();
    props.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("localhost:8080");
    
    PageForTestsCreator pageCreator = new PageForTestsCreator(driver);
    pageCreator.getAdminPage();
    pageCreator = new PageForTestsCreator(driver);
    pageCreator.getMainPage();
    
  }
}
