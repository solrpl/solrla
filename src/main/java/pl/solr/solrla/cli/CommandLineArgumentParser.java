package pl.solr.solrla.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import pl.solr.solrla.analyzer.LogAnalyzerArguments;

@SuppressWarnings("static-access")
public class CommandLineArgumentParser {
	/** command line options. */
	private static final Options options = new Options();

	static {
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("parser")
							.hasArgs()
							.withDescription("parser used to process input data")
							.create());
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("inputHandler")
							.hasArgs()
							.withDescription("handler used to read input")
							.create());
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("outputHandler")
							.hasArgs()
							.withDescription("handler used to write output")
							.create());
		options.addOption(OptionBuilder
				.withArgName("location")
				.withLongOpt("input")
				.hasArgs()
				.withDescription("location of input data")
				.isRequired()
				.create());
		options.addOption(OptionBuilder
				.withArgName("location")
				.withLongOpt("output")
				.hasArgs()
				.withDescription("location for output")
				.create());
	}

	public LogAnalyzerArguments parse(final String[] args) {
		CommandLineParser parser = new PosixParser();
		try {
			CommandLine commandLine = parser.parse(options, args);
			//TODO
		} catch (ParseException e) {
			System.err.println("Error: " + e.getMessage());
			help();
		}
		return null;
	}

	private void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "java -jar <archive_name>", options, true );
	}

}
