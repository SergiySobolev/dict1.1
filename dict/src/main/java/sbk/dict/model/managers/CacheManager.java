package sbk.dict.model.managers;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;
import sbk.dict.model.factories.ICacheManagerObjectFactory;

public class CacheManager {
	ICacheManager cacheManager;	
	static String factoryName;
	static Class  factoryClass;
	static {
		try {	
			Context ctx = new InitialContext();
			factoryName = (String) ctx
					.lookup("java:comp/env/cachemanager.ObjectFactory");			
			factoryClass = Class.forName(factoryName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public CacheManager() {		
		try {
			ICacheManagerObjectFactory factory = (ICacheManagerObjectFactory) factoryClass.newInstance();					
			cacheManager = factory.getCacheManagerObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void backup(ArrayList<Subscriber> list) {
		if(cacheManager != null){
			cacheManager.backup(list);
		}
	}
	public ArrayList<Subscriber> restore() {
		if(cacheManager != null){
			return cacheManager.restore();
		}else{
			return null;
		}
	}
}
