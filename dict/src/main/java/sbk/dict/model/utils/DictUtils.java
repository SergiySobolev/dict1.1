package sbk.dict.model.utils;

import javax.servlet.http.Cookie;
public class DictUtils {
	public static String findCookie(Cookie[] cookies, String key){
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				String name = cookies[i].getName();
				if(name.compareTo(key) == 0){
					return cookies[i].getValue();
				}
			}
		}
		return null;
	}
}
