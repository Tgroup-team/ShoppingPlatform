package web.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolveObjectUtil {
	public static <E> List<Map<String, Object>> resolveObjects(List<E> objects){
		List<Map<String, Object>> elements=new ArrayList<Map<String,Object>>();
		for(E obj:objects) {
			elements.add(resolveObject(obj));
		}
		return elements;
	}
	
	public static <E> Map<String,Object> resolveObject(E e) {
		Map<String,Object> maps=new HashMap<String,Object>();
		Class<? extends Object> clazz=e.getClass();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields) {
			try {
				field.setAccessible(true);
				Object value=field.get(e);
				maps.put(field.getName(), value);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		return maps;
	}
}
