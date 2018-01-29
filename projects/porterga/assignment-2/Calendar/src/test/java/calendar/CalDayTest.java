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

	 	Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
	 	Appt appt3 = new Appt(-1, 30, 11, 9, 2018, "test", "a test");

	 	//cal.addAppt(appt);
	 	//cal2.addAppt(appt);
	 	//cal2.addAppt(appt2);
		//cal2.addAppt(appt3);
		 cal2.getAppts().add(0, appt);
		 cal2.getAppts().add(1, appt2);
		 cal2.getAppts().add(2, appt3);

		 cal.valid = true;
		 assertTrue(cal.isValid());

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

		 Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		 Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
		 Appt appt3 = new Appt(-1, 30, 11, 9, 2018, "test", "a test");

		 //cal.addAppt(appt);
		 //cal2.addAppt(appt);
		 //cal2.addAppt(appt2);
		 //cal2.addAppt(appt3);
		 cal2.getAppts().add(0, appt);
		 cal2.getAppts().add(1, appt2);
		 cal2.getAppts().add(2, appt3);

		 cal.valid = false;
		 assertFalse(cal.isValid());

		 assertEquals(3, cal2.getSizeAppts());
		 assertEquals(28, 28);
		 assertEquals(0, 0);
		 assertEquals(2018, cal2.getYear());
		 assertNotEquals(null, cal2.toString());
		 assertNotEquals(null, cal2.iterator());

		 assertEquals(null, cal.iterator());
		 assertNotEquals(null, cal.toString());

		 
	 }
//add more unit tests as you needed	
}
