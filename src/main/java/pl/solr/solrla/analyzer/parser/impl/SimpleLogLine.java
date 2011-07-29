package pl.solr.solrla.analyzer.parser.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.analyzer.parser.Parameter;
import pl.solr.solrla.analyzer.parser.ParameterName;

/** 
 * Log line implementation {@link LogLine}.
 * 
 * @author Rafał Kuć
 *
 */
public class SimpleLogLine implements LogLine {
    /** Hits. */
    private Integer hits;
    
    /** Query execution time. */
    private Long time;
    
    /** Query run time. */
    private Date queryTime;
    
    /** Full query from log. */
    private String query;
    
    /** Core name. */
    private String core;
    
    /** Parameters. */
    private Map<ParameterName, Parameter> parameters = new HashMap<ParameterName, Parameter>();
    
    /** 
     * {@inheritDoc}
     */
    public Integer hits() {
        return hits;
    }

    /** 
     * {@inheritDoc}
     */
    public Long time() {
        return time;
    }

    /** 
     * {@inheritDoc}
     */
    public Map<ParameterName, Parameter> parameters() {
        return parameters;
    }

    /** 
     * {@inheritDoc}
     */
    public String coreName() {
        return core;
    }

    /** 
     * {@inheritDoc}
     */
    public Date queryTime() {
        return queryTime;
    }

    /** 
     * {@inheritDoc}
     */
    public String query() {
        return query;
    }

    /**
     * {@inheritDoc}
     */
    public void addParameter(ParameterName name, String value) {
        if (parameters.containsKey(name)) {
            Parameter parameter = parameters.get(name);
            parameter.addValue(value);
        } else {
            Parameter parameter;
            if (name.isMultiple()) {
                parameter = new NameValuesParameter(name);
            } else {
                parameter = new NameValueParameter(name);
            }
            parameter.addValue(value);
            parameters.put(name, parameter);
        }
    }
    
    public final void setHits(Integer hits) {
        this.hits = hits;
    }

    public final void setTime(Long time) {
        this.time = time;
    }

    public final void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }
    
    public final void setQuery(String query) {
        this.query = query;
    }

    public final void setCore(String core) {
        this.core = core;
    }
}
