package MainPacakge;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.cj.jdbc.interceptors.ResultSetScannerInterceptor;


import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UserPanel extends JFrame {
	private JTextField searchField;
	private JTextField sNameField;
	private JTextField idField;
	private JTextField bookNameField;
	private JTextField uidField;
	private JTextField rollNofield;
	private JTextField returnUBookIdField;
	private JTable table;
	public UserPanel() {
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(589, 168, 421, 368);
		getContentPane().add(scrollPane);
		
		
		
		JLabel lblUserPanel = new JLabel("User Panel");
		lblUserPanel.setForeground(Color.BLACK);
		lblUserPanel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUserPanel.setBounds(477, 12, 148, 24);
		getContentPane().add(lblUserPanel);
		
		JLabel lblSerchBookHere = new JLabel("Search Book Here ");
		lblSerchBookHere.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSerchBookHere.setBounds(770, 54, 156, 15);
		getContentPane().add(lblSerchBookHere);
		
		searchField = new JTextField();
		searchField.setBounds(892, 81, 129, 19);
		getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JLabel lblBookName = new JLabel("Subject Name ->:");
		lblBookName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBookName.setBounds(735, 81, 154, 15);
		getContentPane().add(lblBookName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  String subject = searchField.getText().trim();
				  String [][] data;
				  String []column = {"Name","Author","Subject","Quantity","Id","RackNo."};
				  try {
					   Configuration config = new Configuration().configure().addAnnotatedClass(Books.class);
					   ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
					   SessionFactory sf = config.buildSessionFactory(sr);
					   Session  s = sf.openSession();
					   Query q =s.createQuery("FROM Books WHERE subject ='"+subject+"'");
					   
					   List<Books> bookList = q.list();			
                    int rowCount =  bookList.size();
      
                   
                   //ResultSetMetaData rsmd = rs.getMetaData();
                   int columnCount = 6;//smd.getColumnCount();
                    data = new String[rowCount][columnCount];
				 for(int i=0;i<rowCount;i++) {
					 Books book =bookList.get(i);
							data[i][1]= ""+book.getAuthor();
						    data[i][0]=""+book.getBookname();
						    data[i][2]= ""+book.getSubject();
						    data[i][3]= ""+book.getQuantity();
						    data[i][4]= ""+book.getId();
						    data[i][5]= ""+book.getRackno();
					 
				 }
				 table = new JTable(data,column); 
				 scrollPane.setViewportView(table);
				 scrollPane.setHorizontalScrollBar(new JScrollBar());
				  }catch (Exception
						  e) {
					// TODO: handle exception
					  JOptionPane.showMessageDialog(UserPanel.this, e.getMessage());
				}
				 
			}
		});
		btnSearch.setIcon(new ImageIcon(UserPanel.class.getResource("/IconImages/searchicon.png")));
		btnSearch.setBounds(820, 112, 117, 25);
		getContentPane().add(btnSearch);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(new Font("Dialog", Font.BOLD, 15));
		lblIssueBook.setBounds(174, 54, 129, 15);
		getContentPane().add(lblIssueBook);
		
		sNameField = new JTextField();
		sNameField.setBounds(211, 77, 177, 19);
		getContentPane().add(sNameField);
		sNameField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblName.setBounds(68, 83, 70, 15);
		getContentPane().add(lblName);
		
		idField = new JTextField();
		idField.setBounds(211, 104, 177, 19);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(68, 110, 70, 15);
		getContentPane().add(lblId);
		
		bookNameField = new JTextField();
		bookNameField.setBounds(211, 135, 177, 19);
		getContentPane().add(bookNameField);
		bookNameField.setColumns(10);
		
		JLabel lblBookName_1 = new JLabel("Book Name:");
		lblBookName_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBookName_1.setBounds(68, 137, 114, 15);
		getContentPane().add(lblBookName_1);
		
		uidField = new JTextField();
		uidField.setBounds(211, 166, 177, 19);
		getContentPane().add(uidField);
		uidField.setColumns(10);
		
		JLabel lblUbookid = new JLabel("UBookId:");
		lblUbookid.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUbookid.setBounds(68, 168, 104, 15);
		getContentPane().add(lblUbookid);
		
		rollNofield = new JTextField();
		rollNofield.setBounds(211, 197, 180, 19);
		getContentPane().add(rollNofield);
		rollNofield.setColumns(10);
		
		JLabel lblRollNumber = new JLabel("Roll Number:");
		lblRollNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRollNumber.setBounds(68, 199, 125, 15);
		getContentPane().add(lblRollNumber);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hello First ");
				String sName = sNameField.getText().trim();
				String rollNo = rollNofield.getText().trim();
				String id  = idField.getText().trim();
				String bookName = bookNameField.getName();
			    String uid = uidField.getText().trim();
			    System.out.println("Hello Ji");
			    Date date = new Date();
			    String dates = date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
			    System.out.println("Yha To Ni Hai Error");
			   /* if(sName.equals("")||rollNo.equals("")||id.equals("")||bookName.equals("")||uid.equals("")) {
			    	System.out.println("yha bhi ni aa  rha hai");
			    	JOptionPane.showMessageDialog(UserPanel.this,"All Fields Are Required To FiLL");
			    }
			    else {*/
			    	System.out.println("Yhan Pe?");
			    	try {
			    		System.out.println("Hello");
			    		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Books.class);
			    		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			    		SessionFactory sf = config.buildSessionFactory(sr); 
			    	Session s0 = sf.openSession();
                    Transaction tr = s0.beginTransaction();
			    	 Student student = (Student) s0.get(Student.class, rollNo);
			    	  Books book = (Books)s0.get(Books.class,id);
			    	  
			         Session s1 = sf.openSession();
			         Query q = s1.createQuery("FROM Student WHERE ubookid = '"+uid+"'");
			         Query  q1 = s1.createQuery("FROM Student WHERE ubookid1 = '"+uid+"'");
			         Student ceckStudent = (Student) q.uniqueResult();
			         Student checkStudent =(Student) q1.uniqueResult();
			         if(ceckStudent!=null||checkStudent!=null) {
			        	 String name;
			        	 String RollNo;
			        	 if(ceckStudent!=null) {
			        		 name = ceckStudent.getName();
			        		 rollNo=ceckStudent.getRollno();
			        	 }else {
			        		name= checkStudent.getName();
			        		rollNo = checkStudent.getRollno();
			        	 }
			        	 JOptionPane.showMessageDialog(UserPanel.this, "May Be Haven't Return This Book Properly This Book Is "
			        	 		+ "Already Issue To \n"+rollNo);
			         }else {
			        	 if(student.getUbookid()==null||student.getUbookid1()==null) {
			        		 if(student.getUbookid()==null) {
			        			 student.setBookId(book.getId());
			        			 student.setBookname(book.getBookname());
			        			 student.setUbookid(uid);
			        		 
			        		 }else{
			        			 
			        			 student.setBookId1(book.getId());
			        			 student.setBookname1(book.getBookname());
			        			 student.setUbookid1(uid);
			        		 }
			        		 int quantity = book.getQuantity();
			        		 if(book.getQuantity()!=0) {
			        	 	quantity=quantity-1;
			        	 	book.setQuantity(quantity);
			        	 	s0.update(book);
			        		 s0.update(student);
			        		 tr.commit();
			        		 s0.close();
			        		  }else {
			        			  JOptionPane.showMessageDialog(UserPanel.this,"Problem With Quantity May Be You Havenot Returnd Book "
			        			  		+ "Properly");
			        		  }
			        	 }else {
			        		 JOptionPane.showMessageDialog(UserPanel.this,"NOt Enough Space");
			        	 }
			         }
						/*
						 * System.out.println("First"); //Connection con = new
						 * ConnectionManager().getConnection(); //System.out.println("second");
						 * //Statement s = con.createStatement(); //System.out.println("third");
						 * //ResultSet rs = s.
						 * executeQuery("SELECT ubookid1,ubookid2, book_name_1,book_name_2,book_id1,book_id2 FROM students WHERE"
						 * // + " rollno='"+rollNo+"';"); //rs.next(); Statement s3 =
						 * con.createStatement(); Statement s4 = con.createStatement(); ResultSet rs3 =
						 * s3.executeQuery("SELECT * FROM students WHERE ubookid1 = '"+uid+"';");
						 * ResultSet rs4 =
						 * s4.executeQuery("SELECT * FROM students WHERE ubookid2 = '"+uid+"';"); String
						 * uBookId1 = rs.getString("ubookid1"); String uBookId2 =
						 * rs.getString("ubookid2"); String bookName1 = rs.getString("book_name_1");
						 * String bookName2 = rs.getString("book_name_2"); String bookId1 =
						 * rs.getString("book_id1"); String bookId2 = rs.getString("book_id2");
						 * System.out.println(uBookId1); boolean rs3check = rs3.next();
						 * if(rs3check||rs4.next()){ String rollnoString; if(rs3check) {
						 * rollnoString=rs3.getString("rollno"); }else {
						 * rollnoString=rs4.getString("rollno"); }
						 * JOptionPane.showMessageDialog(UserPanel.this,
						 * "This Book Is Already Issue To A Person With RollNo. " +
						 * rollnoString+" You Should \n Try To Rturn This Book Or Should Check Your Data Which You Are "
						 * + "Entring Again"); } else { if(bookId1==null||bookId2==null) {
						 * System.out.println("First Destination");
						 * if(id.equals(bookId1)||id.equals(bookId2)) {
						 * System.out.println("first Destination");
						 * JOptionPane.showMessageDialog(UserPanel.
						 * this,"This Book Id Already Issued To This Person"); }else {
						 * if(bookId1==null){ try { Statement s1 = con.createStatement(); Statement s2 =
						 * con.createStatement(); ResultSet rs1 =
						 * s1.executeQuery("SELECT * FROM books WHERE id = '"+id+"';"); rs1.next(); int
						 * qCheck= rs1.getInt("quantity"); if(qCheck!=0||qCheck>0) {
						 * System.out.println("We Reach second Destination"); String fullBookName =
						 * rs1.getString("book_name")+" Written By "+rs1.getString("author");
						 * s2.executeUpdate("UPDATE students SET book_name_1='"+fullBookName+
						 * "',ubookid1='"+uid+"',date_of_issue" +
						 * "_book1='"+dates+"',book_id1='"+id+"' WHERE rollno='"+rollNo+"';"); int
						 * quantity = rs1.getInt("quantity"); int finalQuantity = quantity-1;
						 * s1.executeUpdate("UPDATE books SET quantity="+finalQuantity+" WHERE id = '"
						 * +id+"';");
						 * 
						 * }else { JOptionPane.showMessageDialog(UserPanel.this,
						 * "Problem With Quantity Of \n " +
						 * "May Be You Have Not Returned Book Properly"); } } catch (Exception e) { //
						 * TODO: handle exception JOptionPane.showMessageDialog(UserPanel.this,
						 * e.getMessage()); } } else{ Statement s1 = con.createStatement(); ResultSet
						 * rs1 = s1.executeQuery("SELECT * FROM books WHERE id = '"+id+"';");
						 * rs1.next(); int qCheck= rs1.getInt("quantity"); if(qCheck!=0||qCheck>0) {
						 * String fullBookName =
						 * rs1.getString("book_name")+" Written By "+rs1.getString("author");
						 * s1.execute("UPDATE students SET book_name_2='"+fullBookName+"',ubookid2='"+
						 * uid+"',date_of_issue" +
						 * "_book2='"+dates+"',book_id2='"+id+" WHERE rollno='"+rollNo+"';"); int
						 * quantity = rs1.getInt("quantity"); int finalQuantity = quantity-1;
						 * s1.executeUpdate("UPDATE books SET quantity="+finalQuantity+" WHERE id = "+id
						 * +";"); }else { JOptionPane.showMessageDialog(UserPanel.this,
						 * "Problem With Quantity Of \n " +
						 * "May Be You Have Not Returned Book Properly"); } } }
						 * 
						 * }else { JOptionPane.showMessageDialog(UserPanel.this,
						 * "Not Space To Issue Book"); } }
						 */
			    	}catch (Exception e) {
						// TODO: handle exception
			    		System.out.println("An Exception Occurred");
			    		JOptionPane.showMessageDialog(UserPanel.this, e.getMessage());
					}
			    }
			
		});
		btnDone.setIcon(new ImageIcon(UserPanel.class.getResource("/IconImages/doneicon.png")));
		btnDone.setBounds(154, 245, 117, 25);
		getContentPane().add(btnDone);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReturnBook.setBounds(174, 318, 117, 15);
		getContentPane().add(lblReturnBook);
		
		returnUBookIdField = new JTextField();
		returnUBookIdField.setBounds(211, 337, 177, 19);
		getContentPane().add(returnUBookIdField);
		returnUBookIdField.setColumns(10);
		
		JLabel lblUbookid_1 = new JLabel("UBookId:");
		lblUbookid_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUbookid_1.setBounds(78, 339, 115, 15);
		getContentPane().add(lblUbookid_1);
		
		JButton btnDoneReturn = new JButton("Done");
		btnDoneReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ubookid = returnUBookIdField.getText().trim();
				 if(ubookid.equals("")) {
					 JOptionPane.showMessageDialog(UserPanel.this, "Enter The Unique Book Id To Return The Book");
				 }
				 else {
					   try {
						Connection con = new ConnectionManager().getConnection();
						Statement s= con.createStatement();
						ResultSet rs = s.executeQuery("SELECT * FROM students WHERE ubookid1= '"+ubookid+"';");
					    ResultSet rs1;
						boolean isEmpty = rs.next();
						if (!isEmpty) {
							rs1= s.executeQuery("SELECT * FROM students WHERE ubookid2 = '"+ubookid+"';");
							 if(!(rs1.next())) {
								 JOptionPane.showMessageDialog(UserPanel.this,"There Is Some Problem Check The Student Account");
							 }else {
								 String bookid = rs1.getString("book_id2");
								 String rollno1=rs1.getString("rollno");
								 try {
								 Statement s1 = con.createStatement();
								  ResultSet rs2 = s1.executeQuery("SELECT quantity FROM books WHERE id = '"+bookid+"';");
								  rs2.next();
								  int quantity= rs2.getInt("quantity");
								  int finalquantity = quantity+1;
								  Statement s2 = con.createStatement();
								  s2.executeUpdate("UPDATE books SET quantity = "+finalquantity+" WHERE id = '"+bookid+"';");
								  s2.executeUpdate("UPDATE students SET ubookid2="+null+",book_name_2 ="+null+",book_id2="+null+",date_of_issue_book2="+null+";");
							      JOptionPane.showMessageDialog(UserPanel.this, "Book 2 Is Returned Succefully");
								 }catch (Exception e) {
									// TODO: handle exception
									 JOptionPane.showMessageDialog(UserPanel.this,e.getMessage());
								}
							 }
							 
							
						}else {
							String bookid = rs.getString("book_id1");
							 String rollno=rs.getString("rollno");
							 try {
							 Statement s1 = con.createStatement();
							  ResultSet rs2 = s1.executeQuery("SELECT quantity FROM books WHERE id = '"+bookid+"';");
							  rs2.next();
							  int quantity= rs2.getInt("quantity");
							  int finalquantity = quantity+1;
							  Statement s2 = con.createStatement();
							  s2.executeUpdate("UPDATE books SET quantity = "+finalquantity+" WHERE id = '"+bookid+"';");
							  s2.executeUpdate("UPDATE students SET ubookid1="+null+",book_name_1="+null+",book_id1="+null+",date_of_issue_book1="+null+";");
						      JOptionPane.showMessageDialog(UserPanel.this, "Book 1 Is Returned Succefully");
							 }catch (Exception e) {
								// TODO: handle exception
								 JOptionPane.showMessageDialog(UserPanel.this,e.getMessage());
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(UserPanel.this, e.getMessage());
						}
				 }
			}
		});
		btnDoneReturn.setIcon(new ImageIcon(UserPanel.class.getResource("/IconImages/doneicon.png")));
		btnDoneReturn.setBounds(154, 368, 117, 25);
		getContentPane().add(btnDoneReturn);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addbooks addbooks = new Addbooks();
				addbooks.setSize(940, 570);
				addbooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addbooks.setVisible(true);
			}
		});
		btnAddBooks.setBounds(38, 624, 155, 50);
		getContentPane().add(btnAddBooks);
		
		JButton btnDeleteBooks = new JButton("Delete Books");
		btnDeleteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBooks deleteBooks = new DeleteBooks();
				deleteBooks.setSize(550,350);
				deleteBooks.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				deleteBooks.setVisible(true);
			}
		});
		btnDeleteBooks.setBounds(241, 624, 147, 50);
		getContentPane().add(btnDeleteBooks);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudent addStudent = new AddStudent();
				addStudent.setSize(970,550);
				addStudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addStudent.setVisible(true);
			}
		});
		btnAddStudent.setBounds(442, 624, 148, 50);
		getContentPane().add(btnAddStudent);
		
		JButton btnRemoeStudent = new JButton("Remove Student");
		btnRemoeStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveStudent removeStudent = new RemoveStudent();
				removeStudent.setSize(450,310);
				removeStudent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				removeStudent.setVisible(true);
			}
		});
		btnRemoeStudent.setBounds(648, 624, 171, 50);
		getContentPane().add(btnRemoeStudent);
		

	}
}
