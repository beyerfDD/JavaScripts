import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * class ReadProperties
 *
 */
public class ReadProperties {
  
  public static void main(String[] args) {
    try {
      File ppFile = new File("test.properties");
      FileInputStream fis = new FileInputStream(ppFile);
      Properties prop = new Properties();
      prop.load(fis); fis.close();

      Enumeration enuKeys = prop.keys();
      while (enuKeys.hasMoreElements()) {
        String sKey = (String) enuKeys.nextElement();
        String sVal = prop.getProperty(sKey);
        System.out.println(sKey + " = " + sVal);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
