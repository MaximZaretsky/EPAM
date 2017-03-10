import Parser.*;
import java.io.FileReader;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    String pathToInputFile;
    String pathToOutputFile;

    try (FileReader fileReader = new FileReader("tmp/config.json")) {
      ConfigReader configReader = new ConfigReader(fileReader);
      pathToInputFile = configReader.getPathToInputFile();
      pathToOutputFile = configReader.getPathToOutputFile();
    }

    try(FileReader inputFileReader = new FileReader("\"" + pathToInputFile + "\"")) {
      LexemAnalizator lexemAnalizator = new LexemAnalizator();
      SyntaxisAnalizator syntaxisAnalizator = new SyntaxisAnalizator();

      Parser parser = new Parser();
      parser.parse(inputFileReader, lexemAnalizator, syntaxisAnalizator);
    }
  }
}
