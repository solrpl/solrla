package pl.solr.solrla.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import pl.solr.solrla.analyzer.LogAnalyzer;
import pl.solr.solrla.analyzer.LogAnalyzerArguments;

/**
 * Main class for usage from command line interface.
 * 
 * @author Marek Rogoziński
 * 
 */
public class Main {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(final String[] args) {
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
	protected LogAnalyzerArguments parseArgs(final String[] args) {
		CommandLineArgumentParser parser = new CommandLineArgumentParser();
		return parser.parse(args);
	}

	protected void run(final String[] args) {
		LogAnalyzerArguments params = parseArgs(args);
		if (params != null) {
			LogAnalyzer la = new LogAnalyzer(params);
			la.run();
		}
	}

}
