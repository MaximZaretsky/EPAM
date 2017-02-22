import java.math.BigDecimal;
import java.util.*;

public class FrequencyOfLettersPairs implements Operations {
  private List<String> pairsOfLetters = new ArrayList<>();
  private Set<String> uniquePairsOfLetters = new HashSet<>();
  private Map<String, Integer> amountOfPairInText = new HashMap<>();
  private List<String> words = new ArrayList<>();
  private final int LENGTH_OF_SUBSTRING = 2;

  /**
   * This method start executing of operation
   *
   * @param text is milled text, got from user
   */
  public void doOperation(List<String> text){
    this.words = text;
    splitOnPairs();
    howOftenIsMeets();
  }

  /**
   * This method print frequency of each pair of letters
   * in entered text
   */
  public void printResult() {
    Set<String> keys = amountOfPairInText.keySet();
    BigDecimal amountOfPairs = BigDecimal.valueOf(pairsOfLetters.size());
    for (String key: keys){
      BigDecimal valueOfKey = BigDecimal.valueOf(amountOfPairInText.get(key));
      BigDecimal frequency = valueOfKey.divide(amountOfPairs, 5, BigDecimal.ROUND_HALF_UP);
      System.out.println("Frequency of this pair: '" + key +"' in all pairs are: " + frequency);
    }
  }

  /**
   * This method split each word on pairs of letters,
   * which this word contain
   */
  private void splitOnPairs(){
    for(String word: words){
      for(int i = 0; i < word.length() - (LENGTH_OF_SUBSTRING - 1); i++){
        pairsOfLetters.add(word.substring(i, i+LENGTH_OF_SUBSTRING));
      }
    }
  }

  /**
   * This method calculate, how often each unique pair of letters
   * meets in text, which we received
   */
  private void howOftenIsMeets(){
    for (String pairs: pairsOfLetters){
      uniquePairsOfLetters.add(pairs);
    }

    for (String uniquePair: uniquePairsOfLetters){
      int amount= 0;
      for (String pairs: pairsOfLetters){
        if (uniquePair.contains(pairs)){
          amount++;
        }
      }
      amountOfPairInText.put(uniquePair, amount);
    }
  }
}
