package pl.solr.solrla.parser;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.input.InputHandler;

public interface Parser {

	LogLine readLine(InputHandler inputHandler);

}
