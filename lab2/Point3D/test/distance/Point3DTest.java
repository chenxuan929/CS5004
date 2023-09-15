package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the Point3D class with 3 example points: a, b, c.
 */
public class Point3DTest {
  private Point3D a;
  private Point3D b;
  private Point3D c;

  /**
   * Set number for 3 examples: (0, 0, 0), (9, 2, 9), (9, 2, 9).
   */
  @Before
  public void setUp() {
    a = new Point3D(0,0,0);
    b = new Point3D(9, 2, 9);
    c = new Point3D(9,2,9);
  }

  /**
   * Test for getX function.
   */
  @Test
  public void getX_test() {
    assertEquals(0, a.getX());
    assertEquals(9, b.getX());
    assertEquals(9, c.getX());
  }

  /**
   * Test for getY function.
   */
  @Test
  public void getY_test() {
    assertEquals(0, a.getY());
    assertEquals(2, b.getY());
    assertEquals(2, c.getY());
  }

  /**
   * Test for getZ function.
   */
  @Test
  public void getZ_test() {
    assertEquals(0, a.getZ());
    assertEquals(9, b.getZ());
    assertEquals(9, c.getZ());
  }

  /**
   * Test for distanceTo function.
   * excepted value should be:
   * a to b: 12.884, 12.884, 0.
   */
  @Test
  public void distanceTo_test() {
    assertEquals(12.884, a.distanceTo(b), 0.01 );
    assertEquals(12.884, a.distanceTo(c), 0.01 );
    assertEquals(0.00, c.distanceTo(b), 0.01 );
  }

  /**
   * Test for testEquals function.
   */
  @Test
  public void testEquals_test() {
    assertEquals(true, b.equals(c));
    assertEquals(false, a.equals(b));
  }
}