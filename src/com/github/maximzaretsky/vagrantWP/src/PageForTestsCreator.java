package vagrantWP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vagrantWP.PageObjects.AdminPage;
import vagrantWP.PageObjects.*;

/**
 * Created by Lenovo on 26.06.2017.
 */
public class PageForTestsCreator {
  private static PageForTestsCreator instance;
  
  private WebDriver driver;
  private final static String ADMIN_LOGIN = "admin";
  private final static String ADMIN_PASSWORD = "admin";
  private final static String HOST = "localhost:8080";
  
  private PageForTestsCreator() {
  
  }
  
  public static PageForTestsCreator getInstance() {
    if (instance == null) {
      instance = new PageForTestsCreator();
    }
    return instance;
  }
  
  private void resetDriver() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(HOST);
  }
  
  public void closeDriver() {
    driver.close();
  }
  
  public MainPage getMainPage() {
    resetDriver();
    MainPage mainPage = new MainPage(driver);
    return mainPage;
  }
  
  public LoginPage getLoginPage() {
    MainPage mainPage = getMainPage();
    return mainPage.getLoginPage();
  }
  
  public AdminPage getAdminPage() {
    LoginPage loginPage = getLoginPage();
    return loginPage.authorization(ADMIN_LOGIN, ADMIN_PASSWORD);
  }
  
  public AllPagesPage getAllPagesPage() {
    AdminPage adminPage = getAdminPage();
    return adminPage.getAllPagesPage();
  }
  
  public AllPostsPage getAllPostsPage() {
    AdminPage adminPage = getAdminPage();
    return adminPage.getAllPostsPage();
  }
  
  public CreateNewPagePage getCreateNewPagePage() {
    AllPagesPage allPagesPage = getAllPagesPage();
    return allPagesPage.addNewPage();
  }
  
  public CreateNewPostPage getCreateNewPostPage() {
    AllPostsPage allPostsPage = getAllPostsPage();
    return allPostsPage.addNewPost();
  }
}
