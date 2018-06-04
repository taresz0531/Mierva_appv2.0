package hu.tarnai.minerva.utility;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.tarnai.minerva.enums.Order;


public class ReflectionUtils {
	private static final Logger logger = Logger.getLogger(ReflectionUtils.class.getSimpleName()); 
	
	public static final String GETTER_PREFIX = "get";
	public static final String SETTER_PREFIX = "set";
	
	
	/**
	 * Egy értéked ad vissza az objektumból a megadott minta(pattern) alapján.
	 * Kivétel váltódik ki, ha a megadott minta nem megfelelő.
	 * @param object A megadott objektum.
	 * @param pattern A minta, amely alapján az értéket visszaadja.
	 * @return 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object getPatternValue(Object object, String pattern) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		if (object == null || StringUtils.isEmptyString(pattern)) {return object;}
		
		for (String member : pattern.split("[.]")) {
			if ((object = getFieldValue(object, member)) == null) {
				return null;	
			}
		}
		
		return object;
	}
	
	/**
	 * Az objektumban a megadott minta(pattern) alapján beállít egy értéket.
	 * Kivétel váltódik ki, ha a megadott minta nem megfelelő.
	 * @param object A megadott objektum.
	 * @param pattern A minta, amely alapján az értéket beállítja.
	 * @param value Az érték amelyet beállít.
	 * @return 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void setPatternValue(Object object, String pattern, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		if (object == null || StringUtils.isEmptyString(pattern)) {return;}
		
		String[] members = pattern.split("[.]");
		for (String member : members) {
			if ((object = getFieldValue(object, member)) == null) {
				return;	
			}
		}
		
		setFieldValue(object, members[members.length-1], value);
	}
	
	
	/**
	 * Loggolja az adott objektum értékeit.
	 * @param object A megadott objektum.
	 */
    public static void loggingObjectValues(Object object) {
    	if (logger.isLoggable(Level.FINE)) {
	    	try {
		    	if (object == null) {
		    		logger.fine("Object: null");
		    		return;
		    	}
		    	
		    	Method[] sm = object.getClass().getMethods();
		    	String name;
		    	Object getRes;
		    	
		    	for (Method method : sm) {
		    		name = method.getName();
		    		
					if (name.startsWith("get")) {
						name = name.substring(3);
						getRes = method.invoke(object, new Object[]{});
						
						logger.fine(name + ": " + getRes);
					}
				}
	    	}
	    	catch (Exception e) {
	    		StackTraceElement[] stackTraceElements = e.getStackTrace();
	    		if (stackTraceElements != null) {
	    			for (StackTraceElement stackTraceElement : stackTraceElements) {
						logger.fine(stackTraceElement.toString());
					}
	    		}
	    	}
    	}
    }
	
    /**
     * Az objektum getter metódussal eléhető adatait belerakja egy map-be aminek a kulcsa a paraméter neve lesz (get utáni rész kisbetűvel kezdve.)
     * (null-t nem rak bele a map-be.)
     * @param object A megadott objektum.
     * @return Egy map amelynek a kulcsa sztring.
     */
	public static Map<String, Object> objectValuesToMap(Object object) {
    	if (object == null) {return null;}
    	
    	Method[] sm = object.getClass().getMethods();
    	String name;
    	Object getRes;
    	Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    	
    	for (Method method : sm) {
    		name = method.getName();
    		
			if (name.startsWith("get")) {
				name = StringUtils.unCapitalizeFirstLetter(name.substring(3));
				
				try {
					getRes = method.invoke(object, new Object[]{});
					if (getRes != null) {
						resultMap.put(name, getRes);
					}
				}
				catch (IllegalAccessException e) {;}
				catch (IllegalArgumentException e) {;}
				catch (InvocationTargetException e) {;}
			}
		}
    	
    	return resultMap;
	}
	
