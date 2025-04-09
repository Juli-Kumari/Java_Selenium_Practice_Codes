package Java_TestNg_Annotation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC_01_DataProvider {

      @DataProvider(name = "testData")
     public Object[][] dataProviderMethod(){
 return new Object[][] { {"user1", "pass1"}, {"user2", "pass2"}};
      }

      @Test (dataProvider = "testData")
    public void testMethod (String username, String password){
          System.out.println("username: " +username +", password: " +password);
      }


}
