package MainPacakge;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import Listeners.AddUserListener;

// You Have to Delete Main Function From This Window;
public class AddUserPanel extends JFrame {
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	private JTextField textFieldId;
	public AddUserPanel() {
		getContentPane().setLayout(null);
		JLabel lblAddUserPanel = new JLabel("Add User Panel");
		lblAddUserPanel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddUserPanel.setBounds(184, 0, 202, 15);
		getContentPane().add(lblAddUserPanel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(37, 46, 97, 15);
		getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(37, 88, 108, 15);
		getContentPane().add(lblPassword);
		
		JLabel lblId = new JLabel("Id : ");
		lblId.setBounds(43, 137, 91, 15);
		getContentPane().add(lblId);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(145, 44, 114, 19);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(145, 86, 114, 19);
		getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(145, 135, 114, 19);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNoteId = new JLabel("Note : Id Must Be Unique");
		lblNoteId.setForeground(Color.RED);
		lblNoteId.setBounds(37, 227, 211, 15);
		getContentPane().add(lblNoteId);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(361, 41, 117, 25);
		btnSave.addActionListener(new AddUserListener(textFieldName, textFieldPassword, textFieldId));
		getContentPane().add(btnSave);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(361, 83, 117, 25);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			dispose();	
			}
		});
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
}
