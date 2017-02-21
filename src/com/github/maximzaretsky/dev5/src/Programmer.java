/**
 * Interface for programmers of different qualifications
 */
public interface Programmer {

  /**
   * @return salary of programmer
   */
  int getSalary();

  /**
   * @return productivity of programmer
   */
  int getProductivity();

  /**
   * @return qualification of programmer
   */
  Qualification getQualification();
}
