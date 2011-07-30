package pl.solr.solrla.input;

/**
 * Directory implementation of data source.
 *
 * @author Marek Rogoziński
 *
 */
public class DirectoryInputHandler implements InputHandler {
	/** filesystem location, for example: /home/solr/logs/*.log. */
	private String location;

	/**
	 * {@inheritDoc}
	 */
	public final String getLocation() {
		return location;
	}

	/**
	 * {@inheritDoc}
	 */
	public final void setLocation(final String location) {
		this.location = location;

	}

	public String getNextItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
