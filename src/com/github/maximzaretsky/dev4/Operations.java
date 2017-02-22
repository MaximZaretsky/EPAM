import java.util.List;

/**
 * It is interface for operations on text, got from user
 */
public interface Operations {

  /**
   * This method start executing operation
   * @param text is milled text, got from user
   */
  public void doOperation(List<String> text);

  /**
   * This method print results of executing operation
   */
  public void printResult();
}
