package pl.solr.solrla.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.solr.solrla.analyzer.LogAnalyzerArguments;
import pl.solr.solrla.input.DirectoryInputHandler;
import pl.solr.solrla.output.ConsoleOutputHandler;

public class CommandLineArgumentParserTest {
	private CommandLineArgumentParser parser = new CommandLineArgumentParser();

	@Test
	public void noArgs() {
		assertNull(parser.parse(new String[]{}));
	}

	@Test
	public void simple() {
		LogAnalyzerArguments args = parser.parse(new String[]{"--input",  "/tmp"});
		assertNotNull(args);
		assertTrue(args.getInputHandler() instanceof DirectoryInputHandler);
		assertEquals("/tmp", args.getInputHandler().getLocation());
		assertTrue(args.getOutputHandler() instanceof ConsoleOutputHandler);
	}

}
