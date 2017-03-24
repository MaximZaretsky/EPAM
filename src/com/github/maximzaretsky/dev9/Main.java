import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   *
   * @param args name of file
   */
  public static void main(String[] args) {
    final int FILE_INDEX = 0;
    Checker checker = new Checker();
    Scanner in = new Scanner(System.in);
    String filename;

    try {
      checker.checkEntryNameOfFile(args);
      filename = args[FILE_INDEX];
    } catch (WrongNumberArgsException e) {
      System.out.println("Enter valid name of file!");
      filename = in.nextLine();
    }

    FileReader iniFileReader;
    try {
      iniFileReader = new FileReader(filename);
    } catch (FileNotFoundException e){
      System.out.println("File not found! Enter correct name of file");
    }

    FinderValuesFromFile finderValuesFromFile = new FinderValuesFromFile();
    String section;
    String key;

    System.out.println("Enter necessary section");
    section = in.nextLine();
    System.out.println("Enter necessary key");
    key = in.nextLine();

    System.out.println(finderValuesFromFile.findValueForKeyInNecessarySection(iniFileReader, section, key));

  }
}
