package sbk.dict.model.managers;

import sbk.dict.model.beans.DictReqForm;

public interface ICacheManager {
	public void addToCache(DictReqForm dictReqForm);
	public DictReqForm getFromCache();	
}
