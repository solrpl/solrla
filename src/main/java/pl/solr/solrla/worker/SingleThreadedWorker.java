package pl.solr.solrla.worker;

import java.util.ArrayList;
import java.util.List;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.collector.Collector;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;

/** 
 * Worker. 
 * 
 * @author Rafał Kuć
 *
 */
public class SingleThreadedWorker implements Worker {
    /** Collectors. */
    protected List<Collector> collectors;
    
    /** Output handler. */
    private OutputHandler outputHandler;

    /** Input handler. */
    private InputHandler inputHandler;

    /** Parser. */
	private Parser parser;	

	public void run() {
        LogLine line;
        while((line = parser.readLine(inputHandler)) != null) {
            for (Collector col : collectors) {
                col.collect(line);
            }
        }
    }
	
    public SingleThreadedWorker(InputHandler inputHandler,
			OutputHandler outputHandler, Parser parser) {
    	this.inputHandler = inputHandler;
    	this.outputHandler = outputHandler;
    	this.parser = parser;
	}

	/* (non-Javadoc)
	 * @see pl.solr.solrla.worker.Worker#addCollector(pl.solr.solrla.collector.Collector)
	 */
    public final void addCollector(Collector collector) {
        if (collectors == null) {
            collectors = new ArrayList<Collector>();
        }
        collectors.add(collector);
    }
    
    /* (non-Javadoc)
	 * @see pl.solr.solrla.worker.Worker#setCollectors(java.util.List)
	 */
    public final void setCollectors(List<Collector> collectors) {
        this.collectors = collectors;
    }

    /* (non-Javadoc)
	 * @see pl.solr.solrla.worker.Worker#setOutputHandler(pl.solr.solrla.output.OutputHandler)
	 */
    public final void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    /* (non-Javadoc)
	 * @see pl.solr.solrla.worker.Worker#setInputHandler(pl.solr.solrla.input.InputHandler)
	 */
    public final void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public final void setParser(Parser parser) {
    	this.parser = parser;
    }

	public InputHandler getInputHandler() {
		return inputHandler;
	}

	public final OutputHandler getOutputHandler() {
		return outputHandler;
	}

	public Parser getParser() {
		return parser;
	}
}
