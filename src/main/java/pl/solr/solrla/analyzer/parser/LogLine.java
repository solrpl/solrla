package pl.solr.solrla.analyzer.parser;

import java.util.Date;
import java.util.Map;

/** 
 * Line of log.
 * 
 * @author Rafał Kuć
 *
 */
public interface LogLine {
    /** 
     * Return number of hits.
     * @return number of hits
     */
    Integer hits();
    
    /** 
     * Return query execution time.
     * @return query execution time
     */
    Long time();
    
    /** 
     * Return map of query parameters. 
     * @return query parameters map
     */
    Map<ParameterName, Parameter> parameters();
    
    /** 
     * Return core name.
     * @return core name or <code>null</code> for a single core instance
     */
    String coreName();
    
    /** 
     * Return query date.
     * @return query date
     */
    Date queryTime();
    
    /** 
     * Returns full query.
     * @return full query
     */
    String query();
    
    /** 
     * Adds parameter. 
     * @param name parameter name
     * @param value parameter value
     */
    void addParameter(ParameterName name, String value);
}
