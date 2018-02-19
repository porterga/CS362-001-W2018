package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 //construct recurrence
		 int[] myArray = {1, 2, 3};
		 appt.setRecurrence(myArray, 4, 365, 3);

	// assertions
		 assertArrayEquals(myArray, appt.getRecurDays());
		 assertEquals(4, appt.getRecurBy());
		 assertEquals(365, appt.getRecurIncrement());
		 assertEquals(3, appt.getRecurNumber());
		 assertTrue(appt.isRecurring());
		 assertTrue(appt.getValid());

		 appt.setStartHour(25);
		 //assertTrue(appt.getValid());
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());

		 appt.setStartHour(20);
		 appt.setStartMinute(61);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(50);
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(32);
		 assertFalse(appt.getValid());
		 appt.setStartDay(15);
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());

		 appt.setStartMonth(01);
		 appt.setStartDay(15);
		 appt.setStartMinute(30);
		 appt.setStartHour(21);
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

		 appt.setStartDay(0);
		 assertEquals(null, appt.toString());
		 appt.setStartDay(15);
		 appt.setStartHour(0);
		 assertNotEquals(null, appt.toString());
		 appt.setStartHour(12);
		 assertNotEquals(null, appt.toString());
		 appt.setStartHour(13);
		 assertNotEquals(null, appt.toString());


		 Appt appt2 = new Appt(12, 30, 13, 3, 2018, "Date", "cool beans");
	 	 assertNotEquals(0, appt.compareTo(appt2));

	 	 appt.setTitle(null);
	 	 assertEquals("", appt.getTitle());

	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
	
}
