package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogFrame extends JFrame {
	JLabel lblLabel;
  public DialogFrame() {
  	getContentPane().setLayout(null);
  	
  	lblLabel = new JLabel("label");
  	lblLabel.setBounds(0, 0, 352, 146);
  	getContentPane().add(lblLabel);
	// TODO Auto-generated constructor stub
} 
}
