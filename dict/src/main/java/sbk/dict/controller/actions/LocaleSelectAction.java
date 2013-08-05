package sbk.dict.controller.actions;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class LocaleSelectAction extends DispatchAction {
	private final String INDEX = "index";	
	public ActionForward russian(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {			
		request.getSession().setAttribute(Globals.LOCALE_KEY,new Locale("ru"));				
		return mapping.findForward(INDEX);
	}	
	public ActionForward english(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {	
		request.getSession().setAttribute(Globals.LOCALE_KEY,Locale.US);				
		return mapping.findForward(INDEX);
	}
	public ActionForward ukrainian(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {	
		request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale("ua"));				
		return mapping.findForward(INDEX);
	}
}
