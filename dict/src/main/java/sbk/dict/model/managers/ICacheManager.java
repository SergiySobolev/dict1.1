package sbk.dict.model.managers;

import java.util.ArrayList;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;

public interface ICacheManager {
	public void backup(ArrayList<Subscriber> list);
	public ArrayList<Subscriber> restore();	
}
