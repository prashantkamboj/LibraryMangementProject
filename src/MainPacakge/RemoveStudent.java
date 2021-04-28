package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RemoveStudent extends JFrame{
	private JTextField rollNoField;
	public RemoveStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Student Panel");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(78, 24, 301, 15);
		getContentPane().add(lblNewLabel);
		
		rollNoField = new JTextField();
		rollNoField.setBounds(137, 93, 183, 19);
		getContentPane().add(rollNoField);
		rollNoField.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			      String rollno = rollNoField.getText().trim();
			     try {
			    	  Connection con = new ConnectionManager().getConnection();
			    	  Statement s = con.createStatement();
			    	   s.executeUpdate("DELETE FROM students WHERE rollno = '"+rollno+"';");
			    	   JOptionPane.showMessageDialog(RemoveStudent.this, "Delete Account Successfully");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RemoveStudent.this,e.getMessage());
				}      
			}
		});
		btnDone.setBounds(170, 141, 117, 25);
		getContentPane().add(btnDone);
		JLabel lblNewLabel_1 = new JLabel("Enter RollNo To Delete Student");
		lblNewLabel_1.setBounds(112, 59, 232, 15);
		getContentPane().add(lblNewLabel_1);
	}
}
