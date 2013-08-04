package sbk.dict.model.managers;

import java.util.ArrayList;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;

public interface ISearchManager {
	public ArrayList<Subscriber> makeSearch(DictReqForm dictReqForm);
}
