import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {

	    public Panel() {
	        setLayout(new java.awt.GridLayout(4, 4));
	        for (int i = 0; i < 16; ++i) {
	            JButton b = new JButton(String.valueOf(i));
	            b.addActionListener(new java.awt.event.ActionListener() {
	                public void actionPerformed(java.awt.event.ActionEvent e) {
	                    //...
	                }
	            });
	            add(b);
	        }
	    }
  
  
   }