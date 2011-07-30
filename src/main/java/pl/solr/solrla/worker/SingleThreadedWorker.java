package pl.solr.solrla.worker;

import java.util.ArrayList;
import java.util.List;

import pl.solr.solrla.collector.Collector;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;

/** 
 * Worker. 
 * 
 * @author Rafał Kuć
 *
 */
public class SingleThreadedWorker {
    /** Collectors. */
    protected List<Collector> collectors;
    
    /** Output handler. */
    private OutputHandler outputHandler;

    /** Input handler. */
    private InputHandler inputHandler;

    
    /** 
     * Add a new collector. 
     * @param collector collector
     */
    public final void addCollector(Collector collector) {
        if (collectors == null) {
            collectors = new ArrayList<Collector>();
        }
        collectors.add(collector);
    }
    
    public final void setCollectors(List<Collector> collectors) {
        this.collectors = collectors;
    }

    public final void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public final void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
}
