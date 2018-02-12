package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {

	 	CalDay cal = new CalDay();

	 	GregorianCalendar greg = new GregorianCalendar();

	 	CalDay cal2 = new CalDay(greg);
		CalDay cal3 = new CalDay(greg);

	 	Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt3 = new Appt(-1, 30, 11, 9, 2018, "test", "a test");
		Appt appt4 = new Appt(12, 35, 11, 9, 2018, "test", "a test");

	 	//cal.addAppt(appt);
	 	cal2.addAppt(appt);
	 	cal2.addAppt(appt2);
		cal2.addAppt(appt3);
		cal3.addAppt(appt);
	 	cal3.addAppt(appt2);
		cal3.addAppt(appt3);
		cal3.addAppt(appt4);
		 //cal2.getAppts().add(0, appt);
		 //cal2.getAppts().add(1, appt2);
		 //cal2.getAppts().add(2, appt3);

		 cal.valid = true;
		 assertTrue(cal.isValid());
		 cal2.addAppt(appt4);
		 assertEquals(cal3, cal3);
		 assertEquals(greg.get(greg.DAY_OF_MONTH), cal2.getDay());
		 assertEquals(greg.get(greg.MONTH), cal2.getMonth());
		 assertEquals(greg.get(greg.YEAR), cal2.getYear());

		 assertEquals(3, cal2.getSizeAppts());
		 assertEquals(28, 28);
		 assertEquals(0, 0);
		 assertEquals(2018, cal2.getYear());
		 assertNotEquals(null, cal2.toString());
		 assertNotEquals(null, cal2.iterator());



	 }
	 @Test
	  public void test02()  throws Throwable  {

		 CalDay cal = new CalDay();

		 GregorianCalendar greg = new GregorianCalendar();

		 CalDay cal2 = new CalDay(greg);

		 Appt appt = new Appt(13, 30, 11, 9, 2018, "test", "a test");
		 Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
		 Appt appt3 = new Appt(-1, 30, 11, 9, 2018, "test", "a test");
		 Appt appt4 = new Appt(5, 30, 11, 9, 2018, "test", "a test");
		 Appt appt5 = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		 Appt appt6 = new Appt(14, 30, 11, 9, 2018, "test", "a test");
		 Appt appt7 = new Appt(15, 30, 11, 9, 2018, "test", "a test");
		 Appt appt8 = new Appt(16, 30, 11, 9, 2018, "test", "a test");
		 Appt appt9 = new Appt(17, 30, 11, 9, 2018, "test", "a test");

		 //cal.addAppt(appt);
		 cal2.addAppt(appt);
		 cal2.addAppt(appt2);
		 cal2.addAppt(appt3);
		 cal2.addAppt(appt4);
		 cal2.addAppt(appt5);
		 cal2.addAppt(appt6);
		 cal2.addAppt(appt7);
		 cal2.addAppt(appt8);
		 cal2.addAppt(appt9);
		 //cal2.getAppts().add(0, appt);
		 //cal2.getAppts().add(1, appt2);
		 //cal2.getAppts().add(2, appt3);

		 cal.valid = false;
		 assertFalse(cal.isValid());

		 assertEquals(greg.get(greg.DAY_OF_MONTH), cal2.getDay());
		 assertEquals(greg.get(greg.MONTH), cal2.getMonth());
		 assertEquals(greg.get(greg.YEAR), cal2.getYear());

		 assertEquals(8, cal2.getSizeAppts());
		 assertEquals(28, 28);
		 assertEquals(0, 0);
		 assertEquals(2018, cal2.getYear());
		 assertNotEquals(null, cal2.toString());
		 assertNotEquals(null, cal2.iterator());

		 assertEquals(null, cal.iterator());
		 assertNotEquals(null, cal.toString());


	 }
	 @Test
	  public void test04()  throws Throwable  {

			CalDay cal = new CalDay();

			assertNotEquals(null, cal.toString());
		}

		@Test
	public void test05() throws Throwable {

		GregorianCalendar today = new GregorianCalendar(2018, Calendar.getInstance().get(Calendar.MONTH)+1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		CalDay calday = new CalDay(today);
		Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt2 = new Appt(12, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt3 = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		Appt appt4 = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		Appt appt5 = new Appt(12, 30, 11, 9, 2018, "test", "a test");

		calday.addAppt(appt);
		calday.addAppt(appt2);
		calday.addAppt(appt3);
		calday.addAppt(appt4);
		calday.addAppt(appt5);

		assertEquals(appt, calday.getAppts().get(0));
		assertEquals(appt2, calday.getAppts().get(1));
		assertEquals(appt3, calday.getAppts().get(2));
		assertEquals(appt4, calday.getAppts().get(3));
		assertEquals(appt5, calday.getAppts().get(4));
	}

}
