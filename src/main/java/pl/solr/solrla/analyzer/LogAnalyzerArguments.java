package pl.solr.solrla.analyzer;

import com.google.common.base.Throwables;

import pl.solr.solrla.input.DirectoryInputHandler;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.ConsoleOutputHandler;
import pl.solr.solrla.output.OutputHandler;


public class LogAnalyzerArguments {
	private InputHandler inputHandler = new DirectoryInputHandler();
	private OutputHandler outputHandler = new ConsoleOutputHandler();

	public InputHandler getInputHandler() {
		return inputHandler;
	}

	public OutputHandler getOutputHandler() {
		return outputHandler;
	}

	public void setInputHandler(Class<InputHandler> clazz) {
		try {
			inputHandler = clazz.newInstance();
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public void setInputLocation(String location) {
		inputHandler.setLocation(location);
	}

	public void setOutputHandler(Class<OutputHandler> clazz) {
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
