package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.collector.result.CollectingResult;

/** 
 * Statistics collector interface.
 * 
 * @author Rafał Kuć
 *
 */
public interface Collector {
    /** 
     * Processes the log line.
     * @param line log line
     */
    void collect(LogLine line);
    
    /** 
     * Return the collection result. 
     * @return collection result
     */
    CollectingResult getCollectResult();
    
    /** 
     * resets the collector.
     */
    void reset();
}
