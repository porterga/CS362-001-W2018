package calendar;

import org.junit.Test;
import java.util.Random;
import java.util.Calendar;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */

		 public static String RandomSelectMethod(Random random){
         String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

     	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

         return methodArray[n] ; // return the method name
         }

			public static int RandomSelectRecur(Random random){
		         int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		     	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		         return RecurArray[n] ; // return the value of the  appointments to recur
		         }
		 	/**
		 	 * Return a randomly selected appointments to recur forever or Never recur  !.
		 	 */
		  public static int RandomSelectRecurForEverNever(Random random){
		         int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		     	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		         return RecurArray[n] ; // return appointments to recur forever or Never recur
		         }


						 @Test
							public void radnomtest()  throws Throwable  {

							 TimeTable tb = new TimeTable();
							 Calendar rightnow = Calendar.getInstance();
							 int thisMonth = rightnow.get(Calendar.MONTH)+1;
							 int thisYear = rightnow.get(Calendar.YEAR);
							 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
							 long startTime = Calendar.getInstance().getTimeInMillis();
							 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
							 LinkedList<CalDay> cals = new LinkedList<CalDay>();
							 LinkedList<Appt> cals2 = new LinkedList<Appt>();
							 //GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
						 //current month/year/date is today
							// CalDay cal = new CalDay(today);
							//CalDay cal2 = new CalDay();


							 System.out.println("Start testing...");

							//try{
								for (int m = 0; m < 1000; m++) {
									System.out.println(m);
									long randomseed =System.currentTimeMillis(); //10
						//			System.out.println(" Seed:"+randomseed );
									Random random = new Random(randomseed);
									int numApps = 0;
									int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startMinuteg=ValuesGenerator.getRandomIntBetween(random, 0, 59);
									int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startDayg=ValuesGenerator.getRandomIntBetween(random, 1, 31);
									int startDayg2=ValuesGenerator.getRandomIntBetween(random, 1, 31);
									int startDayg3=ValuesGenerator.getRandomIntBetween(random, 1, 31);
									int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startMonthg=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startMonthg3=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startYear=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									int startYearg=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									int startYearg2=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									String title="Birthday Party";
									String description="This is my birthday party.";
									GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDayg);
									GregorianCalendar today_bad = new GregorianCalendar(startYear,startMonthg, startDayg2);
									GregorianCalendar today_bad2 = new GregorianCalendar(2019,startMonthg, startDayg2);
									CalDay cal2 = new CalDay(today);
									CalDay cal5 = new CalDay(today_bad);
									//Construct a new Appointment object with the initial data
									for(int j = 0; j < 50; j++){
									Appt appt = new Appt(startHour,
													 startMinuteg ,
													 startDayg3 ,
													 startMonthg3 ,
													 startYearg2 ,
													 title,
													description);
													int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
 												 int recrand = ValuesGenerator.getRandomIntBetween(random, 0, 10);
 												 int[] recurDays;
 												 if(recrand == 0){
 													recurDays = null;
 												}
 												 else{
 													 recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
 												 }
 												 int recur=ApptRandomTest.RandomSelectRecur(random);
 												 int recurIncrement = ValuesGenerator.RandInt(random);
 												 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
												 int[] myArray = {1, 2, 3};
 												 appt.setRecurrence(myArray, recur, recurIncrement, 100);
 												 int recrand2 = ValuesGenerator.getRandomIntBetween(random, 0, 10);

										cal5.addAppt(appt);
										int recrand5 = ValuesGenerator.getRandomIntBetween(random, 0, 100);
										try{
										if(j == 49){
											appt.setStartMinute(-1);
											cal2.addAppt(appt);
											//cal2.getAppts().add(j, appt);
											break;
										}
										else if(recrand5 == 0){
											appt = null;
										}
										cal2.addAppt(appt);
									}catch(NullPointerException e){}
										//cal2.getAppts().add(j, appt);
									}

								 //if(!appt.getValid())continue;
								for (int i = 0; i < 5; i++) {
										String methodName = ApptRandomTest.RandomSelectMethod(random);


												 /*if(cal2.getAppts().size() == 0)
												 	System.out.println("yes");*/
													try{
												 cals = tb.getApptRange(cal2.getAppts(), today, today_bad);
												 assertNotEquals(cals, tb.getApptRange(cal2.getAppts(), today, today_bad));
												 }catch(DateOutOfRangeException d){}

													 try{
												 cals = tb.getApptRange(cal2.getAppts(), today_bad, today);
												 assertNotEquals(cals, tb.getApptRange(cal2.getAppts(), today_bad, today));
											 }catch(DateOutOfRangeException f){}

													 try{
												 cals = tb.getApptRange(cal5.getAppts(), today, today_bad2);
												 assertNotEquals(cals, tb.getApptRange(cal5.getAppts(), today, today_bad2));
											 }catch(DateOutOfRangeException g){}

												 try{
												 cals = tb.getApptRange(cal5.getAppts(), today_bad2, today);
												 assertNotEquals(cals, tb.getApptRange(cal5.getAppts(), today_bad2, today));
											 }catch(DateOutOfRangeException h){}

									}
/*
									 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
												if((iteration%10000)==0 && iteration!=0 )
															System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
*/
								}
							//}catch(DateOutOfRangeException e){

							//}

							 System.out.println("Done testing...");
						 }


						 @Test
							public void radnomtest2()  throws Throwable  {

							 TimeTable tb = new TimeTable();
							 Calendar rightnow = Calendar.getInstance();
							 int thisMonth = rightnow.get(Calendar.MONTH)+1;
							 int thisYear = rightnow.get(Calendar.YEAR);
							 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
							 long startTime = Calendar.getInstance().getTimeInMillis();
							 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
							 LinkedList<CalDay> cals = new LinkedList<CalDay>();
							 LinkedList<Appt> cals2 = new LinkedList<Appt>();
							 LinkedList<Appt> appts = new LinkedList<Appt>();
							 LinkedList<Appt> appts2 = new LinkedList<Appt>();
							 //GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
						 //current month/year/date is today
							// CalDay cal = new CalDay(today);
							//CalDay cal2 = new CalDay();


							 System.out.println("Start testing...");

							//try{
								for (int n = 0; n < 10000; n++) {
									System.out.println(n);
									long randomseed =System.currentTimeMillis(); //10
						//			System.out.println(" Seed:"+randomseed );
									Random random = new Random(randomseed);
									int numApps = 0;
									int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startHourg=ValuesGenerator.getRandomIntBetween(random, 1, 23);
									int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startMinuteg=ValuesGenerator.getRandomIntBetween(random, 1, 59);
									int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									int startDayg=ValuesGenerator.getRandomIntBetween(random, 1, 31);
									int startDayg2=ValuesGenerator.getRandomIntBetween(random, 1, 31);
									int startDayg3=ValuesGenerator.getRandomIntBetween(random, 1, 28);
									int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startMonthg=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startMonthg3=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									int startYear=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									int startYearg=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									int startYearg2=ValuesGenerator.getRandomIntBetween(random, 2000, 2018);
									String title="Birthday Party";
									String description="This is my birthday party.";
									GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDayg);
									GregorianCalendar today_bad = new GregorianCalendar(startYear,startMonthg, startDayg2);
									GregorianCalendar today_bad2 = new GregorianCalendar(2019,startMonthg, startDayg2);
									CalDay cal2 = new CalDay(today);
									CalDay cal3 = new CalDay(today);
									CalDay cal5 = new CalDay(today_bad);
									//Construct a new Appointment object with the initial data
									for(int j = 0; j < 50; j++){
									Appt appt = new Appt(startHourg,
													 startMinuteg ,
													 startDayg3 ,
													 startMonthg3 ,
													 startYearg2 ,
													 title,
													description);
													Appt appt2 = new Appt(startHourg,
																	 startMinuteg ,
																	 startDayg3 ,
																	 startMonthg3 ,
																	 startYearg2 ,
																	 title,
																	description);
													int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
												 int recrand = ValuesGenerator.getRandomIntBetween(random, 0, 10);
												 int[] recurDays;
												 if(recrand == 0){
													recurDays = null;
												}
												 else{
													 recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
												 }
												 int recur=ApptRandomTest.RandomSelectRecur(random);
												 int recurIncrement = ValuesGenerator.RandInt(random);
												 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
												 int[] myArray = {1, 2, 3};
												 appt.setRecurrence(myArray, recur, recurIncrement, 100);
												 int recrand2 = ValuesGenerator.getRandomIntBetween(random, 0, 10);

										//cal5.addAppt(appt);
										int recrand5 = ValuesGenerator.getRandomIntBetween(random, 0, 100);
										if(j%10 == 0){
											appt.setStartMinute(-1);
											//numApps++;
										}
										else if(recrand5 == 0){
											appt = null;
										}
										try {
										//cal2.addAppt(appt);
										//cal5.addAppt(appt);
										cal2.getAppts().add(0, appt);
										cal2.getAppts().add(1, appt);
										cal2.getAppts().add(2, appt);
										cal5.getAppts().add(0, appt);
										cal5.getAppts().add(1, appt);
										cal5.getAppts().add(2, appt);
										//numApps++;
										appts = tb.deleteAppt(cal5.getAppts(), appt2);
										appts = tb.deleteAppt(null, appt);
										assertEquals(null, appts);
										appts = tb.deleteAppt(cal5.getAppts(), null);
										assertEquals(null, appts);
										appts = tb.deleteAppt(cal3.getAppts(), appt);
										appts = tb.deleteAppt(cal5.getAppts(), appt);
										appts2 = tb.deleteAppt(cal2.getAppts(), appt);
									}catch(NullPointerException e) {

									}
									}

								 //if(!appt.getValid())continue;
								for (int i = 0; i < 10; i++) {
										String methodName = ApptRandomTest.RandomSelectMethod(random);



									}

/*
									 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
												if((iteration%10000)==0 && iteration!=0 )
															System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
*/
								}
							//}catch(NullPointerException e){

							//}

							 System.out.println("Done testing...");
						 }


}
