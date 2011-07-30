package pl.solr.solrla.parser;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.analyzer.parser.impl.SimpleLogLine;
import pl.solr.solrla.input.InputHandler;

public class StandardParser implements Parser {

	public LogLine readLine(final InputHandler inputHandler) {
		String next = inputHandler.getNextItem();
		if (next == null) {
			return null;
		}
		//TODO parse line
		return new SimpleLogLine();
	}

}
