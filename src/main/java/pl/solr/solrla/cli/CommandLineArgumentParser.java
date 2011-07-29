package pl.solr.solrla.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import pl.solr.solrla.analyzer.LogAnalyzerArguments;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;

/**
 * Parser for command line parameters.
 *
 * @author Marek Rogoziński
 *
 */
@SuppressWarnings("static-access")
public class CommandLineArgumentParser {
	/** command line options. */
	private final Options options = new Options();

	 {
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("parser")
							.hasArg()
							.withType(Class.class)
							.withDescription("parser used to process input data")
							.create());
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("inputHandler")
							.hasArg()
							.withType(Class.class)
							.withDescription("handler used to read input")
							.create());
		options.addOption(OptionBuilder
							.withArgName("class")
							.withLongOpt("outputHandler")
							.hasArg()
							.withType(Class.class)
							.withDescription("handler used to write output")
							.create());
		options.addOption(OptionBuilder
				.withArgName("location")
				.withLongOpt("input")
				.hasArg()
				.withType(String.class)
				.withDescription("location of input data")
				.isRequired()
				.create());
		options.addOption(OptionBuilder
				.withArgName("location")
				.withLongOpt("output")
				.hasArg()
				.withType(String.class)
				.withDescription("location for output")
				.create());
	}

	public final LogAnalyzerArguments parse(final String[] args) {
		CommandLineParser parser = new GnuParser();
		try {
			CommandLine commandLine = parser.parse(options, args);
			LogAnalyzerArguments laa = new LogAnalyzerArguments();
			if (commandLine.hasOption("inputHandler")) {
				@SuppressWarnings("unchecked")
				Class<InputHandler> cl =
					(Class<InputHandler>) commandLine.getParsedOptionValue("inputHandler");
				laa.setInputHandler(cl);
			}
			laa.setInputLocation(commandLine.getOptionValue("input"));
			if (commandLine.hasOption("outputHandler")) {
				@SuppressWarnings("unchecked")
				Class<OutputHandler> cl =
					(Class<OutputHandler>) commandLine.getParsedOptionValue("outputHandler");
				laa.setOutputHandler(cl);
			}
			if (commandLine.hasOption("output")) {
				laa.setOutputLocation(commandLine.getOptionValue("output"));
			}
			return laa;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			help();
		}
		return null;
	}

	private void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar <archive_name>", options, true);
	}

}
