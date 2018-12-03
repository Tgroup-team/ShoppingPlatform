package web.util;

import java.lang.reflect.Field;
import java.util.Map;

public class BuildObjectUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T build(Class<?> clazz,Map<String,Object> map) {
		T T_Object=null;
		try {
			Object object=clazz.newInstance();
			Field[] fields=clazz.getDeclaredFields();
			for(Field field:fields) {
				field.setAccessible(true);
				String fieldName=field.getName();
				field.set(object, map.get(fieldName));
			}
			T_Object=(T) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return T_Object;
	}
	
	public static String[] getAttrNames(Class<?> clazz) {
		Field[] fields=clazz.getDeclaredFields();
		String[] attrs=new String[fields.length];
		try {
			for(int i=0;i<fields.length;i++) {
				fields[i].setAccessible(true);
				attrs[i]=fields[i].getName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attrs;
	}
	
}
