package pl.solr.solrla.collector;

import pl.solr.solrla.analyzer.parser.LogLine;

/** 
 * Average query time collector.
 * 
 * @author Rafał Kuć
 *
 */
public class AvgQueryTimeCollector implements Collector<Long> {
    /** Number of lines. */
    private Long numberOfLines = 0l;
    
    /** Query time sum. */
    private Long queryTimeSum = 0l;
    
    /**
     * {@inheritDoc}
     */
    public void collect(LogLine line) {
        if (line.time() == null) {
            return;
        }
        numberOfLines++;
        queryTimeSum += line.time();
    }

    /**
     * {@inheritDoc}
     */
    public Long getCollectResult() {
        if (numberOfLines == 0l) {
            return 0l;
        } else {
            return queryTimeSum / numberOfLines;
        }
    }
    
    /** 
     * {@inheritDoc}
     */
    public void reset() {
        numberOfLines = 0l;
        queryTimeSum = 0l;
    }
}
