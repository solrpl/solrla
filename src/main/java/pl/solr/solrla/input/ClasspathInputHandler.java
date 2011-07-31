package pl.solr.solrla.input;

import java.io.InputStream;

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
	public final InputStream nextStream() {
		if (!called) {
			called = true;
			return ClasspathInputHandler.class.getResourceAsStream(getLocation());
		}
		return null;
	}

}
