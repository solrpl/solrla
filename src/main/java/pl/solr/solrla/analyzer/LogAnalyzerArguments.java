package pl.solr.solrla.analyzer;

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

	public void setInputHandler(String className) {
		// TODO Auto-generated method stub

	}

	public void setInputLocation(String location) {
		inputHandler.setLocation(location);
	}

}
