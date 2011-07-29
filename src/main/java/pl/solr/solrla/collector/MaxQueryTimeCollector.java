package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;

/**
 * Collector that collects the maximum query execution time.
 * 
 * @author Rafał Kuć
 *
 */
public class MaxQueryTimeCollector implements Collector<Long> {
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
    public Long getCollectResult() {
        return maxTime;
    }
}
