package sbk.dict.controller.actions;

import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.exception.JDBCConnectionException;
import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.managers.CacheManager;
import sbk.dict.model.managers.RequestManager;
import sbk.dict.model.managers.SearchManager;
import sbk.dict.model.utils.DictUtils;

public class SearchAction extends Action {
	final private String INDEX = "index";
	final private String LOCALE = "locale";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {			
		DictReqForm dictReqForm = (DictReqForm) form;
		SearchManager srchMng = new SearchManager();
		RequestManager recMng = new RequestManager();
		CacheManager cacheMng = new CacheManager();
		ArrayList<Subscriber> resList = null;
		Cookie[] cookies = request.getCookies();
		String locale = DictUtils.findCookie(cookies, LOCALE);
		if (locale != null) {
			request.getSession().setAttribute(Globals.LOCALE_KEY,
					new Locale(locale));
		}
		try {
			resList = srchMng.makeSearch(dictReqForm);
			if (!dictReqForm.hasAnyFilters()) {
				cacheMng.backup(resList);
			}
		} catch (JDBCConnectionException ex) {
			resList = cacheMng.restore();
		}
		request.setAttribute("resList", resList);
		dictReqForm.setSubscriberList(resList);
		try {
			recMng.addToRequests(dictReqForm, request);
		} catch (Exception ex) {

		}
		return mapping.findForward(INDEX);
	}
}
