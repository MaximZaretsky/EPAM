import java.util.*;

/**
 * This class handle original text, got from user console,
 * clear him from extraneous symbols
 */
public class TextProcessor {
  private final String REGEX_FOR_LATIN_LETTERS = "[^a-zA-Z]";

  private List<String> clearText = new ArrayList<>();

  /**
   * This method split string, got from user, on words
   * and add words,cleared from extraneous symbols into
   * massive of clear words
   *
   * @param inputInformation is text, entered from user console
   */
  public void extractInputWords(String inputInformation) {
    String[] extractedWords = inputInformation.split(" ");

    for (String words : extractedWords) {
      clearText.add(clearWords(words));
    }
  }

  /**
   * This method clear got word from extraneous symbols with help
   * of regular expression REGEX_FOR_LATIN_LETTERS
   *
   * @param wordWithThrash is word, which contain extraneous symbols
   * @return word, cleared from extraneous symbols
   */
  private String clearWords(String wordWithThrash) {
    String clearWord = wordWithThrash.replaceAll(REGEX_FOR_LATIN_LETTERS, "");

    return clearWord;
  }

  /**
   * It is getter for clearText field
   *
   * @return massive of words, cleared from extraneous symbols
   */
  public List<String> getClearText() {
    return clearText;
  }
}
