import java.util.*;

/**
 * This class
 *
 */
public class TextProcessor {

  /**
   * @param REGEX_FOR_LATIN_LETTERS contain regular expression, which use for
   *        extracting only latin letters from original text
   * @param clearText contain massive of words, cleared from extraneous symbols
   */
  private final String REGEX_FOR_LATIN_LETTERS = "[^a-zA-Z]";

  private List<String> clearText = new ArrayList<>();

  public void handleInputText(String inputText) {
    extractInputWords(inputText);
  }

  private void extractInputWords(String inputInformation) {
    String[] extractedWords = inputInformation.split(" ");

    for (String words : extractedWords) {
      clearText.add(clearWords(words));
    }
  }

  private String clearWords(String wordWithThrash) {
    String clearWord = wordWithThrash.replaceAll(REGEX_FOR_LATIN_LETTERS, "");

    return clearWord;
  }

  public List<String> getClearText() {
    return clearText;
  }
}
