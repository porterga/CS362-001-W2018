package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.Collections;
import java.util.LinkedList;
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

		 assertEquals(appt.RECUR_BY_MONTHLY, 2);

		 appt.setStartHour(25);
		 //assertTrue(appt.getValid());
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(1);
		 assertTrue(appt.getValid()); //
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());

		 appt.setStartHour(20);
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(1);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(58);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(50);
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(32);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(2);
		 assertTrue(appt.getValid());
		 appt.setStartDay(31);
		 assertTrue(appt.getValid());
		 appt.setStartDay(30);
		 assertTrue(appt.getValid());
		 appt.setStartDay(15);
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(2);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(10);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(11);
		 assertTrue(appt.getValid());

		 appt.setStartDay(-3);
		 appt.setStartYear(3000);
		 assertFalse(appt.getValid());
		 appt.setStartYear(2017);
		 assertFalse(appt.getValid());

		 appt.setStartYear(2018);
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
		 Appt appt3 = new Appt(12, 30, 13, 3, 2018, "Date", "cool beans");
		 Appt appt4 = new Appt(11, 29, 12, 2, 2017, "Date", "cool beans");
		 Appt appt5 = new Appt(13, 29, 12, 2, 2017, "Date", "cool beans");
		 Appt appt6 = new Appt(10, 29, 12, 2, 2017, "Date", "cool beans");
		 Appt appt7 = new Appt(14, 29, 12, 2, 2017, "Date", "cool beans");
	 	 assertNotEquals(0, appt.compareTo(appt2));
		 assertEquals(0, appt2.compareTo(appt3));
		 assertEquals(5, appt2.compareTo(appt4));
		 assertNotEquals(-3, appt2.compareTo(appt4));

		 assertEquals("\t3/13/2018 at 12:30pm ,Date, cool beans\n", appt2.toString());
		 assertEquals("\t2/12/2017 at -1:29am ,Date, cool beans\n", appt4.toString());

		 assertEquals("\t2/12/2017 at 13:29pm ,Date, cool beans\n", appt5.toString());
		 assertEquals("\t2/12/2017 at -2:29am ,Date, cool beans\n", appt6.toString());
		 assertEquals("\t2/12/2017 at 14:29pm ,Date, cool beans\n", appt7.toString());



	 	 appt.setTitle(null);
	 	 assertEquals("", appt.getTitle());

	 }

	 @Test
	  public void test02()  throws Throwable  {

					 LinkedList<Appt> listAppts = new LinkedList<Appt>();

					 Appt appt1 = new Appt(15, 30, 25, 5, 2018, "test", "a test");
					 Appt appt2 = new Appt(16, 31, 26, 6, 2019, "test", "a test");
					 Appt appt3 = new Appt(17, 32, 27, 7, 2020, "test", "a test");

					 listAppts.add(appt2);
					 listAppts.add(appt3);
					 listAppts.add(appt1);
					 listAppts.add(appt2);

					 Collections.sort(listAppts);

					 assertEquals(appt1, listAppts.get(0));
					 assertEquals(appt2, listAppts.get(1));
					 assertEquals(appt2, listAppts.get(2));
					 assertEquals(appt3, listAppts.get(3));

					 appt2.setStartMinute(32);
					 appt2.setStartHour(18);
					 appt2.setStartDay(29);
					 appt2.setStartMonth(10);
					 appt2.setStartYear(2024);
					 assertEquals(-20, appt1.compareTo(appt2));
					 assertEquals(20, appt2.compareTo(appt1));

	 }
	 @Test
	public void test03() throws Throwable {

		 Appt appt = new Appt(23, 59, 31, 12, 2018, "test", "a test");

		 assertTrue(appt.getValid());

		 appt.setStartHour(33);
		 assertFalse(appt.getValid());
		 appt.setStartHour(9);

		 appt.setStartDay(50);
		 assertFalse(appt.getValid());
	 }

}
