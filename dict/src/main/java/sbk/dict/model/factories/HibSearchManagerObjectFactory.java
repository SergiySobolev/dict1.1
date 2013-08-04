package sbk.dict.model.factories;

import sbk.dict.model.managers.HibSearchManager;
import sbk.dict.model.managers.ISearchManager;

public  class HibSearchManagerObjectFactory implements ISearchManagerObjectFactory {
	public ISearchManager getSearchManagerObject() {
		return (ISearchManager)new HibSearchManager();
	}
}
