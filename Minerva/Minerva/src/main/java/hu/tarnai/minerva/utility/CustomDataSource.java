package hu.tarnai.minerva.utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;



// net.sf.jasperreports.engine.JRDataSource
public class CustomDataSource implements JRDataSource {
	private static final int MAX_DEPTH = 1;
	
	int index = -1;
	private List<?> list;

	public CustomDataSource(List<?> beanList) {
		this.list = beanList != null ? beanList : new ArrayList<Object>();
	}

	public <T> CustomDataSource(T[] beanArray) {
		this.list = beanArray != null ? Arrays.asList(beanArray) : new ArrayList<Object>();
	}	
	
	public Object getField(Object object, String fieldName) {
		return getField(object, fieldName, 0);
	}

	public Object getField(Object object, String fieldName, int depth) {
		if (object == null) return null;
		Object result = null;
		if (ReflectionUtils.isMap(object)) { // Map
			if ((result = ((Map<?,?>) object).get(fieldName)) == null ) {
				for(Object entry : ((Map<?,?>) object).values()) {
					if ((result = getField(entry, fieldName, depth + 1)) != null) {break;}
				}
			}
		} else { // bean
			Class<?> clazz = object.getClass();
			Method[] getters = ReflectionUtils.getDeclaredGetters(clazz);
			Method getter = ReflectionUtils.findMatch(fieldName, getters);
			if (getter != null) {
				result = callMethod(getter, object);
			} else if (depth < MAX_DEPTH) {
				for(int i = 0; i < getters.length && result == null; i++) {
					result = getField(callMethod(getters[i], object), fieldName, depth + 1);
				}
			}
		}
		return result;
	}

	public Object callMethod(Method method, Object object) {
		try {
			Object val = method.invoke(object);
			if (val == null && method.getReturnType().equals(String.class)) {
				val = "";
			}
			return val;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getFieldValue(JRField field) throws JRException {
		String name = field.getName();
		
		int dot = name.indexOf(".");
		
		Object bean = list.get(index);
		
		String prop; 
		while (name != null) {
			if (dot > 0) {
				prop = name.substring(0, dot);
				name = name.substring(dot+1);
				dot = name.indexOf(".");
			} else {
				prop = name;
				name = null;
				dot = -1;
			}
			bean = getField(bean, prop);
		}
		
		return bean;
	}

	public boolean next() throws JRException {
		return ++index < list.size();
	}
}
