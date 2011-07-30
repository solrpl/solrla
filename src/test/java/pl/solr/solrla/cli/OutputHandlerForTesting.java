package pl.solr.solrla.cli;

import pl.solr.solrla.output.OutputHandler;

/**
 * Trivial implementation of output handler for testing.
 *
 * @author Marek Rogoziński
 *
 */
public class OutputHandlerForTesting implements OutputHandler {
	private String location;

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

}
