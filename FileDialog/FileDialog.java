import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;

/**
 * Test for class FileDialog
 *
 * @version 2018_02_01 1.0.0
 */

public class FileDialog {

  public static void main(String[] args) {
     FileDialog ofd = new FileDialog();
     ofd.dirOpen();
  }
  
  private void dirOpen() {
    final JFileChooser jfc = new JFileChooser("Verzeichnis wählen");
    
    jfc.setDialogType(JFileChooser.OPEN_DIALOG);
    jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    
    final File file = new File("C:/");

    jfc.setCurrentDirectory(file);
    jfc.addPropertyChangeListener (new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) || 
            e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
          final File f = (File) e.getNewValue();
        }
      }
    });

    jfc.setVisible(true);
    final int result = jfc.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
      File chsDir = jfc.getSelectedFile();
      String sDir = chsDir.getPath();
      System.out.println("Path: " + sDir);
    } else
      System.out.println("choose escaped");
    jfc.setVisible(false);
  }

}
