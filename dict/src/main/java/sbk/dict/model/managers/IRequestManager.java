package sbk.dict.model.managers;

import javax.servlet.http.HttpServletRequest;

import sbk.dict.model.beans.DictReqForm;

public interface IRequestManager {
	public void addToRequests(DictReqForm dictReqForm, HttpServletRequest req);
}
