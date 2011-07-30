package pl.solr.solrla.collector.result;

/** 
 * String collecting result implementation of {@link CollectingResult}.
 * 
 * @author Rafał Kuć
 *
 */
public class StringCollectingResult implements CollectingResult {
    /** Result. */
    private String result;
    
    /** 
     * Constructor. 
     * @param result result
     */
    public StringCollectingResult(Object result) {
        this.result = result.toString();
    }
    
    /**
     * {@inheritDoc}
     */
    public String getAsString() {
        return result;
    }
}
