package pl.solr.solrla.analyzer;

import java.io.IOException;

import org.junit.Test;

import pl.solr.solrla.cli.CommandLineArgumentParser;

/**
 * First group of tests.
 *
 * @author Marek Rogoziński
 *
 */
public class LogAnalyzer1Test {
	private LogAnalyzer analyzer = new LogAnalyzer();

	@Test
	public void one() throws IOException {
		//TODO capture result & validation
		LogAnalyzerArguments args = new CommandLineArgumentParser().parse(new String[]{
				"--input",  "/log1.log",
				"--inputHandler", "pl.solr.solrla.input.ClasspathInputHandler"
				});
		analyzer.run(args);
	}
}
