package sbk.dict.model.beans;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {
	private String name;
	private String email;
	private String error;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getError() {
		return error;
	}
	public void setError() {
		 this.error =
			        "<span style='color:red'>Please provide valid entries for both fields</span>";
	}
	
}
