package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RemoveUserPanel extends JFrame{
	private JTextField textField;
	public RemoveUserPanel() {
		getContentPane().setLayout(null);
		
		JLabel lblRemoveUser = new JLabel("Remove User");
		lblRemoveUser.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRemoveUser.setBounds(150, 12, 150, 15);
		getContentPane().add(lblRemoveUser);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setBounds(58, 47, 70, 15);
		lblId.setFont(new Font("Dialog", Font.BOLD, 18));
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(146, 46, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterIdFor = new JLabel("Enter Id For Delete The User");
		lblEnterIdFor.setForeground(Color.RED);
		lblEnterIdFor.setBounds(32, 236, 228, 15);
		getContentPane().add(lblEnterIdFor);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(107, 96, 190, 74);
		btnDelete.setIcon(new ImageIcon(RemoveUserPanel.class.getResource("/IconImages/deleteicon.png")));
		getContentPane().add(btnDelete);
	    btnDelete.addActionListener(new ActionListener() {  //Button Action Listener For Delete User In Remove User Panel
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ids = textField.getText().trim();
				if(ids.equals("")) {
					JOptionPane.showMessageDialog(new RemoveUserPanel(), "Enter The Id ");
				}
				else {
				try {
				
				 Connection con = new ConnectionManager().getConnection();
				 Statement s = con.createStatement();
				 int rs = s.executeUpdate("DELETE FROM user WHERE id = '"+ids+"';");
				 if(rs==1) {
					 JOptionPane.showMessageDialog(new JFrame(),"User Deletes SuccessFully");
				 }
				 else {
					 JOptionPane.showMessageDialog(new JFrame(),"User SuccessFully Deleted");
				 }
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
				}
		});
	}
}
