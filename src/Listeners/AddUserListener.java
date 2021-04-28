package Listeners;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.log.NullLogger;

import MainPacakge.ConnectionManager;
import MainPacakge.DialogFrame;
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
		ConnectionManager connection = new ConnectionManager();
		if(nameString.equals("")&&passString.equals("")&&idString.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),"All Fields Are Required");
		}
		else {
		String queryString = "INSERT INTO user VALUES( '"+nameString+"', '"+idString+"' , '"+passString+"');";
		try {
			Connection con= connection.getConnection();
			Statement statement = con.createStatement();
		   	int result = statement.executeUpdate(queryString);
		   System.out.println("Row Affected "+result);
		    JOptionPane.showMessageDialog(null, "Data Added Sucessfully","Message",JOptionPane.INFORMATION_MESSAGE);
		    
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,	e.getMessage());
		}
		}
	}

}
