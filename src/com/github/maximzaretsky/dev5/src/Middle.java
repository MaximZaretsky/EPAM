
/**
 * Realization of Middle Programmer
 */
public class Middle implements Programmer {
  private Qualification MIDDLE = Qualification.MIDDLE;
  private int salary = 3000;
  private int productivity = 20;

  /**
   * @return salary of Middle
   */
  public int getSalary() {
    return salary;
  }

  /**
   * @return productivity of Middle
   */
  public int getProductivity() {
    return productivity;
  }

  /**
   * @return qualification of Middle
   */
  public Qualification getQualification() {
    return MIDDLE;
  }
}
