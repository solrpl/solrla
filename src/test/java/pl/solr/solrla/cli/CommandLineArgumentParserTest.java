package pl.solr.solrla.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.solr.solrla.analyzer.LogAnalyzerArguments;
import pl.solr.solrla.input.DirectoryInputHandler;
import pl.solr.solrla.output.ConsoleOutputHandler;

/**
 * Tests for CLI arguments parsing.
 *
 * @author Marek Rogoziński
 *
 */
public class CommandLineArgumentParserTest {
	/** parser instance. */
	private CommandLineArgumentParser parser = new CommandLineArgumentParser();

	/**
	 * Parsing without parameters.
	 */
	@Test
	public final void noArgs() {
		assertNull(parser.parse(new String[]{}));
	}

	/**
	 * Default parameters.
	 */
	@Test
	public final void simple() {
		LogAnalyzerArguments args = parser.parse(new String[]{"--input",  "/tmp"});
		assertNotNull(args);
		assertTrue(args.getInputHandler() instanceof DirectoryInputHandler);
		assertEquals("/tmp", args.getInputHandler().getLocation());
		assertTrue(args.getOutputHandler() instanceof ConsoleOutputHandler);
	}

	/**
	 * Input handler given.
	 */
	@Test
	public final void withInputHandler() {
		LogAnalyzerArguments args = parser.parse(new String[]{
				"--input",  "/tmp",
				"--inputHandler", "pl.solr.solrla.cli.InputHandlerForTesting" });
		assertNotNull(args);
		assertTrue(args.getInputHandler() instanceof InputHandlerForTesting);
		assertEquals("/tmp", args.getInputHandler().getLocation());
		assertTrue(args.getOutputHandler() instanceof ConsoleOutputHandler);
		assertNull(args.getOutputHandler().getLocation());
	}

	/**
	 * Output handler given.
	 */
	@Test
	public final void withOutputHandler() {
		LogAnalyzerArguments args = parser.parse(new String[]{
				"--input",  "/tmp",
				"--outputHandler", "pl.solr.solrla.cli.OutputHandlerForTesting" ,
				"--output", "STDOUT" });
		assertNotNull(args);
		assertTrue(args.getInputHandler() instanceof DirectoryInputHandler);
		assertEquals("/tmp", args.getInputHandler().getLocation());
		assertTrue(args.getOutputHandler() instanceof OutputHandlerForTesting);
		assertEquals("STDOUT", args.getOutputHandler().getLocation());
	}

}
