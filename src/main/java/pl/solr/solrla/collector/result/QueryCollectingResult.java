package pl.solr.solrla.collector.result;

/**
 * Query collecting result.
 * 
 * @author Rafał Kuć
 * 
 */
public class QueryCollectingResult implements CollectingResult {
    /** Query. */
    private String query;

    /** Query execution time. */
    private Long queryTime;

    /**
     * Constructor.
     * 
     * @param query
     *            query
     * @param queryTime
     *            query execution time
     */
    public QueryCollectingResult(String query, Long queryTime) {
        super();
        this.query = query;
        this.queryTime = queryTime;
    }

    public final String getQuery() {
        return query;
    }

    public final Long getQueryTime() {
        return queryTime;
    }

    /**
     * {@inheritDoc}
     */
    public String getAsString() {
        return queryTime + "[" + query + "]";
    }
}
