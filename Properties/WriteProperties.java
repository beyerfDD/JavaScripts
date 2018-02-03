import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * class WriteProperties
 *
 */
public class WriteProperties {

  public static void main(String[] args) {
    try {
      Properties prop = new Properties();
      prop.setProperty("Key_A", "val_A");
      prop.setProperty("Key_B", "val_B");
      prop.setProperty("Key_C", "val_C");

      File ppFile = new File("test.properties");
      FileOutputStream fos = new FileOutputStream(ppFile);
      prop.store(fos, "Property Comment");
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
