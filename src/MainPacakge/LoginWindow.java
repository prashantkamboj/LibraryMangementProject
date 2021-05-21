package MainPacakge;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;

public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.import javax.transaction.Transaction;
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of thimport javax.transaction.Transaction;e frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(168, 12, 70, 15);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(57, 57, 103, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(57, 99, 103, 15);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
	textField.setBounds(178, 55, 138, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(179, 97, 137, 19);
		frame.getContentPane().add(passwordField_1);
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(188, 139, 117, 25);
		frame.getContentPane().add(btnLogin);
		  btnLogin.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
			
				   String username = textField.getText().trim();
				   int userid = Integer.parseInt(username);
				   String password = passwordField_1.getText().trim(); 
				   if(username.equals("")&&password.equals("")) {
		             JOptionPane.showMessageDialog(new JFrame(), "All Fields Are Required To Fill");
				   }
				   else {
				 try {
					
					 
					 Configuration c = new Configuration().configure().addAnnotatedClass(User.class);
					  ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
				SessionFactory sf = c.buildSessionFactory(sr);
				Session s = sf.openSession();
				Transaction t = s.beginTransaction();
			
				 User ad = s.get(User.class,userid);
				 t.commit();
				 s.close();
					  if(ad!=null)
							 {
						       String pas =	ad.getPassword();
						        
						  if(password.equals(pas)){
						  UserPanel userPanel = new UserPanel();
						  userPanel.setSize(1080, 720);
						  userPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						  userPanel.setVisible(true);
					 
						  }else {
							  JOptionPane.showMessageDialog( new JFrame(), "Check Your Password ");
								  }
						  }
					  
					 else {
						JOptionPane.showMessageDialog(new JFrame(),"Check Your Username And Password");
					}
				 }catch (Exception e) {
				    JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
				}
				   }
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
				}
			}
		});
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(356, 226, 117, 25);
		frame.getContentPane().add(btnAdmin);
		
		
		btnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AdminLoginWindow adm = new AdminLoginWindow();
				adm.setSize(300,300);
				adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				adm.setVisible(true);
			}
		});
	}
}
