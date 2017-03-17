import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Split input string with coordinates of field on
 * horizontal coordinate and vertical coordinate
 */
public class Splitter {
  private final Map<Character, Integer> letterPartOfField = new HashMap<>();
  private final int INDEX_OF_LETTER_PART = 0;
  private final int INDEX_OF_DIGIT_PART = 1;

  /**
   * Split input string with coordinates of field on
   * horizontal coordinate and vertical coordinate
   *
   * @param coordinates String with coordinates
   * @return list with horizontal and vertical coordinates
   */
  public List<Integer> split(String coordinates) {
    List<Integer> splittedCoordinates = new ArrayList<>();
    initializeMap();
    splittedCoordinates.add(INDEX_OF_LETTER_PART, defineIndex(coordinates.charAt(INDEX_OF_LETTER_PART)));
    splittedCoordinates.add(INDEX_OF_DIGIT_PART, Integer.parseInt(coordinates.substring(INDEX_OF_DIGIT_PART)));

    return splittedCoordinates;
  }

  /**
   * Put int values of letter part of coordinates into map
   */
  private void initializeMap() {
    letterPartOfField.put('A', 1);
    letterPartOfField.put('B', 2);
    letterPartOfField.put('C', 3);
    letterPartOfField.put('D', 4);
    letterPartOfField.put('E', 5);
    letterPartOfField.put('F', 6);
    letterPartOfField.put('G', 7);
    letterPartOfField.put('H', 8);
  }

  /**
   * Define int values of letter part of coordinates, using map with coordinates
   *
   * @param letterPartOfField vertical letter coordinate of field
   * @return vertical int coordinate of field
   */
  private int defineIndex(char letterPartOfField) {
    return this.letterPartOfField.get(letterPartOfField);
  }
}