    /**
	 * Az adott objektum értékei közül ha mind null, v. üres sztring akkor igazat ad vissza egyébként hamisat.
	 * @param object A megadott objektum.
	 */
    public static Boolean isEmptyObject(Object object) {
    	logger.fine("isEmptyObject start");
    	
    	try {
	    	if (object == null) {
	    		logger.fine("Object: null");
	    		return Boolean.TRUE;
	    	}
	    	
	    	Method[] sm = object.getClass().getMethods();
	    	String name;
	    	Object getRes;
	    	
	    	for (int i = 0; i < sm.length; i++) {
	    		name = sm[i].getName();
	    		
				if (name.startsWith("get") && !name.substring(3).equals("Class")) {
					name = name.substring(3);
					getRes = sm[i].invoke(object, new Object[]{});
					
					logger.fine(name + ": " + getRes);
					
					if (getRes != null && !(getRes instanceof String && StringUtils.isEmptyString((String) getRes))) {
						return Boolean.FALSE;
					}
				}
			}
    	}
    	catch (Exception e) {
    		return Boolean.FALSE;
    	}
    	
    	logger.fine("isEmptyObject end");
    	
    	return Boolean.TRUE;
    }
    
    /**
     * Null értéket helyettesít más értékre.
     * @param <T>
     * @param nullable
     * @param replace
     * @return
     */
    public static <T> T nvl(T nullable, T replace) {
    	return nullable != null ? nullable : replace;
    }
    
    /**
     * A source form minden adatát átmásolja a target form-ba.
     * @param sourceForm
     * @param targetForm
     * @throws Exception
     */
    public static void copyObjectValues(Object sourceObject, Object targetObject) throws Exception {
    	if (sourceObject == null || targetObject == null) return;
    	
    	Method[] sm = sourceObject.getClass().getMethods();
    	String name;
    	Method tMethod;
    	Object getRes;
    	
    	for (int i = 0; i < sm.length; i++) {
    		name = sm[i].getName();
    		
			if (name.startsWith("get")) {
				name = name.substring(3);
				try {
					tMethod = targetObject.getClass().getMethod("set"+name, new Class[] {sm[i].getReturnType()});
					getRes = sm[i].invoke(sourceObject, new Object[]{});
					
					if (getRes != null && getRes.getClass().equals(String.class)) {
						getRes = StringUtils.trim(((String)getRes));
					}
					
					tMethod.invoke(targetObject, new Object[]{getRes});
				}
				catch (NoSuchMethodException e) {;}
				catch (IllegalArgumentException e) {;}
				catch (InvocationTargetException e) {;}
				catch (IllegalAccessException e) {;}
			}
		}
    }
    
    /**
     * Összehasonlít két objektumot. Ha null mind a kettő akkor is egyenlőek.
     * @param o1
     * @param o2
     * @return
     */
	public static boolean equals(Object o1, Object o2) {
		if (o1 == o2 || o1 == null || o2 == null) {
			return o1 == o2;
		} 

		return o1.equals(o2);
	}
	
	public static String getFieldName(Method method) {
		if (method == null) {return null;}
		if (isGetter(method) || isSetter(method)) {
			String methodName = method.getName();
			return StringUtils.unCapitalizeFirstLetter(methodName.substring(3));
		}
		
		return null;
	}

	public static String getFieldName(String methodName) {
		if (isGetter(methodName) || isSetter(methodName)) {
			return StringUtils.unCapitalizeFirstLetter(methodName.substring(3));
		}
		
		return methodName;
	}	
	
	/**
	 * Egy metódusról edönti, hogy getter metódus-e.
	 * @param method a vizgálandó metódus
	 * @return true, ha getter; false, egyébként
	 */
	public static boolean isGetter(Method method) {
		return method.getName().startsWith(GETTER_PREFIX) && 
			method.getParameterTypes().length == 0 && 
			Modifier.isPublic(method.getModifiers());
	}

