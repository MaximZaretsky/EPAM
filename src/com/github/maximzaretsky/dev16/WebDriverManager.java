package Microframework;

import Microframework.Loggers.ILogger;
import Microframework.Loggers.ResultOfOperation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contain actions for work with webdriver
 */
public class WebDriverManager {

  private static WebDriverManager instance;
  private WebDriver driver = new ChromeDriver();
  private ILogger logger;

  /**
   * Method for getting of instance of class
   * @return instance of WebDriverManager
   */
  public static WebDriverManager getInstance() {
    if (instance == null) {
      instance = new WebDriverManager();
    }
    return instance;
  }

  /**
   * Set logger of class by received logger
   * @param logger received logger
   */
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }

  /**
   * Check existence of webelement with necessary href on page
   * @param href String with href
   */
  public void checkLinkPresentByHref(String href) {
    String status;
    long startTime = System.currentTimeMillis();
    try {
      driver.findElement(By.xpath("//a[@href=\"" + href + "\"]"));
      status = "+";
    } catch (NoSuchElementException e) {
      status = "!";
    }
    long finishTime = System.currentTimeMillis();
    double timeOfExecution = ((double) (finishTime - startTime)) / 1000;
    logger.addResultOfOperation(new ResultOfOperation("[CheckLinkPresentByHref \"" + href + "\"", timeOfExecution, status));
  }

  /**
   * Check existence of webelement with necessary tag "name" on page
   * @param name String with name
   */
  public void checkLinkPresentByName(String name) {
    String status;
    long startTime = System.currentTimeMillis();
    try {
      driver.findElement(By.xpath("//*[@name=\"" + name + "\"]"));
      status = "+";
    } catch (NoSuchElementException e) {
      status = "!";
    }
    long finishTime = System.currentTimeMillis();
    double timeOfExecution = ((double) (finishTime - startTime)) / 1000;
    logger.addResultOfOperation(new ResultOfOperation("[CheckLinkPresentByName \"" + name + "\"", timeOfExecution, status));
  }

  /**
   * Compares title of page with received title
   * @param title String with title
   */
  public void checkPageTitle(String title) {
    String status;
    long startTime = System.currentTimeMillis();
    if (driver.getTitle().equals(title)) {
      status = "+";
    } else {
      status = "!";
    }
    long finishTime = System.currentTimeMillis();
    double timeOfExecution = ((double) (finishTime - startTime)) / 1000;
    logger.addResultOfOperation(new ResultOfOperation("[CheckPageTitle +\"" + title + "\"", timeOfExecution, status));
  }

  /**
   * Method is trying to find received content on page
   * @param content String with content
   */
  public void checkPageContains(String content) {
    String status;
    long startTime = System.currentTimeMillis();
    if (driver.getPageSource().contains(content)) {
      status = "+";
    } else {
      status = "!";
    }
    long finishTime = System.currentTimeMillis();
    double timeOfExecution = ((double) (finishTime - startTime)) / 1000;
    logger.addResultOfOperation(new ResultOfOperation("[CheckPageContains \"" + content + "\"", timeOfExecution, status));
  }

  /**
   * Method is trying to open received url during received timeout
   * @param url String with url
   * @param timeout number of seconds in timeout
   */
  public void openWithTimeout(String url, int timeout) {
    driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    String status;
    long startTime = System.currentTimeMillis();
    try {
      driver.get(url);
      try {
        driver.findElement(By.id("main-frame-error"));
        status = "!";
      } catch (NoSuchElementException ex) {
        status = "+";
      }
    } catch (Exception ex) {
      status = "!";
    }
    long finishTime = System.currentTimeMillis();
    double timeOfExecution = ((double) (finishTime - startTime)) / 1000;
    logger.addResultOfOperation(new ResultOfOperation("[open \"" + url +"\" \"" + timeout +"\" ]", timeOfExecution, status));
  }

  /**
   * This method is close webdriver
   */
  public void close() {
    driver.close();
  }

  /**
   * This method call save method of logger
   */
  public void saveLogs() {
    logger.saveLogsIntoFile();
  }
}
