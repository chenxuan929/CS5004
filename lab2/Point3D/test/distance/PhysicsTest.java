package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for physics with 2 examples.
 */
public class PhysicsTest {
  private Point3D A;
  private Point3D B;

  /**
   * Set up two values - (1, 1, ,1), (9, 7, 9).
   */
  @Before
  public void setUp() {
    A = new Point3D(1, 1, 1);
    B = new Point3D(9,7,9);
  }

  /**
   * Test for velocity.
   */
  @Test
  public void testVelocity() {
    double elapsedTime = 2.5;
    double expectedVelocity = (A.distanceTo(B)) / elapsedTime;
    double actualVelocity = Physics.velocity(A, B, elapsedTime);
    assertEquals(expectedVelocity, actualVelocity, 0.01);
  }

  /**
   * Test fot invalid elapsedTime which is equal zero.
   * Should throw IllegalArgumentException and fail.
   */
  @Test
  public void testVelocityInvalidCase() {
    double elapsedTime = 0;
    Physics.velocity(A, B, elapsedTime);
  }
}