	/**
	 * Egy metódus nevéről edönti, hogy getter metódus-e.
	 * @param method a vizgálandó metódus
	 * @return true, ha getter; false, egyébként
	 */
	public static boolean isGetter(String methodName) {
		return methodName.startsWith(GETTER_PREFIX);
	}	
	
	/**
	 * Egy metódusról edönti, hogy setter metódus-e.
	 * @param method a vizgálandó metódus
	 * @return true, ha setter; false, egyébként
	 */
	public static boolean isSetter(Method method) {
		return method.getName().startsWith(SETTER_PREFIX) && 
			method.getParameterTypes().length == 1 && 
			Modifier.isPublic(method.getModifiers());
	}
	
	/**
	 * Egy metódus nevéről edönti, hogy setter metódus-e.
	 * @param method a vizgálandó metódus
	 * @return true, ha setter; false, egyébként
	 */
	public static boolean isSetter(String methodName) {
		return methodName.startsWith(SETTER_PREFIX);
	}
	
	/**
	 * Metódus névből (getter v. setter) kinyeri, a jozzá tartozó property nevet (első három karakter levágása).
	 * @param method a metódus objektum
	 * @return property név
	 */
	public static String getPropertyName(Method method) {
		return method != null ? StringUtils.unCapitalizeFirstLetter(method.getName().substring(3)) : null;
	}

