package pl.solr.tools;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;

import com.google.common.base.Throwables;
import com.google.common.collect.Maps;

public class RegexpTool {

	public static boolean applyRegexp(String input, String regexp,
			String[] fields, Object bean) {
		Pattern pattern = Pattern.compile(regexp);
		return applyRegexp(input, pattern, fields, bean);

	}
	
	public static boolean applyRegexp(String input, Pattern pattern,
			String[] fields, Object bean) {	
		Matcher matcher = pattern.matcher(input);
		if (! matcher.matches()) {
			return false;
		}
		Map<String, String> properties = Maps.newHashMap();
		int i = 1;
		for (String field : fields) {
			properties.put(field, matcher.group(i++));
		}
		try {
			BeanUtils.populate(bean, properties);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
		return true;
	}
}
