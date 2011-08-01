package pl.solr.solrla.parser;

import java.util.regex.Pattern;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.analyzer.parser.impl.SimpleLogLine;
import pl.solr.tools.RegexpTool;

/** 
 * Parser implementation {@link Parser}. 
 */
public class StandardParser extends AbstractLineParser {
	private static final Pattern pattern = Pattern.compile(".*params=\\{(.*)} hits=(\\d+) status=\\d+ QTime=(\\d+).*"); 

	@Override
	LogLine parseLine(String line) {
		SimpleLogLine l = new SimpleLogLine();
		if (RegexpTool.applyRegexp(line, pattern, new String[] {"query", "hits", "time"}, l)) {
			return l;
		}
		return null;
	}

}
