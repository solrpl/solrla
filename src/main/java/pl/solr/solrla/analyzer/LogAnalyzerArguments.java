package pl.solr.solrla.analyzer;

import com.google.common.base.Throwables;

import pl.solr.solrla.input.DirectoryInputHandler;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.ConsoleOutputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;
import pl.solr.solrla.parser.StandardParser;
import pl.solr.solrla.worker.SingleThreadedWorker;
import pl.solr.solrla.worker.Worker;

/**
 * Arguments for log analyzer process.
 *
 * @author Marek Rogoziński
 *
 */
public class LogAnalyzerArguments {

	//TODO: add possibility od setting worker from command line
	//Remember about ordering of setWorker, setInputHandler - can be various. Should get data
	//from old worker to set them in new
	/** class responsible for doing analysis. */ 
	private Worker worker = new SingleThreadedWorker(new DirectoryInputHandler(), new ConsoleOutputHandler(), new StandardParser()); 

	public final InputHandler getInputHandler() {
		return worker.getInputHandler();
	}

	public final OutputHandler getOutputHandler() {
		return worker.getOutputHandler();
	}

	public final Worker getWorker() {
		return worker;
	}

	public final Parser getParser() {
		return worker.getParser();
	}

	public final void setInputHandler(final Class<? extends InputHandler> clazz) {
		try {
			InputHandler inputHandler = clazz.newInstance();
			String loc = worker.getInputHandler().getLocation();
			inputHandler.setLocation(loc);
			worker.setInputHandler(inputHandler);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public void setInputLocation(String location) {
		worker.getInputHandler().setLocation(location);
	}

	public void setOutputHandler(Class<? extends OutputHandler> clazz) {
		try {
			OutputHandler outputHandler = clazz.newInstance();
			String loc = worker.getOutputHandler().getLocation();
			outputHandler.setLocation(loc);
			worker.setOutputHandler(outputHandler);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public void setOutputLocation(String location) {
		worker.getOutputHandler().setLocation(location);
	}

	public void setParser(Class<? extends Parser> clazz) {
		try {
			Parser parser = clazz.newInstance();
			worker.setParser(parser);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

}
