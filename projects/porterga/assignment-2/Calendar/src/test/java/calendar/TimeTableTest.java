package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;
import sun.awt.image.ImageWatched;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {

		 GregorianCalendar today = new GregorianCalendar(2018,1,28);
		 GregorianCalendar today_bad = new GregorianCalendar(2018,1,15);
		 GregorianCalendar today_good = new GregorianCalendar(2018,9,12);

		 CalDay cal2 = new CalDay(today);

		 Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		 Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
		 Appt appt3 = new Appt(11, 30, 11, 9, 2018, "test", "a test");

		 cal2.getAppts().add(0, appt);
		 cal2.getAppts().add(1, appt2);
		 cal2.getAppts().add(2, appt3);

		 TimeTable tb = new TimeTable();
		 LinkedList<CalDay> caldays = new LinkedList<CalDay>();
		 caldays.add(cal2);
		 //assertNotEquals(caldays, tb.getApptRange(cal2.getAppts(),today, today_bad));

		 LinkedList<Appt> apptlist = new LinkedList<Appt>();
		 Appt appt1 = new Appt(12, 0, 15, 2, 2018, "test", "this is a test");

		 LinkedList<GregorianCalendar> greg = new LinkedList<GregorianCalendar>();
		 assertEquals(null, tb.deleteAppt(apptlist, appt1));
		 Appt appt4 = new Appt(-1, 0, 15, 2, 2018, "test", "this is a test");
		 assertEquals(null, tb.deleteAppt(apptlist, appt4));
		 apptlist = null;
		 assertEquals(null, tb.deleteAppt(apptlist, appt1));
	 	 //Appt apptn = null;

		 CalDay cal3 = new CalDay(today);
		 cal3.getAppts().add(0, appt3);
		 cal2.getAppts().add(0, appt2);
		 cal2.getAppts().add(1, appt3);
		 cal2.getAppts().add(2, appt);
		 assertEquals(null, tb.deleteAppt(cal3.getAppts(), null));

		 assertNotEquals(null, tb.deleteAppt(cal2.getAppts(), appt2));

		 int[] arr = {0};
		 assertNotEquals(null, tb.permute(cal3.getAppts(), arr));
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
