package vagrantWP;

import org.openqa.selenium.WebDriver;
import vagrantWP.PageObjects.AdminPage;
import vagrantWP.PageObjects.*;

/**
 * Created by Lenovo on 26.06.2017.
 */
public class PageForTestsCreator {
  private WebDriver driver;
  private final static String ADMIN_LOGIN = "admin";
  private final static String ADMIN_PASSWORD = "admin";
  
  public PageForTestsCreator(WebDriver driver) {
    this.driver = driver;
  }
  
  public MainPage getMainPage() {
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
