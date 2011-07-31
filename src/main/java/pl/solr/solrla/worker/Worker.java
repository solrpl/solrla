package pl.solr.solrla.worker;

import java.io.IOException;
import java.util.List;

import pl.solr.solrla.collector.Collector;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;

/**
 * Worker interface.
 *
 * @author Marek Rogoziński
 *
 */
public interface Worker {
    /**
     * Add a new collector.
     *
     * @param collector
     *            collector
     */
    void addCollector(Collector collector);

    /**
     * Sets collectors.
     *
     * @param collectors
     *            collectors
     */
    void setCollectors(List<Collector> collectors);

    /**
     * Sets output handler.
     *
     * @param outputHandler
     *            output handler
     */
    void setOutputHandler(OutputHandler outputHandler);

    /**
     * Sets input handler.
     *
     * @param inputHandler
     *            input handler
     */
    void setInputHandler(InputHandler inputHandler);

    /**
     * Returns input handler.
     *
     * @return input handler
     */
    InputHandler getInputHandler();

    /**
     * Returns output handler.
     *
     * @return output handler
     */
    OutputHandler getOutputHandler();

    /**
     * Returns parser.
     *
     * @return parser
     */
    Parser getParser();

    /**
     * Sets parser.
     *
     * @param parser
     *            parser
     */
    void setParser(Parser parser);

    /**
     * Starts the main work.
     */
    void run() throws IOException;
}
