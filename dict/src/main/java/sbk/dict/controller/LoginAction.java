package sbk.dict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sbk.dict.model.beans.LoginForm;

public class LoginAction extends Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
		    throws Exception {		 	
		
			LoginForm formBean = (LoginForm) form;
		    String name = formBean.getName();
		    String email = formBean.getEmail();
		  
		    if ((name == null) || 
		            email == null || 
		            name.equals("") || 
		            email.indexOf("@") == -1) { 
		    	formBean.setError();
		        return mapping.findForward(FAILURE);
		    }


		    return mapping.findForward(SUCCESS);
		}
}
