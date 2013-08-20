package sbk.dict.model.factories;

import sbk.dict.model.managers.HibRequestManager;
import sbk.dict.model.managers.IRequestManager;


public class HibRequestManagerObjectFactory implements IRequestManagerObjectFactory {
	public IRequestManager	getRequestManagerObject(){
		return new HibRequestManager();
	}
}
