package calendar;


import org.junit.Test;
import java.util.Random;
import java.util.Calendar;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */

		 public static String RandomSelectMethod(Random random){
         String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

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
		         int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		     	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		         return RecurArray[n] ; // return appointments to recur forever or Never recur
		         }



						 @Test
						  public void radnomtest()  throws Throwable  {

							 Calendar rightnow = Calendar.getInstance();
						   int thisMonth = rightnow.get(Calendar.MONTH)+1;
							 int thisYear = rightnow.get(Calendar.YEAR);
							 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
							 long startTime = Calendar.getInstance().getTimeInMillis();
							 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
							 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
             //current month/year/date is today
							 CalDay cal = new CalDay(today);
							 CalDay cal2 = new CalDay();
							 CalDay cal3 = new CalDay(today);
							 CalDay cal4 = new CalDay();


							 System.out.println("Start testing...");

							try{
								for (int iteration = 0; elapsed < 20000; iteration++) {
									long randomseed =System.currentTimeMillis(); //10
						//			System.out.println(" Seed:"+randomseed );
									Random random = new Random(randomseed);

									 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 100);
									 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
									 int startYear=ValuesGenerator.RandInt(random);
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

									 Appt appt2 = new Appt(startHour-1,
				 													startMinute ,
				 													startDay ,
				 													startMonth ,
				 													startYear ,
				 													title,
				 													description);
									 Appt appt3 = new Appt(startHour+1,
							 									         startMinute ,
							 									         startDay ,
							 									         startMonth ,
							 									         startYear ,
							 									         title,
							 									         description);

								 //if(!appt.getValid())continue;
								for (int i = 0; i < 1000; i++) {
										String methodName = ApptRandomTest.RandomSelectMethod(random);

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
											   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
												 int recrand2 = ValuesGenerator.getRandomIntBetween(random, 0, 10);
												 if(recrand2 == 0){
													 cal3.getAppts().add(0, appt);
													 cal3.getAppts().add(1, appt2);
													 cal3.getAppts().add(2, appt3);
													 cal2.addAppt(appt);
													 cal2.addAppt(appt2);
													 cal2.addAppt(appt3);
													 assertEquals(3, cal2.getSizeAppts());
													 assertEquals(cal3.getAppts(), cal2.getAppts());
												 }
												 else{
													cal4.getAppts().add(0, appt);
													cal4.getAppts().add(1, appt2);
													cal4.getAppts().add(2, appt3);
												 	cal.addAppt(appt);
													cal.addAppt(appt2);
													cal.addAppt(appt3);
													assertEquals(3, cal.getSizeAppts());
													assertEquals(cal4.getAppts(), cal.getAppts());
												}
									}

									 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
								        if((iteration%10000)==0 && iteration!=0 )
								              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

								}
							}catch(NullPointerException e){

							}

							 System.out.println("Done testing...");
						 }


}
