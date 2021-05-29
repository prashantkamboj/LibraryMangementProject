package Listeners;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import MainPacakge.ConnectionManager;
import MainPacakge.User;
public class AddUserListener implements ActionListener {
    JTextField nameField ,passField,idField;
	public AddUserListener( JTextField textFieldName,JTextField textFieldPassword,JTextField textFieldId) {            //Constructor For The AddUserListener
		this.nameField= textFieldName;
		this.passField= textFieldPassword;
		this.idField = textFieldId;  
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {  //Method Override For The Action AddUser  
	    
		String nameString = nameField.getText();
		String passString = passField.getText().trim();
		String idString = idField.getText().trim();
		int id = Integer.parseInt(idString);
		
		
		if(nameString.equals("")&&passString.equals("")&&idString.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),"All Fields Are Required");
		}
		else {
		       
		try {
		 User user = new User();
		 user.setId(id);
		 user.setName(nameString);
		 user.setPassword(passString);
			Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory sf = config.buildSessionFactory();
			Session s= sf.openSession();
			Transaction t = s.beginTransaction();
			s.save(user);
			t.commit();
			s.close();
		    JOptionPane.showMessageDialog(null, "Data Added Sucessfully","Message",JOptionPane.INFORMATION_MESSAGE);
		    
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,	e.getMessage());
		}
		}
	}

}
