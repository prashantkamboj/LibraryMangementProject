package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteBooks extends JFrame{
	private JTextField idField;
	private JTextField quantityField;
	public DeleteBooks() {
		getContentPane().setLayout(null);
		
		JLabel lblDeleteBookPanel = new JLabel("Delete Book Panel");
		lblDeleteBookPanel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDeleteBookPanel.setBounds(167, 22, 224, 15);
		getContentPane().add(lblDeleteBookPanel);
		
		idField = new JTextField();
		idField.setBounds(236, 49, 199, 25);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(148, 59, 70, 15);
		getContentPane().add(lblId);
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		quantityField.setText("0");
		quantityField.setBounds(236, 99, 199, 25);
		getContentPane().add(quantityField);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 15));
		lblQuantity.setBounds(121, 104, 97, 15);
		getContentPane().add(lblQuantity);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookid = idField.getText().trim();
				int quantity = Integer.parseInt(quantityField.getText());
				if(bookid.equals("")||quantity==0) {
				   JOptionPane.showMessageDialog(DeleteBooks.this, "Enter Required Field And A Proper Quantity");
				}else {
				try {
                     Connection con = new ConnectionManager().getConnection();
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery("SELECT quantity from books WHERE id = '"+bookid+"';");
                     rs.next();
                     int qcheck = rs.getInt("quantity");
                     if(qcheck<quantity) {
                    	 JOptionPane.showMessageDialog(DeleteBooks.this, "Enter Less Quantity There Is Not That Many Books Are Present");
                    	       }
                     else {
                         qcheck = qcheck-quantity;
                         s.executeUpdate("UPDATE books SET quantity = "+qcheck+" WHERE id ='"+bookid+"';");
                         JOptionPane.showMessageDialog(DeleteBooks.this,"Books Deleted Succesfully");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(DeleteBooks.this, e.getMessage());
				}
				}
			}
		});
		btnDelete.setBounds(214, 159, 117, 25);
		getContentPane().add(btnDelete);
		  
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result =JOptionPane.showConfirmDialog(DeleteBooks.this, "Do You Want To Delete This Books Entire Quantity","", JOptionPane.YES_NO_OPTION);
			   if(result== JOptionPane.YES_OPTION) {
				String bookid = idField.getText().trim();
				try {
                    Connection con = new ConnectionManager().getConnection();
                    Statement s = con.createStatement();
                    s.executeUpdate("DELETE FROM books WHERE id ='"+bookid+"';");
                    }catch (Exception e) {
						// TODO: handle exception
                    	JOptionPane.showMessageDialog(DeleteBooks.this,e.getMessage());	
					}
			}
			else{
				
			}
			}
		});
		btnDeleteAll.setForeground(Color.RED);
		btnDeleteAll.setBounds(417, 283, 117, 25);
		getContentPane().add(btnDeleteAll);
	}
}
