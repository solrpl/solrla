package pl.solr.solrla.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.analyzer.parser.impl.SimpleLogLine;

/** 
 * Parser implementation {@link Parser}. 
 */
public class StandardParser extends AbstractLineParser {
	private static final Pattern pattern = Pattern.compile(".*path=(.*) params=\\{(.*)} hits=(\\d+) status=(\\d+) QTime=(\\d+).*"); 

	@Override
	LogLine parseLine(String line) {
		Matcher m = pattern.matcher(line);
		if (!m.matches()) {
			return null;
		}
		SimpleLogLine l = new SimpleLogLine();
		l.setQuery(m.group(1));
		//TODO
		return l;
	}

}