	/**
	 * Az adott osztály által deklarált getter metódusokat adja vissza.
	 * @param clazz a vizsgálandó osztály
	 * @return getter metódusokat tartalmazó tömb
	 */
	public static Method[] getDeclaredGetters(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		int pos = 0;
		for(int i = 0; i < methods.length; i++) {
			if (isGetter(methods[i])) {
				if (pos != i) {
					methods[pos] = methods[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(methods, 0, pos);
	}

	/**
	 * Az adott osztály által deklarált setter metódusokat adja vissza.
	 * @param clazz a vizsgálandó osztály
	 * @return setter metódusokat tartalmazó tömb
	 */
	public static Method[] getDeclaredSetters(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		int pos = 0;
		for(int i = 0; i < methods.length; i++) {
			if (isSetter(methods[i])) {
				if (pos != i) {
					methods[pos] = methods[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(methods, 0, pos);
	}

	/**
	 * Az adott osztály setter metódusait (örökölt + deklarált) adja vissza.
	 * @param clazz a vizsgálandó osztály
	 * @return getter metódusokat tartalmazó tömb
	 */
	public static Method[] getGetters(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		int pos = 0;
		for(int i = 0; i < methods.length; i++) {
			if (isGetter(methods[i])) {
				if (pos != i) {
					methods[pos] = methods[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(methods, 0, pos);
	}

	/**
	 * Az adott osztály setter metódusait (örökölt + deklarált) adja vissza.
	 * @param clazz a vizsgálandó osztály
	 * @return setter metódusokat tartalmazó tömb
	 */
	public static Method[] getSetters(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		int pos = 0;
		for(int i = 0; i < methods.length; i++) {
			if (isSetter(methods[i])) {
				if (pos != i) {
					methods[pos] = methods[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(methods, 0, pos);
	}	
	
	/**
	 * Egy metódushoz kiválasztja a megfelelő metódust amely 
	 * ugyanolyan nevü property getter v. setter metódusa
	 * (getter metódushoz megfelelő setter keresés v. fordítva).
	 * @param method metódus objektum
	 * @param methods metódusokat tartalmazó tömb
	 * @return metódus objektum v. null ha a tömb nem tartalmaz megfelelőt
	 */
	public static Method findMatch(Method method, Method[] methods) {
		return findMatch(getPropertyName(method), methods);
	}
	
	public static Method[] getPairedGetters(Class<?> clazz) {
		Method[] getters = getGetters(clazz);
		Method[] setters = getSetters(clazz);
		
		int pos = 0;
		for(int i = 0; i < getters.length; i++) {
			if (findMatch(getters[i], setters) != null) {
				if (pos != i) {
					getters[pos] = getters[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(getters, 0, pos);
	}
	
	public static Method[] getPairedSetters(Class<?> clazz) {
		Method[] getters = getGetters(clazz);
		Method[] setters = getSetters(clazz);
		
		int pos = 0;
		for(int i = 0; i < setters.length; i++) {
			if (findMatch(setters[i], getters) != null) {
				if (pos != i) {
					setters[pos] = setters[i];
				}
				pos++;
			}
		}
		return Arrays.copyOfRange(setters, 0, pos);
	}
	
	/**
	 * Egy property-hez kiválasztja a megfelelő metódust amely 
	 * ugyanolyan nevü property getter v. setter metódusa
	 * (property-hez megfelelő setter v. getter keresés).
	 * @param propertyName property név
	 * @param methods metódusokat tartalmazó tömb
	 * @return metódus objektum v. null ha a tömb nem tartalmaz megfelelőt
	 */
	public static Method findMatch(String propertyName, Method[] methods) {
		if (propertyName == null || methods == null) {return null;}
		for(int i = 0; i < methods.length; i++) {
			if (propertyName.equalsIgnoreCase(getPropertyName(methods[i]))) {
				return methods[i];
			}
		}
		return null;
	}
	
	public static Method findMatch(Field property, Method[] methods) {
		return property != null ? findMatch(property.getName(), methods) : null;
	}
	
	public static Field getField(Class<?> clazz, Method method) throws SecurityException, NoSuchFieldException {
		return getField(clazz, getPropertyName(method));
	}

	public static Field getField(Class<?> clazz, String fieldName) throws SecurityException, NoSuchFieldException {
		return clazz.getDeclaredField(fieldName);
	}	

	public static Field getFieldRecursively(Class<?> clazz, Method method) throws SecurityException, NoSuchFieldException {
		return getFieldRecursively(clazz, getPropertyName(method));
	}
	
	public static Field getFieldRecursively(Class<?> clazz, String fieldName) throws SecurityException, NoSuchFieldException {
		Field field = null; 
		Class<?> currentClass = clazz;
		
		do {
			try {
				field = currentClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException ex) {}
			
			currentClass = currentClass.getSuperclass();
				
		} while (field == null && currentClass != null);
		
		if (field == null) throw new NoSuchFieldException();
		
		return field;
	}	
	
	public static Field[] getFieldsRecursively(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		Class<?> currentClass = clazz;

		do {
			fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
			currentClass = currentClass.getSuperclass();
		} while (currentClass != null);
		
		return fields.toArray(new Field[fields.size()]);
	}
	
	public static Field[] getFieldsRecursively(Class<?> clazz, Class<? extends Annotation> annotationClass) {
		List<Field> fields = new ArrayList<Field>();

		for(Field field : getFieldsRecursively(clazz)) {
			if (field.getAnnotation(annotationClass) != null) {
				fields.add(field);
			}
		}
		
		return fields.toArray(new Field[fields.size()]);
	}
	
	public static Method getGetter(Class<?> clazz, String fieldName) throws SecurityException, NoSuchMethodException {
		return clazz.getMethod(GETTER_PREFIX + StringUtils.capitalizeFirstLetter(fieldName), new Class<?>[]{});
	}
	
	public static Method getSetter(Class<?> clazz, String fieldName, Class<?>... parameterTypes) throws SecurityException, NoSuchMethodException {
		return clazz.getMethod(SETTER_PREFIX + StringUtils.capitalizeFirstLetter(fieldName), parameterTypes);
	}
	
	public static Object getFieldValue(Object object, String fieldName) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getFieldValue(object.getClass(), object, fieldName);
	}

	public static Object getFieldValue(Class<?> clazz, Object object, String fieldName) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getGetter(clazz, fieldName).invoke(object);
	}	
	
	private static Class<?>[] getTypes(Object... parameters) {
		Class<?>[] parameterTypes = new Class<?>[parameters.length];
		
		for(int i = 0; i < parameters.length; i++) {
			parameterTypes[i] = parameters[i] != null ? parameters[i].getClass() : Object.class;
		}
		
		return parameterTypes;
	}
	
	public static void setFieldValue(Object object, String fieldName, Object... parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		setFieldValue(object.getClass(), object, fieldName, parameters);
	}	

	public static void setFieldValue(Object object, String fieldName, Class<?>[] parameterTypes, Object[] parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		setFieldValue(object.getClass(), object, fieldName, parameterTypes, parameters);
	}	
	
	public static void setFieldValue(Class<?> clazz, Object object, String fieldName, Object... parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		setFieldValue(clazz, object, fieldName, getTypes(parameters), parameters);
	}
	
	public static void setFieldValue(Class<?> clazz, Object object, String fieldName, Class<?>[] parameterTypes, Object[] parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		getSetter(clazz, fieldName, parameterTypes).invoke(object, parameters);
	}
	
	public static <T> T newInstance(Class<T> clazz, Object... parameters) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return clazz.getConstructor(getTypes(parameters)).newInstance(parameters);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T invokeMethod(Class<?> clazz, Object object, String methodName, Object... parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return (T) clazz.getMethod(methodName, getTypes(parameters)).invoke(object, parameters);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getPropertyList(Object[] list, String propertyName, Class<T> propertyType, boolean preserveNull) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<T> result = new ArrayList<T>();

		if (list != null) {
			for (Object object : list) {
				Object value = null;
				if (object != null && ((value = getFieldValue(object, propertyName)) != null) || preserveNull) {
					result.add((T) value);
				}
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] getPropertyArray(Object[] list, String propertyName, Class<T> propertyType, boolean preserveNull) throws IllegalArgumentException, SecurityException, NegativeArraySizeException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<T> result = getPropertyList(list, propertyName, propertyType, preserveNull);
		return result.toArray((T[]) Array.newInstance(propertyType, result.size()));
	}
	
	public static <T> List<T> getPropertyList(Collection<?> list, String propertyName, Class<T> propertyType, boolean preserveNull) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return list != null ? getPropertyList(list.toArray(), propertyName, propertyType, preserveNull) : null;
	}

	public static <T> T[] getPropertyArray(Collection<?> list, String propertyName, Class<T> propertyType, boolean preserveNull) throws IllegalArgumentException, SecurityException, NegativeArraySizeException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return list != null ? getPropertyArray(list.toArray(), propertyName, propertyType, preserveNull) : null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getItemList(Object[][] list, int index, Class<T> propertyType, boolean preserveNull) {
		List<T> result = new ArrayList<T>();
		for (Object[] objects : list) {
			Object value = null;
			if (objects != null && ((value = objects[index]) != null) || preserveNull) {
				result.add((T) value);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] getItemArray(Object[][] list, int index, Class<T> propertyType, boolean preserveNull) {
		List<T> result = getItemList(list, index, propertyType, preserveNull);
		return result.toArray((T[]) Array.newInstance(propertyType, result.size()));
	}
	
	public static <T> List<T> getItemList(Collection<Object[]> list, int index, Class<T> propertyType, boolean preserveNull) {
		return getItemList(list.toArray(new Object[list.size()][]), index, propertyType, preserveNull);
	}

	public static <T> T[] getItemArray(Collection<Object[]> list, int index, Class<T> propertyType, boolean preserveNull) {
		return getItemArray(list.toArray(new Object[list.size()][]), index, propertyType, preserveNull);
	}	
	
	public static Map<String, Object> propertiesToMap(Object bean) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return propertiesToMap(bean, null);
	}
	
	public static Map<String, Object> propertiesToMap(Object bean, Map<String, Object> map) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (map == null) {map = new HashMap<String, Object>();}
		
		Method[] getters = getGetters(bean.getClass());
		for(Method getter : getters) {
			map.put(getPropertyName(getter), getter.invoke(bean));
		}
		
		return map;
	}
	
	public static <T> T getListItem(T[] list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getListItem(Arrays.asList(list), fieldName, fieldValue);
	}
	
	public static <T> T getListItem(List<T> list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (T item : list) {
			if (getFieldValue(item, fieldName).equals(fieldValue)) {
				return item;
			}
		}
		return null;
	}

	public static <T> List<T> getListItems(T[] list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getListItems(list != null ? Arrays.asList(list) : null, fieldName, fieldValue);
	}
	
	public static <T> List<T> getListItems(List<T> list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<T> result = new ArrayList<T>();
		
		if (list != null) {
			for (T item : list) {
				if (getFieldValue(item, fieldName).equals(fieldValue)) {
					result.add(item);
				}
			}
		}
		
		return result;
	}

	public static Object[] getListItem(Object[][] list, int index, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getListItem(Arrays.asList(list), index, fieldValue);
	}
	
	public static Object[] getListItem(List<Object[]> list, int index, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (Object[] item : list) {
			if (item[index].equals(fieldValue)) {
				return item;
			}
		}
		return null;
	}

	public static List<Object[]> getListItems(Object[][] list, int index, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getListItems(list != null ? Arrays.asList(list) : null, index, fieldValue);
	}
	
	public static List<Object[]> getListItems(List<Object[]> list, int index, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<Object[]> result = new ArrayList<Object[]>();
		
		if (list != null) {
			for (Object[] item : list) {
				if (item[index].equals(fieldValue)) {
					result.add(item);
				}
			}
		}
		
		return result;
	}	
	
	public static <T> int getListIndex(T[] list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getListIndex(list != null ? Arrays.asList(list) : null, fieldName, fieldValue);
	}
	
	public static <T> int getListIndex(List<T> list, String fieldName, Object fieldValue) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (getFieldValue(list.get(i), fieldName).equals(fieldValue)) {
					return i;
				}
			}
		}
		return -1;
	}	

	public static <T> int getExceptionSafeListIndex(T[] list, String fieldName, Object fieldValue) {
		try {
			return getListIndex(list, fieldName, fieldValue);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "", e);
		}
		return -1;
	}
	
	public static <T> int getExceptionSafeListIndex(List<T> list, String fieldName, Object fieldValue) {
		try {
			return getListIndex(list, fieldName, fieldValue);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "", e);
		}
		return -1;
	}

	public static <T> List<T> joinLists(List<T> list1, Object[] list2, String fieldName, boolean outer) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return list2 != null ? joinLists(list1, Arrays.asList(list2), fieldName, outer) : list1;
	}	
	
	public static <T> List<T> joinLists(List<T> list1, List<Object> list2, String fieldName, boolean outer) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (list2 == null) {return list1;}
		
		for (int i = 0; i < list1.size();) {
			Object item = getListItem(list2, fieldName, getFieldValue(list1.get(i), fieldName));
			if (item != null) {
				copyProperties(list1.get(i++), item);
			} else if (!outer) {
				list1.remove(i);
			}
		}

		return list1;
	}
	
	public static void copyProperties(Object dest, Object orig) {
		if (dest == null || orig == null) {
			return;
		}
		
		for(Method getter : getGetters(orig.getClass())) {
			try {
				String propertyName = getPropertyName(getter);
				Class<?> returnType = getter.getReturnType();
			
				Method setter = getSetter(dest.getClass(), propertyName, returnType);

				Object origValue = getter.invoke(orig);
				
				if (origValue != null) {
					setter.invoke(dest, origValue);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	public static <T> T fillProperties(Class<T> clazz, Object[] orig, String[] names) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		return fillProperties(clazz.newInstance(), orig, names);
	}	
	
	public static <T> T fillProperties(T dest, Object[] orig, String[] names) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (dest == null || orig == null || orig.length != names.length) {
			return null;
		}
		
		for(int i = 0; i < names.length; i++) {
			if (!StringUtils.isEmptyString(names[i]) && orig[i] != null) {
				setFieldValue(dest, names[i], orig[i]);
			}
		}
		
		return dest;
	}
	
	public static <T> List<T> fillBeanList(Class<T> clazz, Object[][] orig, String[] names) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		return fillBeanList(clazz, orig != null ? Arrays.asList(orig) : null, names);
	}
	
	public static <T> List<T> fillBeanList(Class<T> clazz, List<Object[]> orig, String[] names) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		List<T> result = new ArrayList<T>();
		
		if (orig != null) {
			for(Object[] propertires : orig) {
				result.add(fillProperties(clazz, propertires, names));
			}
		}
		
		return result;
	}
	
	public static class GeneralComparator<T> implements Comparator<T> {

		private Method getter;
		private Order order;
		
		// konstruktor
		public GeneralComparator(Class<T> clazz, String fieldName, Order order) throws Exception {
			getter = getGetter(clazz, fieldName);
			
			if ((this.order = order) == null) {
				throw new NullPointerException("Order should not be null!");
			}
			
			if (!Comparable.class.isAssignableFrom(getter.getReturnType())) {
				throw new Exception("The class of the '" + fieldName + "' field does not implements the Comparable<T> interface!");
			}
		}
		
		@SuppressWarnings("unchecked")
		public int compare(T o1, T o2) {
			try {
				Comparable<Object> obj1 = (Comparable<Object>) getter.invoke(o1);
				Comparable<Object> obj2 = (Comparable<Object>) getter.invoke(o2);
				
				if (obj1 != null && obj2 != null) {
					return obj1.compareTo(obj2) * order.getOrder();
				} else if (obj2 == null) {
					return 1  * order.getOrder();
				} else if (obj1 == null) {
					return -1  * order.getOrder();
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Compare error!", e);
			}
			return 0;
		}
		
	}
	
	public static boolean isListOrArray(Object object) {
		return object != null && (isList(object) || isArray(object));
	}

	public static boolean isListOrArray(Class<?> clazz) {
		return clazz != null && (isList(clazz) || isArray(clazz));
	}

	public static boolean isCollectionOrArray(Object object) {
		return object != null && (isCollection(object) || isArray(object));
	}

	public static boolean isCollectionOrArray(Class<?> clazz) {
		return clazz != null && (isCollection(clazz) || isArray(clazz));
	}
	
	public static boolean isArray(Object object) {
		return object != null && object.getClass().isArray();
	}

	public static boolean isArray(Class<?> clazz) {
		return clazz != null && clazz.isArray();
	}
	
	public static boolean isList(Object object) {
		return object != null && List.class.isInstance(object);
	}
	
	public static boolean isList(Class<?> clazz) {
		return clazz != null && List.class.isAssignableFrom(clazz);
	}

	public static boolean isCollection(Object object) {
		return object != null && Collection.class.isInstance(object);
	}

	public static boolean isCollection(Class<?> clazz) {
		return clazz != null && Collection.class.isAssignableFrom(clazz);
	}

	public static boolean isMap(Object object) {
		return object != null && Map.class.isInstance(object);
	}

	public static boolean isMap(Class<?> clazz) {
		return clazz != null && Map.class.isAssignableFrom(clazz);
	}	
	
	public static Class<?> getComponentType(Field field) {
		if (field.getType().isArray()) {
			return field.getType().getComponentType();
		} else if (isCollection(field.getType())) {
			return getGenericComponentType(field);
		}
		
		return null;
	}
	
	public static Class<?> getGenericComponentType(Class<?> clazz, String fieldName) throws SecurityException, NoSuchFieldException {
		return getGenericComponentType(getField(clazz, fieldName));
	}
	
	public static Class<?> getGenericComponentType(Field field) {
		Type type = field.getGenericType();  
		if (type instanceof ParameterizedType) {  
			return (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
		}
		
		return Object.class;
	}	

}
