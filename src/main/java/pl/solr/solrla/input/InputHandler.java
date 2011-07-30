package pl.solr.solrla.input;

/**
 * Interface for specification of input.
 * @author Marek Rogoziński
 *
 */
public interface InputHandler {

	/** Returns location with input data.
	 * Format of the string depends on concrete implementation.
	 * @return location with input data
	 */
	String getLocation();

	/**
	 * Sets input data location.
	 * @param location input data location
	 */
	void setLocation(String location);

	String getNextItem();

}
