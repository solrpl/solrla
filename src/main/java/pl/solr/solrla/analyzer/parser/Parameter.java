package pl.solr.solrla.analyzer.parser;

import java.util.List;

/** 
 * Query parameter. 
 * 
 * @author Rafał Kuć
 *
 */
public interface Parameter {
    /** 
     * Return parameter name.
     * @return parameter name
     */
    ParameterName getName();
    
    /** 
     * Return the parameter value as string.
     * @return parameter value as string
     */
    String getValue();
    
    /** 
     * Adds value of the parameter. 
     * @param value value
     */
    void addValue(String value);
    
    /** 
     * Return the parameter values. 
     * @return list of values or empty list
     */
    List<String> getValues();
}
