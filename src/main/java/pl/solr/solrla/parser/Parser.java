package pl.solr.solrla.parser;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.input.InputHandler;

/**
 * Parser interface.
 * 
 */
public interface Parser {
    /**
     * Reads a single line from the input handler
     * 
     * @param inputHandler
     *            input handler to read the data from
     * @return log line or <code>null</code>
     */
    LogLine readLine(InputHandler inputHandler);
}
