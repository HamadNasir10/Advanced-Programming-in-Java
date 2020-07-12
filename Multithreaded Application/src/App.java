import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {
	
  public static void main(String[] args) {
    int items;
    int time;
	Properties prop = new Properties();
	InputStream input = null;

	try {

		input = new FileInputStream("Resources/config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		System.out.println(prop.getProperty("falshTime"));
		
		System.out.println(prop.getProperty("noOfItems"));
		
		
		
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//////
	 SwingUtilities.invokeLater(new Runnable(){
         @Override
         public void run(){
             JFrame frame = new JFrame();
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(new Dimension(200, 200));
             frame.add(new Panel());
             frame.setVisible(true);
         }
     });
 }
	
	////////////////////////
  }
  
 
 
