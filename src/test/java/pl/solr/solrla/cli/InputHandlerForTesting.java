package pl.solr.solrla.cli;

import pl.solr.solrla.input.InputHandler;

/**
 * Trivial implementation of input handler for testing.
 *
 * @author Marek Rogoziński
 *
 */
public class InputHandlerForTesting implements InputHandler {
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
