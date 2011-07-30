package pl.solr.solrla.analyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.solr.solrla.cli.InputHandlerForTesting;
import pl.solr.solrla.cli.OutputHandlerForTesting;

/**
 * Tests for LogAnalyzerArguments.
 *
 * @author Marek Rogoziński
 *
 */
public class LogAnalyzerArgumentsTest {

	/**
	 * Simple test for argument parsing.
	 */
	@Test
	public void simple() {
		LogAnalyzerArguments args = new LogAnalyzerArguments();
		args.setInputHandler(InputHandlerForTesting.class);
		args.setOutputHandler(OutputHandlerForTesting.class);
		args.setInputLocation("/input/loc");
		args.setOutputLocation("/output/loc");

		assertTrue(args.getInputHandler() instanceof InputHandlerForTesting);
		assertTrue(args.getOutputHandler() instanceof OutputHandlerForTesting);
		assertEquals("/input/loc", args.getInputHandler().getLocation());
		assertEquals("/output/loc", args.getOutputHandler().getLocation());
	}

}
