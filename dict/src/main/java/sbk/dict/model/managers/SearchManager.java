package sbk.dict.model.managers;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.factories.ISearchManagerObjectFactory;

public class SearchManager {
	ISearchManager searchManager = null;
	static String factoryName;
	static Class factoryClass;
	static {
		try {	
			Context ctx = new InitialContext();
			factoryName = (String) ctx
					.lookup("java:comp/env/searchmanager.ObjectFactory");
			System.out.println(factoryName.toString());
			factoryClass = Class.forName(factoryName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public SearchManager() {		
		try {
			ISearchManagerObjectFactory factory = (ISearchManagerObjectFactory) factoryClass.newInstance();					
			searchManager = factory.getSearchManagerObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Subscriber> makeSearch(DictReqForm dictReqForm) {
		if (searchManager != null) {
			return searchManager.makeSearch(dictReqForm);
		} else {
			return null;
		}
	}
}
