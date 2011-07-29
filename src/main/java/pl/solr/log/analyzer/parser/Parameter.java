package pl.solr.log.analyzer.parser;

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
}
