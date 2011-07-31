package pl.solr.solrla.input;

public abstract class AbstractInputHandler implements InputHandler {
	/** location of input data. */
	private String location;

	public final String getLocation() {
		return location;
	}

	public final void setLocation(final String location) {
		this.location = location;
	}

}
