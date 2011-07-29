package pl.solr.solrla.analyzer.parser;

import java.util.Date;
import java.util.List;

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
     * Return list of query parameters. 
     * @return query parameters list
     */
    List<Parameter> parameters();
    
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
}
