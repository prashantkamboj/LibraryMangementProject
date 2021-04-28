package MainPacakge;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Listeners.RemoveUserListener;
public class AdminPanel extends JFrame{
	public AdminPanel() {
		getContentPane().setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAdminPanel.setBounds(234, 12, 130, 15);
		getContentPane().add(lblAdminPanel);
		
		JButton btnAddUser = new JButton("Add User ");
		btnAddUser.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddUserPanel addupanel = new AddUserPanel();
				addupanel.setSize(500,300);
				//addupanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				addupanel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				addupanel.setVisible(true);
			}
		});
		btnAddUser.setIcon(new ImageIcon(AdminPanel.class.getResource("/IconImages/user.png")));
		btnAddUser.setBounds(28, 39, 258, 117);
		getContentPane().add(btnAddUser);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setIcon(new ImageIcon(AdminPanel.class.getResource("/IconImages/deleteuser.png")));
		btnRemoveUser.setBounds(319, 39, 258, 117);
		getContentPane().add(btnRemoveUser);
		btnRemoveUser.addActionListener(new RemoveUserListener());
	}
}
