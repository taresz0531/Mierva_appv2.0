package hu.tarnai.minerva.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringUtils {
	//private static Logger logger = LoggerUtils.getLogger(StringUtils.class); 
	
	/**
	 * Üres sztring
	 */
	public static final String EMPTY_STRING = "";
	
	/**
	 * Szóköz
	 */
	public static final String SPACE_STRING = " ";
	
	
	/**
	 * Soremelés: \n
	 */
	public static final String LINE_BREAK = "\n";
	
	/**
	 * Soremelés: Html <BR>
	 */
	public static final String LINE_BREAK_HTML = "<BR>";
	
	/**
	 * Vessző
	 */
	public static final String COMMA_STRING = ",";
	
	/**
	 * Kettőspont
	 */
	public static final String COLON_STRING = ":";
	
	/**
	 * Pontosvessző
	 */
	public static final String SEMICOLON_STRING = ";";
	
	/**
	 * Pont
	 */
	public static final String DOT_STRING = ".";


	public static String capitalizeFirstLetter(String string) {
        return isEmptyString(string) ? EMPTY_STRING : (string.substring(0, 1).toUpperCase() + string.substring(1));
	}
	
	public static String unCapitalizeFirstLetter(String string) {
        return isEmptyString(string) ? EMPTY_STRING : (string.substring(0, 1).toLowerCase() + string.substring(1));
	}
	
	public static String nvl(String string, String resultIfNull) { 
		return (string != null ? string : resultIfNull);
	}
	
	public static String nullToEmptyString(String string) {
		return nvl(string, EMPTY_STRING);
	}
	
	public static String getToStringIfNotNull(Object object) {
		return (object != null ? object.toString() : EMPTY_STRING);
	}
	
	public static boolean isEmptyString(String string) {
		return (string == null || string.trim().isEmpty());
	}

	public static boolean isEmptyString(Object object) {
		return (object == null || isEmptyString(object.toString()));
	}	
	
	public static boolean isNotEmptyString(String string) {
		return !isEmptyString(string);
	}
	
	public static String trim(String string) {
		return string != null ? string.trim() : null;
	}
	

//	public static Pattern VARIABLE_PATTERN = Pattern.compile("([\\w,$][a-z,$,_,0-9]*)");
//	public static Pattern CONSTANT_PATTERN = Pattern.compile("([^_]*)(?>_|$)");
	
//	public static String toConstantName(String variableName) {
//		Matcher matcher = VARIABLE_PATTERN.matcher(variableName);
//		
//		String name = "";
//		while (matcher.find()) {
//			name += (name.isEmpty() ? EMPTY_STRING : "_") + matcher.group(1).toUpperCase();
//		}
//		
//		return name;
//	}
//	
//	public static String toClassName(String constantName) {
//		Matcher matcher = CONSTANT_PATTERN.matcher(constantName);
//		
//		String name = "";
//		while (matcher.find()) {
//			name += capitalizeFirstLetter(matcher.group(1).toLowerCase());
//		}
//		
//		return name;
//	}
//	
//	public static String toVariableName(String constantName) {
//		return unCapitalizeFirstLetter(toClassName(constantName));
//	}
	
	
	/**
	 * Összefűzi egy kollekció elemeit egy sztringbe. A <code>null</code> értékeket nem fűzi a sztringbe.
	 * Kivétel váltódik ki, ha a megadott minta nem megfelelő.
	 * @param collection A megadott kollekció
	 * @param separator Az egyes értékeket elválasztó sztring
	 * @param pattern A minta, amely alapján az kollekció elemeiből kiveszi az értéket. (Pl.: akarmi.valami.egyeb )
	 * @return
	 * @throws Exception
	 */
	/*public static String appendCollection(Collection<?> collection, String separator, String pattern) throws Exception {
		String result = StringUtils.EMPTY_STRING;
		
		if (collection != null) {
			result = appendArray((Object[]) collection.toArray(new Object[collection.size()]), separator, pattern);
		}
		
    	return result;
	}*/

	/*public static String appendCollection(Collection<?> collection, String separator) {
		try {
			return appendCollection(collection, separator, EMPTY_STRING);
		} catch (Exception e) {} // mivel nincs pattern, exception sincs
		return null;
	}*/
	
	/**
	 * Összefűzi egy tömb elemeit egy sztringbe. A <code>null</code> értékeket nem fűzi a sztringbe.
	 * Kivétel váltódik ki, ha a megadott minta nem megfelelő.
	 * @param array A megadott tömb
	 * @param separator Az egyes értékeket elválasztó sztring
	 * @param pattern A minta, amely alapján a tömb elemeiből kiveszi az értéket. (Pl.: akarmi.valami.egyeb )
	 * @return
	 * @throws Exception
	 */
	/*public static String appendArray(Object[] array, String separator, String pattern) throws Exception {
		if (separator == null) {
			separator = StringUtils.EMPTY_STRING;
		}
		
		StringBuilder result = new StringBuilder();
		String tmpSeparator = StringUtils.EMPTY_STRING;
		if (array != null) {
			for (Object object : array) {
				Object element = !isEmptyString(pattern) ? ReflectionUtils.getPatternValue(object, pattern) : object;
				if (element != null) {
					result.append(tmpSeparator).append(element.toString());
					tmpSeparator = separator;
				}
			}
		}
		
    	return result.toString();
	}*/
	
	/*public static String appendArray(Object[] array, String separator) { 
		try {
			return appendArray(array, separator, "");
		} catch (Exception e) {} // mivel nincs pattern, exception sincs
		return null;
	}	*/
	
	public static String appendMap(Map<?, ?> map, String itemSeparator, String lineSeparator) {
		StringBuilder sb = new StringBuilder();
		
		for(Entry<?, ?> entry : map.entrySet()) {
			sb.append(sb.length() > 0 ? lineSeparator : "")
					.append(toString(entry.getKey())).append(itemSeparator).append(toString(entry.getValue()));
		}
		
		return sb.toString();
	}
	
	/*public static String describeObject(Object object) {
		try {
			return appendMap(BeanUtils.describe(object), " = ", System.getProperty("line.separator"));
		} catch (Exception e) {
			return EMPTY_STRING;
		}
	}*/
	
	public static boolean equal(String string1, String string2) {
		boolean isEmptyString1 = StringUtils.isEmptyString(string1);
		boolean isEmptyString2 = StringUtils.isEmptyString(string2);
		
		if (isEmptyString1 || isEmptyString2) {
			return isEmptyString1 == isEmptyString2;
		}

		return string1.trim().equals(string2.trim());
	}
	
	public static boolean equalIgnoreCase(String string1, String string2) {
		boolean isEmptyString1 = StringUtils.isEmptyString(string1);
		boolean isEmptyString2 = StringUtils.isEmptyString(string2);
		
		if (isEmptyString1 || isEmptyString2) {
			return isEmptyString1 == isEmptyString2;
		}

		return string1.trim().equalsIgnoreCase(string2.trim());
	}
	
	public static String fillFromLeft(String source, char c, int length) {
		StringBuilder sb = new StringBuilder(source != null ? source : "");
		while (sb.length() < length) {
			sb.insert(0, c);
		}
		return sb.toString();
	}
	
	public static String concatenate(String separator, boolean trim, String... strings) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < strings.length; i++) {
			if (!isEmptyString(strings[i])) {
				if (result.length() > 0) {
					result.append(separator);
				}
				if (trim) {
					strings[i] = strings[i].trim();
				}
				result.append(strings[i]);
			}
		}
		return result.toString();
	}
	
	public static String Quote(Object object) {
		return Quote(object != null ? object.toString() : "", '\'');
	}
	
	public static String Quote(String string) {
		return Quote(string, '\'');
	}

	public static String Quote(String string, char quotationMark) {
		return new StringBuilder(string).insert(0, quotationMark).append(quotationMark).toString();
	}
	
	public static String removeChars(String string, String regex) {
		return string != null ? string.replaceAll(regex, StringUtils.EMPTY_STRING) : null;
	}

	public static String formatTaj(String value) {
		if (!isEmptyString(value)) {
			boolean intvalue = value.length() == 9;
			for (int i = 0; i < value.length() && intvalue; i++) {
				intvalue &= Character.isDigit(value.charAt(i)); 
			}
			
			if (intvalue) {
				StringBuffer sb = new StringBuffer(value);
				//sb.append(value.substring(0, 3)).append("-").append(value.substring(3, 6)).append("-").append(value.substring(6, 9));
				sb.insert(6, '-').insert(3, '-');
				value = sb.toString();
			}			
		}
		return value;
	}
	
	/*public static String getStackTrace(Throwable throwable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		throwable.printStackTrace(printWriter);
		return result.toString();
	}*/
	
	public static String toString(Object object) {
		return toString(object, null);
	}

	public static String toString(Object object, String ifNullString) {
		return object != null ? object.toString() : ifNullString;
	}
	
	public static String toLowerCase(String string) {
		return string != null ? string.toLowerCase() : null;
	}
	
	public static String toUpperCase(String string) {
		return string != null ? string.toUpperCase() : null;
	}

	public static String getSqlName(String javaName) {
		return javaName.replaceAll("([A-Z]+)", "_$1").replaceAll("^_", "").toUpperCase();
	}

	public static String getJavaVariableName(String sqlName) {
		StringBuilder sb = new StringBuilder();
		
		for(String part: sqlName.toLowerCase().split("_")) {
			sb.append(sb.length() > 0 ? capitalizeFirstLetter(part) : part);
		}
		
		return sb.toString();
	}
	
	public static Collection<String> toUpperCase(Collection<String> stringList) {
		if (stringList == null) {return null;}
		List<String> result = new ArrayList<String>();
		
		for(String string : stringList) {
			result.add(string.toUpperCase());
		}
		
		return result;
	}

	public static Collection<String> toLowerCase(Collection<String> stringList) {
		if (stringList == null) {return null;}
		List<String> result = new ArrayList<String>();
		
		for(String string : stringList) {
			result.add(string.toLowerCase());
		}
		
		return result;
	}
	
	
}
