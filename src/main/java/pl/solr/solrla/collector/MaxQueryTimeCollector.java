package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.collector.result.CollectingResult;
import pl.solr.solrla.collector.result.StringCollectingResult;

/**
 * Collector that collects the maximum query execution time.
 * 
 * @author Rafał Kuć
 *
 */
public class MaxQueryTimeCollector implements Collector {
    /** Maximum query execution time. */
    private Long maxTime = 0l;
    
    /** 
     * {@inheritDoc}
     */
    public void collect(LogLine line) {
        if (line.time() == null) {
            return;
        }
        if (line.time() > maxTime) {
            maxTime = line.time();
        }
    }

    /**
     * {@inheritDoc}
     */
    public CollectingResult getCollectResult() {
        return new StringCollectingResult(maxTime);
    }
    
    /**
     * {@inheritDoc}
     */
    public void reset() {
        maxTime = 0l;
    }
}
