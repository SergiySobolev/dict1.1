package sbk.dict.model.managers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.factories.IRequestManagerObjectFactory;

public class RequestManager {
	IRequestManager requestManager;
	static String factoryName;
	static Class factoryClass;
	static {
		try {	
			Context ctx = new InitialContext();
			factoryName = (String) ctx
					.lookup("java:comp/env/requestmanager.ObjectFactory");
			System.out.println(factoryName.toString());
			factoryClass = Class.forName(factoryName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public RequestManager() {		
		try {
			IRequestManagerObjectFactory factory = (IRequestManagerObjectFactory) factoryClass.newInstance();					
			requestManager = factory.getRequestManagerObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void addToRequests(DictReqForm dictReqForm, HttpServletRequest request){
		requestManager.addToRequests(dictReqForm, request);
	}
}
