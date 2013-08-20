package sbk.dict.model.managers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.RequestBean;
import sbk.dict.model.utils.HibernateUtils;

public class HibRequestManager implements IRequestManager {
	public void addToRequests(DictReqForm dictReqForm, HttpServletRequest req) {
		RequestBean requestManager = new RequestBean();
		Session session 		=		HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		requestManager.setIp(req.getRemoteHost());
		requestManager.setReqtime(new Date());
		requestManager.setLastname(dictReqForm.getLastName());
		requestManager.setFirstname(dictReqForm.getFirstName());
		requestManager.setOrganization(dictReqForm.getDepartament());
		requestManager.setPosition(dictReqForm.getPosition());
		session.save(requestManager);
		session.getTransaction().commit();
	}
}
