package pl.solr.solrla.parser;

import java.io.InputStream;

import pl.solr.solrla.analyzer.parser.LogLine;

/**
 * Parser interface.
 * 
 */
public interface Parser {
    /**
     * Reads a single line from the input handler
     * 
     * @param stream
     *            input stream to read the data from
     * @return log line or <code>null</code>
     */
    LogLine readLine(InputStream stream);
}
