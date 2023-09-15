package distance;

/**
 * This class calculate and represent the velocity.
 * Should throw exception when elapsedTime equal or less than 0.
 * return the velocity.
 */
public class Physics {
  /**
   * a static class method to calculate the velovity.
   * @param one - a 3D point.
   * @param two - a 3D point.
   * @param elapsedTime - time.
   * @return velocity.
   */
  public static double velocity( Point3D one, Point3D two, double elapsedTime) {
    if ( elapsedTime <= 0) {
      throw new IllegalArgumentException("Elapsed time must be positive and non-zero.");
    }
    double distance = one.distanceTo(two);
    return distance / elapsedTime;
  }

  /**
   * function to help to do output screenshot.
   */
  public static void main(String[] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1,1,1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 0);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity);
      velocity = Physics.velocity(one, two, 5);
      System.out.println("Velocity =" + velocity);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}
