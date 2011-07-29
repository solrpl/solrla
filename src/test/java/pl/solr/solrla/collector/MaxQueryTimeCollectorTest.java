package pl.solr.solrla.collector;

import junit.framework.TestCase;

import org.junit.Test;

import pl.solr.solrla.analyzer.parser.impl.SimpleLogLine;
import pl.solr.solrla.collector.MaxQueryTimeCollector;


public class MaxQueryTimeCollectorTest extends TestCase {
    @Test
    public void testCollect() {
        MaxQueryTimeCollector collector = new MaxQueryTimeCollector();
        SimpleLogLine line1 = new SimpleLogLine();
        line1.setTime(100l);
        SimpleLogLine line2 = new SimpleLogLine();
        line2.setTime(90l);
        collector.collect(line1);
        collector.collect(line2);
        
        assertTrue(100l == collector.getCollectResult());
    }
}
