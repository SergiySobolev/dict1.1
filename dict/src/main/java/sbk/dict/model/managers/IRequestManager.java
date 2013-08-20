package sbk.dict.model.managers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;

public interface IRequestManager {
	public void addToRequests(DictReqForm dictReqForm, HttpServletRequest req);
}
