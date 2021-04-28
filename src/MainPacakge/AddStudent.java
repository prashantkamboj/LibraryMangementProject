package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame{
	private JTextField nameField;
	private JTextField classField;
	private JTextField rollnoField;
	public AddStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setIcon(new ImageIcon(AddStudent.class.getResource("/IconImages/students.png")));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(385, 12, 200, 29);
		getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(477, 69, 230, 29);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(477, 110, 230, 29);
		getContentPane().add(classField);
		
		rollnoField = new JTextField();
		rollnoField.setColumns(10);
		rollnoField.setBounds(477, 151, 230, 29);
		getContentPane().add(rollnoField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(361, 76, 70, 15);
		getContentPane().add(lblName);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setFont(new Font("Dialog", Font.BOLD, 14));
		lblClass.setBounds(361, 117, 70, 15);
		getContentPane().add(lblClass);
		
		JLabel lblRollNo = new JLabel("Roll No.:");
		lblRollNo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRollNo.setBounds(361, 158, 70, 15);
		getContentPane().add(lblRollNo);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText().trim();
				String rollNo = rollnoField.getText().trim();
				String clas = classField.getText().trim();
				if(name.equals("")&&rollNo.equals("")&&clas.equals("")) {
					JOptionPane.showMessageDialog(AddStudent.this,"All Fields Are Required To Fill");
					
				}else {
					try {
						Connection con = new ConnectionManager().getConnection();
						Statement s = con.createStatement();
						boolean t = s.execute("INSERT INTO students(name,rollno,class) VALUES('"+name+"','"+rollNo+"','"+clas+"');");
						
							JOptionPane.showMessageDialog(AddStudent.this, "Data Added Success Fully");
							nameField.setText("");
							rollnoField.setText("");
							classField.setText("");
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(AddStudent.this,e.getMessage());
						
					}
				}
				
			
			}
		});
		btnDone.setIcon(new ImageIcon(AddStudent.class.getResource("/IconImages/doneicon.png")));
		btnDone.setBounds(441, 239, 117, 25);
		getContentPane().add(btnDone);
	}
}
