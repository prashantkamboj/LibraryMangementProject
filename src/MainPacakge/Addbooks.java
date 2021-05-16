package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sun.source.tree.LambdaExpressionTree.BodyKind;

import javax.swing.JButton;

public class Addbooks extends JFrame{
	private JTextField bookNameField;
	private JTextField subjectNameField;
	private JTextField authorNameField;
	private JTextField quantityField;
	private JTextField idField;
	private JTextField rackNoField;
	private JLabel lblNewLabel;
	private JLabel lblSubjectName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	public Addbooks() {
		getContentPane().setLayout(null);
		
		JLabel lblAddbookPanel = new JLabel("AddBook Panel");
		lblAddbookPanel.setIcon(new ImageIcon(Addbooks.class.getResource("/IconImages/books.png")));
		lblAddbookPanel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddbookPanel.setBounds(355, 12, 223, 33);
		getContentPane().add(lblAddbookPanel);
		
		bookNameField = new JTextField();
		bookNameField.setBounds(422, 77, 233, 25);
		getContentPane().add(bookNameField);
		bookNameField.setColumns(10);
		
		subjectNameField = new JTextField();
		subjectNameField.setColumns(10);
		subjectNameField.setBounds(422, 115, 233, 25);
		getContentPane().add(subjectNameField);
		
		authorNameField = new JTextField();
		authorNameField.setColumns(10);
		authorNameField.setBounds(422, 151, 233, 25);
		getContentPane().add(authorNameField);
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		quantityField.setBounds(422, 191, 233, 25);
		getContentPane().add(quantityField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(422, 233, 233, 25);
		getContentPane().add(idField);
		
		rackNoField = new JTextField();
		rackNoField.setColumns(10);
		rackNoField.setBounds(422, 277, 233, 25);
		getContentPane().add(rackNoField);
		
		lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(272, 82, 132, 15);
		getContentPane().add(lblNewLabel);
		
		lblSubjectName = new JLabel("Subject Name:");
		lblSubjectName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSubjectName.setBounds(272, 120, 132, 15);
		getContentPane().add(lblSubjectName);
		
		lblNewLabel_2 = new JLabel("Author Name: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(272, 156, 132, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quantity;");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(272, 196, 97, 15);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Id :");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(272, 238, 70, 15);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Rack No. :");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_5.setBounds(272, 282, 84, 15);
		getContentPane().add(lblNewLabel_5);
		
		JButton addBooksButton = new JButton("Add Books");
		addBooksButton.setIcon(new ImageIcon(Addbooks.class.getResource("/IconImages/doneicon.png")));
		addBooksButton.setBounds(395, 342, 144, 25);
		getContentPane().add(addBooksButton);
		addBooksButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 
				 String bookName = bookNameField.getText().trim();
				 String subjectName= subjectNameField.getText().trim();
				 String authorName = authorNameField.getText().trim();
				 int quantity = Integer.parseInt(quantityField.getText().trim());
				 String id = idField.getText().trim();
				 String rackNo = rackNoField.getText().trim();
				 if(bookName.equals("")&& subjectName.equals("")&& authorName.equals("")&& quantity==0&& id.equals("")&&
						 rackNo.equals("")) {
					 JOptionPane.showMessageDialog(Addbooks.this,"All Fields Are Required");
				 }else {
				   
					 try {
						 Books book = new Books();
						 book.setBookname(bookName);
						 book.setAuthor(authorName);
						 book.setId(id);
						 book.setQuantity(quantity);
						 book.setRackno(rackNo);
						 book.setSubject(subjectName);
						 Configuration config = new Configuration().configure().addAnnotatedClass(Books.class);
						  ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
						  SessionFactory sf = config.buildSessionFactory(sr);
						 Session session = sf.openSession();
						 Transaction tr = session.beginTransaction();
						 session.save(book);
						 tr.commit();
						 session.close(); 
						 JOptionPane.showMessageDialog(Addbooks.this, "Books Added SuccessFully");
						 
					} catch (Exception e) {
						JOptionPane.showMessageDialog(Addbooks.this, e.getMessage());
					}
				   
				}
			}
		});
	}
}
