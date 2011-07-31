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

	/**
	 * {@inheritDoc}
	 */
	public final InputStream nextStream() {
		return ClasspathInputHandler.class.getResourceAsStream(getLocation());
	}

}
