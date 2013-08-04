package sbk.dict.model.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class DictReqForm extends ActionForm {
	String 					lastName;
	String 					firstName;
	String 					departament;
	String 			  		position;
	String 			  		message;
	ArrayList<Subscriber>	subscriberList;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Subscriber> getSubscriberList() {
		return subscriberList;
	}
	public void setSubscriberList(ArrayList<Subscriber> subscriberList) {
		this.subscriberList = subscriberList;
	}	
}
