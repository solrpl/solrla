package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.collector.result.CollectingResult;
import pl.solr.solrla.collector.result.StringCollectingResult;

/** 
 * Collector for finding the longest executing query.
 * 
 * @author Rafał Kuć
 *
 */
public class LongestExecutingQueryCollector implements Collector {
    /** Query. */
    private String query;
    
    /** Execution time. */
    private Long time = 0l;
    
    /** 
     * {@inheritDoc}
     */
    public void collect(LogLine line) {
        if (line.time() != null && line.query() != null) {
            if (line.time() > time) {
                time = line.time();
                query = line.query();
            }
        } 
    }

    /**
     * {@inheritDoc}
     */
    public CollectingResult getCollectResult() {
        return new StringCollectingResult(query);
    }

    /**
     * {@inheritDoc}
     */
    public void reset() {
        query = null;
        time = 0l;
    }
}
