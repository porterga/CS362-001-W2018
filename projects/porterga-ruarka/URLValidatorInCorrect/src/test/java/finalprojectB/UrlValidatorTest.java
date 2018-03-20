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
        assertFalse(validator1.isValid("http:\\\\google.com"));
        assertFalse(validator1.isValid("http://google"));          //Should fail, doesn't.
        assertFalse(validator1.isValid("google.com"));
        assertFalse(validator1.isValid(null));
        assertFalse(validator1.isValid("://google.com"));
        assertFalse(validator1.isValid("http:/google.com"));       //Should fail, doesn't
        assertFalse(validator1.isValid(""));
        assertTrue(validator1.isValid("https://google.com"));		//https is causing errors with regexValidator
        assertTrue(validator1.isValid("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt"));
        assertTrue(validator1.isValid("https://en.wikipedia.org/wiki/HTTPS"));
        assertTrue(validator1.isValid("https://oregonstate.teamdynamix.com/TDClient/KB/"));

    }

    @Test
    public void FirstPartition() {
        /*this partition includes URLs of the format: http://www.something.something/*..., the /* represent varying file paths.
        users can have filepaths of varying length, and most websites have redirection to different file paths, so this is a useful partition.
        This partition will include filepaths up to 4 levels deep.*/

        UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //True assertions for above mentioned partitions
        assertTrue(validator.isValid("http://oregonstate.edu/")); //level 0
        assertTrue(validator.isValid("http://oregonstate.edu/academics")); //level 1
        //The following three tests fail when they shouldn't. All of them should return true, but they return false
        assertTrue(validator.isValid("http://oregonstate.edu/academics/engineering")); //level 2
        assertTrue(validator.isValid("http://oregonstate.edu/academics/engineering/cs")); //level 3
        assertTrue(validator.isValid("http://oregonstate.edu/academics/engineering/cs/systems")); //level 4
        
        //False assertions for above mentioned partitions
        
        //The follow tests all fail. Each assertion should return false, but they return true
        assertFalse(validator.isValid("http://worldofwarcraft.com/../game/races/orc"));
        assertFalse(validator.isValid("http://worldofwarcraft.com/en-us/game/../"));
        assertFalse(validator.isValid("http://worldofwarcraft.com/en-us/game/races/orc//"));
        assertFalse(validator.isValid("http://worldofwarcraft.com/en-us//game/races/orc"));
        assertFalse(validator.isValid("http://worldofwarcraft.com//en-us/game/races/orc"));
        

    }

    @Test
    public void SecondPartition(){
        /*This partition is going to deal with the different possible schemes in a URL. Schemes cannot start with a number and must
        end with a ://. I will use http://www.google.com as a base url and will modify the scheme from there. */

        UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //True assertions, all schemes are valid
        //All of the below tests fail. Each assertion should return true, but they return false.
        assertTrue(validator.isValid("http://www.google.com"));   
        assertTrue(validator.isValid("https://www.google.com"));  //<-- failes because of the s at the end of https
        assertTrue(validator.isValid("h33ps://www.google.com"));  
        assertTrue(validator.isValid("ftp://www.google.com"));  

        //False assertions, all schemes are invalid
        assertFalse(validator.isValid("https:///www.google.com"));  test returns true, should return false  
        assertFalse(validator.isValid("https:/www.google.com")); 
        assertFalse(validator.isValid("https:://www.google.com"));  
        assertFalse(validator.isValid("https//www.google.com"));     
        assertFalse(validator.isValid("5https://www.google.com"));  
        assertFalse(validator.isValid("https/www.google.com"));
        assertFalse(validator.isValid("://www.google.com"));              
   

    }
    //You need to create more test cases for your Partitions if you need to

    @Test
    public void testIsValid() {
        //You can use this function for programming based testing
        UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        for(int i = 0; i < schemes.length; i++){
            for(int j = 0; j < address.length; j++){
                for(int k = 0; k < filePath.length; k++) {
                    String resultString = schemes[i].getValue() + address[j].getValue() +filePath[k].getValue();
                    boolean resultStatus = schemes[i].getStatus() && address[j].getStatus() && filePath[k].getStatus();
                    assertEqualsHandler(resultStatus, validator, resultString);
                }
            }
        }


    }

    public static void assertEqualsHandler(boolean expected, UrlValidator val, String string){
        try{
            assertEquals(expected, val.isValid(string));
            //System.out.println(expected + " - passed");
        }catch(AssertionError e){
            System.out.println(string + " - failed");
            throw e;
        }
    }

    //Individual blocks to test each part of the url
    Pair[] schemes = {
            new Pair("http://", true),
            new Pair("ftp://", true),
            new Pair("https://", true),
            new Pair("h3t://", true),

            new Pair("3ht://", false),
            new Pair("http:/", false),
            new Pair("http:", false),
            new Pair("http/", false)
    };

    Pair[] address = {
            new Pair("www.google.com", true),
            new Pair("google.com", true),
            new Pair("oregonstate.edu", true),
            new Pair("1.1.1.1", true),
            new Pair("255.255.255.255", true),
            new Pair("256.256.256.256", false),
            new Pair(".com", false),
            new Pair("1.1.1.1.1", false),
            new Pair("1.1.1.1.", false),
            new Pair("1.1.1", false),
            new Pair(".1.1.1.1", false),
            new Pair("google.j", false),
            new Pair("google.comsd", false),
            new Pair("a.b", false),
            new Pair("asd.", false),
            new Pair(".asd", false),
            new Pair("asd", false),
            new Pair("", false)
    };

    Pair[] filePath = {
            new Pair("/file", true),
            new Pair("/file1", true),
            new Pair("/1file", true),
            new Pair("/1#@$2", true),
            new Pair("/first/second", true),

            new Pair("/..", false),
            new Pair("/../", false),
            new Pair("", true),
            new Pair("/..//file", false),
            new Pair("/test1//file", false)
    };
}
