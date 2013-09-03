package sbk.dict.model.factories;

import sbk.dict.model.managers.ICacheManager;
import sbk.dict.model.managers.MemCacheManager;

public class MemCacheManagerObjectFactory implements ICacheManagerObjectFactory {
	public ICacheManager getCacheManagerObject() {
		return new MemCacheManager();
	}
}
