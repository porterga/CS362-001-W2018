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

			TimeTable tb = new TimeTable();
 		 LinkedList<CalDay> caldays = new LinkedList<CalDay>();

		 GregorianCalendar today = new GregorianCalendar(2018,1,28);
		 GregorianCalendar today_bad = new GregorianCalendar(2018,1,15);
		 GregorianCalendar today_good = new GregorianCalendar(2018,9,12);
		 GregorianCalendar today_good2 = new GregorianCalendar(2018,11,12);
		 GregorianCalendar today_good3 = new GregorianCalendar(2019,11,12);
		 GregorianCalendar today4 = new GregorianCalendar(2018,1,30);
		 GregorianCalendar today5 = new GregorianCalendar(2018,1,29);
		 GregorianCalendar today6 = new GregorianCalendar(2018,6,10);

		 CalDay cal2 = new CalDay(today);
		 CalDay cal5 = new CalDay(today);
		 CalDay cal6 = new CalDay(today);

		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today_good2));

		 Appt appt = new Appt(12, 30, 11, 9, 2018, "test", "a test");
		 Appt appt2 = new Appt(13, 30, 11, 9, 2018, "test", "a test");
		 Appt appt3 = new Appt(11, 30, 11, 9, 2018, "test", "a test");
		 Appt appt5 = new Appt(-2, 30, 11, 9, 2018, "test", "a test");
		 Appt appt6 = new Appt(2, 30, 9, 9, 2018, "test", "a test");
		 Appt appt7 = new Appt(3, 30, 10, 9, 2018, "test", "a test");
		 Appt appt8 = new Appt(4, 30, 11, 9, 2018, "test", "a test");
		 Appt appt9 = new Appt(4, 30, 12, 9, 2018, "test", "a test");
		 Appt appt10 = new Appt(4, 30, 6, 9, 2018, "test", "a test");
		 Appt appt11 = new Appt(99, 70, -1, 9, 2018, "test", "a test");
		 Appt appt12 = new Appt(201, 30, 6, 9, 2018, "test", "a test");

		 int[] myArray = {0, 1, 2, 3, 4, 5, 6};
		 int[] myarray2 = {};
		 int[] myArray3 = {8};

		 appt9.setRecurrence(myarray2, 0, 0, 0);
		 appt10.setRecurrence(myArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt6.setRecurrence(myArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt7.setRecurrence(myArray, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);



		 appt.setRecurrence(myarray2, Appt.RECUR_BY_WEEKLY, 2, appt.RECUR_NUMBER_FOREVER);
		 appt2.setRecurrence(myArray3, Appt.RECUR_BY_YEARLY, 2, appt2.RECUR_NUMBER_FOREVER);
		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today_good2));
		 appt3.setRecurrence(myArray, 0, 0, appt.RECUR_NUMBER_FOREVER);
		 appt5.setRecurrence(myArray, Appt.RECUR_BY_WEEKLY, 2, appt5.RECUR_NUMBER_NEVER);

		 cal5.addAppt(appt2);
		 cal5.addAppt(appt3);
		 cal5.addAppt(appt5);
		 cal5.addAppt(appt11);
		 cal5.addAppt(appt12);

		 //cal2.getAppts().add(0, appt);
		 //cal2.getAppts().add(1, appt2);
		 //cal2.getAppts().add(2, appt3);
		 cal2.addAppt(appt);
		 cal2.addAppt(appt2);
		 cal2.addAppt(appt3);
		 cal2.addAppt(appt5);
		 cal5.addAppt(appt7);
		 cal5.addAppt(appt6);
		 cal5.addAppt(appt8);


		 caldays.add(cal2);


		 //assertNotEquals(caldays, tb.getApptRange(cal2.getAppts(), today, today_bad));
		 assertNotEquals(caldays, tb.getApptRange(cal2.getAppts(), today, today_good));
		 cal2.addAppt(appt6);
		 cal2.addAppt(appt7);
		 cal2.addAppt(appt8);
		 assertEquals(cal5.getAppts(), tb.deleteAppt(cal2.getAppts(), appt));
		 cal5.addAppt(appt);
		 LinkedList<CalDay> caldays3 = new LinkedList<CalDay>();
		 caldays3 = new LinkedList<CalDay>();
		 caldays3 = tb.getApptRange(cal2.getAppts(), today, today_good2);
		 assertNotEquals(caldays3, tb.getApptRange(cal2.getAppts(), today, today_good2));
		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today_good2));
		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today_good));
		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today4));
		 assertNotEquals(null, tb.getApptRange(cal6.getAppts(), today, today4));

		 LinkedList<CalDay> caldays2 = new LinkedList<CalDay>();
		 caldays2 = new LinkedList<CalDay>();
		 caldays2 = tb.getApptRange(cal5.getAppts(), today, today6);

		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today5));
		 assertNotEquals(caldays2, tb.getApptRange(cal5.getAppts(), today, today6));

		 cal5.addAppt(appt9);
		 cal5.addAppt(appt10);
		 assertNotEquals(null, tb.getApptRange(cal5.getAppts(), today, today_good3
		 ));

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
		 CalDay cal4 = new CalDay(today);
		 cal4.addAppt(appt);
		 cal4.addAppt(appt2);
		 cal4.addAppt(appt3);
		 cal3.addAppt(appt3);
		 //cal3.getAppts().add(0, appt3);
		 //cal2.getAppts().add(0, appt2);
		 //cal2.getAppts().add(1, appt3);
		 //cal2.getAppts().add(2, appt);
		 assertEquals(null, tb.deleteAppt(cal3.getAppts(), null));

		 assertEquals(null, tb.deleteAppt(cal2.getAppts(), appt2));

		 int[] arr = {0};
		 assertNotEquals(null, tb.permute(cal3.getAppts(), arr));
		 int[] arr2 = {0, 1, 2, 3, 4};
		 assertNotEquals(null, tb.permute(cal2.getAppts(), arr2));

	 }
	@Test
	public void test02() throws Throwable {
		TimeTable timetable = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		LinkedList<Appt> comp = new LinkedList<Appt>();

		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=05;
		int startYear=2018;
		String title="test";
		String description="a test";

		for(int i = 0; i<5; i++){
			Appt appt = new Appt(20, 30, i+1, 10, 2018, "test", "a test");
			appts.add(appt);
		}

		comp = timetable.permute(appts, new int[]{4,1,2,0,3});
		assertEquals(comp.get(0), appts.get(3));
		assertEquals(comp.get(4), appts.get(4));
	}

}
