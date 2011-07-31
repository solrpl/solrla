package pl.solr.solrla.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Input handler for reading log files from classpath.
 * Mainly for testing.
 *
 * @author Marek Rogoziński
 *
 */
public class ClasspathInputHandler extends AbstractInputHandler {
	/** indicate stream was already processed. */
	private boolean called = false;

	/**
	 * {@inheritDoc}
	 */
	public final BufferedReader nextStream() {
		if (!called) {
			called = true;
			return new BufferedReader(
					new InputStreamReader(
							ClasspathInputHandler.class
								.getResourceAsStream(getLocation())));
		}
		return null;
	}

}
