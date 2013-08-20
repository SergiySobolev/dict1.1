package sbk.dict.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.LookupDispatchAction;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.managers.HibSearchManager;
import sbk.dict.model.managers.SearchManager;

public class DictionaryAction extends LookupDispatchAction {	
	private static final String search   	= "search"; 
	private static final String success 	= "success";
	private static final String userSuccess	= "userSuccess";
	public ActionForward search(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response){
			DictReqForm	dictReqForm				=		(DictReqForm)form;			
			SearchManager sm = new SearchManager();
			ArrayList<Subscriber> resList = sm.makeSearch(null);
			request.setAttribute("resList", resList);
			return mapping.findForward(search);
	}
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){			
			request.setAttribute("message", "from add");
			return mapping.findForward(userSuccess);
	}
	
	protected Map getKeyMethodMap() {
			Map<String, String> map =  new HashMap<String, String>();
			map.put("search.title", "search");
			map.put("add.title", "add");
			return map;
	}
}
