package sbk.dict.model.managers;

import java.util.*;

import sbk.dict.model.beans.Subscriber;

public class MemCacheManager implements ICacheManager {
	String key = "nemiroffdictCache";

	//private void getCache() {
		// Cache cache;
		// try {
		// CacheFactory cacheFactory = CacheManager.getInstance()
		// .getCacheFactory();
		// cache = cacheFactory.createCache(Collections.emptyMap());
		// return cache;
		// } catch (CacheException e) {
		// e.printStackTrace();
		// return null;
		// }
	//	return null;
	//}

	@Override
	public void backup(ArrayList<Subscriber> list) {
	//	MemcacheService cache = this.getCache();
	//	if (cache != null) {
	//		cache.put(key, list);
	//	}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Subscriber> restore() {
	//	MemcacheService cache = this.getCache();
		ArrayList<Subscriber> list = null;
//		if (cache != null) {
//			list = (ArrayList<Subscriber>) cache.get(key);
//		}
		return list;
	}
}
