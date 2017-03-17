import java.util.ArrayList;
import java.util.List;

/**
 * Contain information about color, start position and necessary position of chequer
 */
public class Chequer {
  private ColorOfChequer color;
  private List<Integer> startPosition = new ArrayList<>(2);
  private List<Integer> necessaryPosition = new ArrayList<>(2);

  /**
   * Return color of chequer
   *
   * @return color of chequer
   */
  public ColorOfChequer getColor() {
    return color;
  }

  /**
   * Set color of chequer
   *
   * @param color color of chequer
   */
  public void setColor(ColorOfChequer color) {
    this.color = color;
  }

  /**
   * Return start position of chequer
   *
   * @return start position of chequer
   */
  public List<Integer> getStartPosition() {
    return startPosition;
  }

  /**
   * Set start position of chequer
   *
   * @param fieldCoordinates start position
   */
  public void setStartPosition(List<Integer> fieldCoordinates) {
   this.startPosition = fieldCoordinates;
  }

  /**
   * Return necessary position of chequer
   *
   * @return necessary position of chequer
   */
  public List<Integer> getNecessaryPosition() {
    return necessaryPosition;
  }

  /**
   * Set necessary position of chequer
   *
   * @param fieldCoordinates necessary position
   */
  public void setNecessaryPosition(List<Integer> fieldCoordinates) {
    this.necessaryPosition = fieldCoordinates;
  }
}
