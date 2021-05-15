package MainPacakge;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
String name;
@Id
int id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
String password;
}
