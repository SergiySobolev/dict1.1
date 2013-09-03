package sbk.dict.model.managers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.PhoneNumber;
import sbk.dict.model.beans.PhoneType;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.beans.SubscriberType;
import sbk.dict.model.utils.HibernateUtils;

public class HibSearchManager implements ISearchManager {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HibSearchManager sm = new HibSearchManager();
		// sm.makeInsert("Сотрудник", "SubsName31", "Мобильный", "999999");
		DictReqForm dictReqForm = new DictReqForm();
		dictReqForm.setLastName("LastName1");
		sm.makeSearch(dictReqForm);
	}
	private boolean isNotEmpty(String s) {
		return s != "" && s != null;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Subscriber> makeSearch(DictReqForm dictReqForm) {
		ArrayList<Subscriber> result = new ArrayList<Subscriber>();
		Session session = HibernateUtils.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Subscriber.class);
		if (this.isNotEmpty(dictReqForm.getLastName())) {
			criteria.add(Restrictions.eq("subscrLastName",
					dictReqForm.getLastName()));
		}
		if (this.isNotEmpty(dictReqForm.getFirstName())) {
			criteria.add(Restrictions.eq("subscrFirstName",
					dictReqForm.getFirstName()));
		}
		if (this.isNotEmpty(dictReqForm.getDepartament())) {
			criteria.add(Restrictions.eq("departament",
					dictReqForm.getDepartament()));
		}
		if (this.isNotEmpty(dictReqForm.getPosition())) {
			criteria.add(Restrictions.eq("position", dictReqForm.getPosition()));
		}
		criteria.setCacheable(true);
		result = (ArrayList<Subscriber>) criteria.list();
		session.getTransaction().commit();
		return result;
	}
	private void makeInsert(String sT, String sN, String pT, String pN) {
		SubscriberType subscriberType = new SubscriberType();
		Subscriber subscriber = new Subscriber();
		PhoneType phoneType = new PhoneType();
		PhoneNumber phoneNumber = new PhoneNumber();
		Object res;
		Criteria criteria;
		ArrayList list;
		Session session = HibernateUtils.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		// SUBSCRIBERTYPE
		if (this.isNotEmpty(sT)) {
			criteria = session.createCriteria(SubscriberType.class);
			criteria.add(Restrictions.eq("typeDescription", sT));
			res = criteria.uniqueResult();
			if ((res != null) && (res instanceof SubscriberType)) {
				subscriberType = (SubscriberType) res;
			} else {
				subscriberType.setTypeDescription(sT);
				session.save(subscriberType);
			}
		}
		// SUBSCRIBER
		if (this.isNotEmpty(sN)) {
			criteria = session.createCriteria(Subscriber.class);
			criteria.add(Restrictions.eq("subscriberName", sN));
			criteria.add(Restrictions.eq("subsType", subscriberType));
			list = (ArrayList<Object>) criteria.list();
			if (list.size() > 0) {
				for (Object o : list) {
					if (o instanceof Subscriber) {
						subscriber = (Subscriber) o;
					}
				}
			} else {
				subscriber.setSubscriberName(sN);
				subscriber.setSubsType(subscriberType);
				subscriberType.getSubscribersSet().add(subscriber);
				session.save(subscriberType);
				session.save(subscriber);

			}
		}
		// PHONETYPE
		if (this.isNotEmpty(pT)) {
			criteria = session.createCriteria(SubscriberType.class);
			criteria.add(Restrictions.eq("typeDescription", pT));
			res = criteria.uniqueResult();
			if ((res != null) && (res instanceof PhoneType)) {
				phoneType = (PhoneType) res;
			} else {
				phoneType.setPhoneTypeDesc(pT);
				session.save(phoneType);
			}

			criteria = session.createCriteria(PhoneType.class);
			criteria.add(Restrictions.eq("phoneTypeDesc", pT));
			res = criteria.uniqueResult();
			if ((res != null) && (res instanceof PhoneType)) {
				phoneType = (PhoneType) res;
			} else {
				phoneType.setPhoneTypeDesc(pT);
				session.save(phoneType);
			}
		}
		// PHONENUMBER
		if (this.isNotEmpty(pN)) {
			criteria = session.createCriteria(PhoneNumber.class);
			criteria.add(Restrictions.eq("phoneNumber", pN));
			list = (ArrayList<Object>) criteria.list();
			if (list.size() > 0) {
				for (Object o : list) {
					if ((o != null) && (o instanceof PhoneNumber)) {
						phoneNumber = (PhoneNumber) o;
					}
				}
			} else {
				phoneNumber.setPhoneNumber(pN);
				phoneNumber.setPhoneType(phoneType);
				phoneNumber.setSubscriber(subscriber);
				phoneType.getNumberSet().add(phoneNumber);
				session.save(phoneType);
				subscriber.getPhoneNumberSet().add(phoneNumber);
				session.save(subscriber);
				session.save(phoneNumber);
			}
		}
		session.getTransaction().commit();
	}
	private void makeInsert() {
		Session session = HibernateUtils.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		SubscriberType subsType = new SubscriberType();
		Subscriber subs = new Subscriber();
		PhoneType phoneType = new PhoneType();
		PhoneNumber phoneNumber = new PhoneNumber();
		subsType.setTypeDescription("subsTypeDesc10");
		subs.setSubscriberName("SubscriberName1");
		subsType.getSubscribersSet().add(subs);
		session.save(subsType);
		subs.setSubsType(subsType);
		subs.getPhoneNumberSet().add(phoneNumber);
		session.save(subs);
		phoneType.setPhoneTypeDesc("phonetypedesc10");
		phoneNumber.setPhoneNumber("123123123");
		phoneType.getNumberSet().add(phoneNumber);
		session.save(phoneType);
		phoneNumber.setPhoneType(phoneType);
		phoneNumber.setSubscriber(subs);
		session.save(phoneNumber);
		session.getTransaction().commit();
	}
}
