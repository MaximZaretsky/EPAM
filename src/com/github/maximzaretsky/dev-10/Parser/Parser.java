package Parser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Find keywords and their values in received file
 */
public class Parser {
  private Map<String, String> valuesOfFieldsOfClass = new HashMap<>();

  /**
   * Find name of fields in file and their values
   * and add them in map which contain this fields and values
   *
   * @param inputFile file which necessary parse
   * @param lexemAnalizator analizator of lexems
   * @param syntaxisAnalizator analizator of syntaxis
   */
  public void parse(FileReader inputFile, LexemAnalizator lexemAnalizator, SyntaxisAnalizator syntaxisAnalizator){
    // TODO: Write realization of parsing (Maybe, chain of responsibilities will be ok for this case)
  }
}
