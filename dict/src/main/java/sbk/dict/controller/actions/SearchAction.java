package sbk.dict.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.exception.JDBCConnectionException;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.managers.SearchManager;

public class SearchAction extends Action {
	final private String INDEX = "index";
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		DictReqForm				dictReqForm				=	(DictReqForm)form;	
    	SearchManager 			mng						=	new SearchManager();
    	ArrayList<Subscriber>   resList					=   null;
    	try{
    		 resList					=	mng.makeSearch(dictReqForm);		
    	}catch(JDBCConnectionException ex){
    		 resList = null;
    		 //TODO get list from cache stub
		}
		request.setAttribute("resList", resList);
		dictReqForm.setSubscriberList(resList);
		return mapping.findForward(INDEX);
	}
}
