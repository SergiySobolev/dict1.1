package sbk.dict.controller.actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import sbk.dict.model.beans.DictReqForm;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DictReqAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			DictReqForm dictReqForm = (DictReqForm) form;
			return mapping.findForward("dict");
	}	
}
