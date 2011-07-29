package pl.solr.solrla.output;

public class ConsoleOutputHandler implements OutputHandler {
	private String location;

	public void setLocation(final String location) {
		this.location = location;
	}

	public final String getLocation() {
		return location;
	}

}
