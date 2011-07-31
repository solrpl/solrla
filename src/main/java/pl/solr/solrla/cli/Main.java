package pl.solr.solrla.cli;

import java.io.IOException;

import pl.solr.solrla.analyzer.LogAnalyzer;
import pl.solr.solrla.analyzer.LogAnalyzerArguments;

/**
 * Main class for usage from command line interface.
 *
 * @author Marek Rogoziński
 *
 */
public final class Main {

	/**
	 * Private constructor for final class.
	 */
	private Main() {

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            command line arguments
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException {
		Main m = new Main();
		m.run(args);
	}

	/**
	 * Parses command line arguments.
	 *
	 * @param args
	 *            command line arguments
	 * @return parameters or null if error
	 */
	private LogAnalyzerArguments parseArgs(final String[] args) {
		CommandLineArgumentParser parser = new CommandLineArgumentParser();
		return parser.parse(args);
	}

	/**
	 * Run analyzers with proper parameters.
	 * @param args command line parameters
	 * @throws IOException 
	 */
	private void run(final String[] args) throws IOException {
		LogAnalyzerArguments params = parseArgs(args);
		if (params != null) {
			LogAnalyzer la = new LogAnalyzer();
			la.run(params);
		}
	}

}
