
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
       UrlValidator validator1 = new UrlValidator();
       //----> FAILURE assertTrue(validator1.isValid("http://oregonstate.edu/"));
       //----> FAILURE assertTrue(validator1.isValid("http://www.google.com"));
       assertFalse(validator1.isValid("www,google.com"));
       assertFalse(validator1.isValid("http:\\google.com"));
       assertFalse(validator1.isValid("http://google"));
       assertFalse(validator1.isValid("google.com"));
       assertFalse(validator1.isValid(null));
       assertFalse(validator1.isValid("://google.com"));
       assertFalse(validator1.isValid("http:/google.com"));
       assertFalse(validator1.isValid(""));
       //----> FAILURE assertTrue(validator1.isValid("https://google.com"));
       //----> FAILURE assertTrue(validator1.isValid("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt"));
       //----> FAILURE assertTrue(validator1.isValid("https://en.wikipedia.org/wiki/HTTPS"));
       //----> FAILURE assertTrue(validator1.isValid("http://localhost:3000/"));
       //----> FAILURE assertTrue(validator1.isValid("https://oregonstate.teamdynamix.com/TDClient/KB/"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
