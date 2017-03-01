/**
 * Realization of Junior Programmer
 */
public class Junior implements Programmer {
  private Qualification JUNIOR = Qualification.JUNIOR;
  private int salary = 2000;
  private int productivity = 10;

  /**
   * @return salary of Junior
   */
  public int getSalary() {
    return salary;
  }

  /**
   * @return productivity of Junior
   */
  public int getProductivity() {
    return productivity;
  }

  /**
   * @return qualification of Junior
   */
  public Qualification getQualification() {
    return JUNIOR;
  }
}
