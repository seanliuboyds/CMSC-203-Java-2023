

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {
  private double[][] dataSet1 = {{1.1, 2.2, 3.3, 4.4}, {5.5, 6.6, 7.7}, {8.8, 9.9}};
  private double[][] dataSet2 = {{-1, 2, -3, 4}, {-5}, {6, -7, 8}, {-9, 10, -11, 12}};
  private double[][] dataSet3 = {{-15.1, -33.3, -9.9, -71.6}, {-9.5, -21.3}, {-18.9, -11.7, -23.8},
      {-17.6, -26.9, -27.7, -32.1}};

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}




  @Test
  public void testCalculateHolidayBonusA() {
    try {
      double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 5000, 1000, 2000);
      assertEquals(8000.0, result[0], .001);
      assertEquals(9000.0, result[1], .001);
      assertEquals(10000.0, result[2], .001);

      result = HolidayBonus.calculateHolidayBonus(dataSet2, 5000, 1000, 2000);
      assertEquals(3000.0, result[0], .001);
      assertEquals(0.0, result[1], .001);
      assertEquals(10000.0, result[2], .001);
      assertEquals(10000.0, result[3], .001);

      result = HolidayBonus.calculateHolidayBonus(dataSet3, 5000, 1000, 2000);
      assertEquals(0.0, result[0], .001);
      assertEquals(0.0, result[1], .001);
      assertEquals(0.0, result[2], .001);
      assertEquals(0.0, result[3], .001);
    } catch (Exception e) {
      fail("This should not have caused an Exception");
    }
  }



  @Test
  public void testCalculateHolidayBonusB() {
    try {
      double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 1000, 250, 500);
      assertEquals(1750.0, result[0], .001);
      assertEquals(2000.0, result[1], .001);
      assertEquals(2000.0, result[2], .001);

      result = HolidayBonus.calculateHolidayBonus(dataSet2, 1000, 250, 500);
      assertEquals(750.0, result[0], .001);
      assertEquals(0.0, result[1], .001);
      assertEquals(2000.0, result[2], .001);
      assertEquals(2000.0, result[3], .001);

      result = HolidayBonus.calculateHolidayBonus(dataSet3, 1000, 250, 500);
      assertEquals(0.0, result[0], .001);
      assertEquals(0.0, result[1], .001);
      assertEquals(0.0, result[2], .001);
      assertEquals(0.0, result[3], .001);
    } catch (Exception e) {
      fail("This should not have caused an Exception");
    }

  }

  @Test
  public void testCalculateTotalHolidayBonusA() {
    assertEquals(27000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 5000, 1000, 2000),.001);
    assertEquals(23000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 5000, 1000, 2000),.001);
    assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 5000, 1000, 2000),.001);
  }


  @Test
  public void testCalculateTotalHolidayBonusB() {
    assertEquals(5750.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 1000, 250, 500), .001);
    assertEquals(4750.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 1000, 250, 500), .001);
    assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 1000, 250, 500), .001);
  }

}
