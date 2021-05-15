package MainPacakge;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Books {
 String bookname;
  String author;
  String subject;
 int quantity;
 @Id 
 String id;
 String Rackno;
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRackno() {
	return Rackno;
}
public void setRackno(String rackno) {
	Rackno = rackno;
}

}
