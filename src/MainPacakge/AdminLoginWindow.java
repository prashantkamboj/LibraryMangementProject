package MainPacakge;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class AdminLoginWindow extends JFrame{
	private JTextField idField;
	private JTextField passField;
	public AdminLoginWindow() {
		getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setBounds(160, 12, 128, 15);
		getContentPane().add(lblAdminLogin);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(50, 55, 70, 15);
		getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(50, 89, 97, 15);
		getContentPane().add(lblPassword);
		
		idField = new JTextField();
		idField.setBounds(174, 53, 114, 19);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(174, 87, 114, 19);
		getContentPane().add(passField);
		passField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = new ConnectionManager().getConnection();
				String pass= passField.getText().trim();
				String idString = idField.getText().trim();
				int id = Integer.parseInt(idString);
				try {
					
					 admin ad = new admin();
					 Configuration config = new Configuration().configure().addAnnotatedClass(admin.class);
					 ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
					 SessionFactory sf = config.buildSessionFactory(sr);
					 Session ss =sf.openSession();
					 Transaction tr = ss.beginTransaction();
					  ad=(admin) ss.get(admin.class,id);
					  tr.commit();
					  String checkpass = ad.getPassword();
					 if(pass.equals(checkpass)){
						 AdminPanel adp= new AdminPanel();
						 adp.setSize(650,300);
						 adp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 adp.setVisible(true);
					 }
					 else {
						JOptionPane.showMessageDialog(new JFrame(), "Check Your Password"); 
					 }
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(AdminLoginWindow.this, e.getMessage());
					e.printStackTrace();
				} 				
			}
		});
		btnLogin.setBounds(174, 133, 117, 25);
		getContentPane().add(btnLogin);
	}

      
}
