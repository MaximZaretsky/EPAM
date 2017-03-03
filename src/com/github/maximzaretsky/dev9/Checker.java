import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import java.io.FileReader;
import javax.naming.InvalidNameException;

/**
 * Contain methods for checking input parameters
 */
public class Checker {

  /**
   * Check number of arguments, received from console
   *
   * @param arguments arguments received from console
   * @throws WrongNumberArgsException throw this exception if was received not one argument
   */
  public void checkEntryNameOfFile(String[] arguments) throws WrongNumberArgsException{
    if (arguments.length != 1) {
      throw new WrongNumberArgsException("Wrong name of file!");
    }
  }

  /**
   * Check existence of section in file
   *
   * @param iniFileReader reader for file
   * @param section necessary section
   * @throws InvalidNameException throw if this section doesn't exist
   */
  public void checkExistenceOfSection(FileReader iniFileReader, String section) throws InvalidNameException{
    // TODO: write check of existence
  }

  /**
   * Check existence of necessary key in necessary section
   *
   * @param iniFileReader reader for file
   * @param section necessary section
   * @param key necessary key
   * @throws InvalidNameException throw if this section doesn't contain this key
   */
  public void checkExistenceOfKeyInSection(FileReader iniFileReader, String section, String key) throws InvalidNameException{
    // TODO: write check of existence
  }
}
