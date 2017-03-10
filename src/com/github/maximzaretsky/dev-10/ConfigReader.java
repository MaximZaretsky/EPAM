import java.io.FileReader;

/**
 * Find path to input and output files
 */
public class ConfigReader {
  private String pathToInputFile;
  private String pathToOutputFile;

  /**
   * Start extraction paths from files
   * @param configFile file which contain paths
   */
  public ConfigReader(FileReader configFile){
    extractPathToInputFile();
    extractPathToOutputFile();
  }

  /**
   * Return path to input file
   *
   * @return path to input file
   */
  public String getPathToInputFile(){
    return pathToInputFile;
  }

  /**
   * Return path to output file
   *
   * @return path to output file
   */
  public String getPathToOutputFile(){
    return pathToOutputFile;
  }

  /**
   *
   */
  private void extractPathToInputFile(){
    // TODO: Write realization of extracting path of input file
  }

  private void extractPathToOutputFile(){
    // TODO: Write realization of extracting path of output file
  }
}
