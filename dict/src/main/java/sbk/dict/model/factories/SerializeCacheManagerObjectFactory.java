package sbk.dict.model.factories;

import sbk.dict.model.managers.ICacheManager;
import sbk.dict.model.managers.SerializeCacheManager;

public class SerializeCacheManagerObjectFactory implements ICacheManagerObjectFactory {
	public ICacheManager getCacheManagerObject() {
		return new SerializeCacheManager();
	}
}
