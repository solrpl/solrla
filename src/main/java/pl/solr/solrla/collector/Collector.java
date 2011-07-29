package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;

/** 
 * Statistics collector interface.
 * 
 * @author Rafał Kuć
 *
 */
public interface Collector<T> {
    /** 
     * Processes the log line.
     * @param line log line
     */
    void collect(LogLine line);
    
    /** 
     * Return the collection result. 
     * @return collection result
     */
    T getCollectResult();
}
