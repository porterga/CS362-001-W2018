
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   @Test
   public void testManualTest() {
//You can use this function to implement your manual testing	   
       UrlValidator validator1 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       assertTrue(validator1.isValid("http://www.google.com"));
       assertTrue(validator1.isValid("http://www.google.com"));
       assertFalse(validator1.isValid("www,google.com"));
       assertFalse(validator1.isValid("http:\\google.com"));
       //assertFalse(validator1.isValid("http://google"));          //Should fail, doesn't.
       assertFalse(validator1.isValid("google.com"));
       assertFalse(validator1.isValid(null));
       assertFalse(validator1.isValid("://google.com"));
       //assertFalse(validator1.isValid("http:/google.com"));       //Should fail, doesn't
       assertFalse(validator1.isValid(""));
       assertTrue(validator1.isValid("https://google.com"));
       assertTrue(validator1.isValid("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt"));
       assertTrue(validator1.isValid("https://en.wikipedia.org/wiki/HTTPS"));
       assertTrue(validator1.isValid("http://localhost:3000/"));
       assertTrue(validator1.isValid("https://oregonstate.teamdynamix.com/TDClient/KB/"));
   }
   
   @Test
   public void testYourFirstPartition() {
	 //You can use this function to implement your First Partition testing	   

   }

   @Test
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to

   @Test
   public void testIsValid() {
	   //You can use this function for programming based testing
   }


}
