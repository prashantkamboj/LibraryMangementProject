package MainPacakge;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache (usage =  CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Student {
 String name;
 @Id
 @Column (length =20)
 String rollno;
 String classs;
 String ubookid;
 String ubookid1;
 String bookname;
 String bookname1;
 String dateOfIssueBook;
 String dateOfIssueBook1;
 String bookId;
 String bookId1;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getClasss() {
	return classs;
}
public void setClasss(String classs) {
	this.classs = classs;
}
public String getUbookid() {
	return ubookid;
}
public void setUbookid(String ubookid) {
	this.ubookid = ubookid;
}
public String getUbookid1() {
	return ubookid1;
}
public void setUbookid1(String ubookid1) {
	this.ubookid1 = ubookid1;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookname1() {
	return bookname1;
}
public void setBookname1(String bookname1) {
	this.bookname1 = bookname1;
}
public String getDateOfIssueBook() {
	return dateOfIssueBook;
}
public void setDateOfIssueBook(String dateOfIssueBook) {
	this.dateOfIssueBook = dateOfIssueBook;
}
public String getDateOfIssueBook1() {
	return dateOfIssueBook1;
}
public void setDateOfIssueBook1(String dateOfIssueBook1) {
	this.dateOfIssueBook1 = dateOfIssueBook1;
}
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public String getBookId1() {
	return bookId1;
}
public void setBookId1(String bookId1) {
	this.bookId1 = bookId1;
}
}
