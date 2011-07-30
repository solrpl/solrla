package pl.solr.solrla.analyzer;

import com.google.common.base.Throwables;

import pl.solr.solrla.input.DirectoryInputHandler;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.ConsoleOutputHandler;
import pl.solr.solrla.output.OutputHandler;

/**
 * Arguments for log analyzer process.
 *
 * @author Marek Rogoziński
 *
 */
public class LogAnalyzerArguments {
	/** class responsible for resolve and fetch input data. */
	private InputHandler inputHandler = new DirectoryInputHandler();

	/** class responsible for write results. */
	private OutputHandler outputHandler = new ConsoleOutputHandler();

	//TODO class responsible for parsing. -parser in command line

	public final InputHandler getInputHandler() {
		return inputHandler;
	}

	public final OutputHandler getOutputHandler() {
		return outputHandler;
	}

	public final void setInputHandler(final Class<? extends InputHandler> clazz) {
		try {
			inputHandler = clazz.newInstance();
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public void setInputLocation(String location) {
		inputHandler.setLocation(location);
	}

	public void setOutputHandler(Class<? extends OutputHandler> clazz) {
		try {
			outputHandler = clazz.newInstance();
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public void setOutputLocation(String location) {
		outputHandler.setLocation(location);
	}

}
