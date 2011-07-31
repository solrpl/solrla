package pl.solr.solrla.worker;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Throwables;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.collector.Collector;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;

/**
 * Single threaded worker implementation.
 *
 * @author Rafał Kuć
 *
 */
public class SingleThreadedWorker implements Worker {
    /** Collectors. */
    private List<Collector> collectors;

    /** Output handler. */
    private OutputHandler outputHandler;

    /** Input handler. */
    private InputHandler inputHandler;

    /** Parser. */
	private Parser parser;

	/**
	 * {@inheritDoc}
	 */
	public final void run() {
        LogLine line;
        for (InputStream stream = inputHandler.nextStream(); stream != null; stream = inputHandler.nextStream()) {
        	while ((line = parser.readLine(stream)) != null) {
        		for (Collector col : collectors) {
        			col.collect(line);
        		}
        	}
        	try {
				stream.close();
			} catch (IOException e) {
				throw Throwables.propagate(e);
			}
        }
    }

	/**
	 * Constructor.
	 * @param inputHandler input handler
	 * @param outputHandler output handler
	 * @param parser parser
	 */
    public SingleThreadedWorker(final InputHandler inputHandler,
			final OutputHandler outputHandler, final Parser parser) {
    	this.inputHandler = inputHandler;
    	this.outputHandler = outputHandler;
    	this.parser = parser;
	}

    /**
     * {@inheritDoc}
     */
    public final void addCollector(final Collector collector) {
        if (collectors == null) {
            collectors = new ArrayList<Collector>();
        }
        collectors.add(collector);
    }

    /**
     * {@inheritDoc}
     */
    public final void setCollectors(final List<Collector> collectors) {
        this.collectors = collectors;
    }

    /**
     * {@inheritDoc}
     */
    public final void setOutputHandler(final OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    /**
     * {@inheritDoc}
     */
    public final void setInputHandler(final InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    /**
     * {@inheritDoc}
     */
    public final void setParser(final Parser parser) {
    	this.parser = parser;
    }

	public final InputHandler getInputHandler() {
		return inputHandler;
	}

	public final OutputHandler getOutputHandler() {
		return outputHandler;
	}

	public final Parser getParser() {
		return parser;
	}
}
