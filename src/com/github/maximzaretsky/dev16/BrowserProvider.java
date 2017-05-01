package Microframework;

import Microframework.Loggers.ILogger;
import Microframework.Loggers.ResultOfOperation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Aramorchi on 01.05.2017.
 */
public class BrowserProvider {

  private static BrowserProvider instance;
  private WebDriver driver = new ChromeDriver();
  private ILogger logger;

  public static BrowserProvider getInstance() {
    if (instance == null) {
      instance = new BrowserProvider();
    }
    return instance;
  }

  public void setLogger(ILogger logger) {
    this.logger = logger;
  }

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

  public void close() {
    driver.close();
  }

  public void saveLogs() {
    logger.saveLogsIntoFile();
  }
}
