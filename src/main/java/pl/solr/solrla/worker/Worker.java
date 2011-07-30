package pl.solr.solrla.worker;

import java.util.List;

import pl.solr.solrla.collector.Collector;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;

public interface Worker {

	/** 
	 * Add a new collector. 
	 * @param collector collector
	 */
	void addCollector(Collector collector);

	void setCollectors(List<Collector> collectors);

	void setOutputHandler(OutputHandler outputHandler);

	void setInputHandler(InputHandler inputHandler);

	InputHandler getInputHandler();

	OutputHandler getOutputHandler();

	Parser getParser();

	void setParser(Parser parser);

}