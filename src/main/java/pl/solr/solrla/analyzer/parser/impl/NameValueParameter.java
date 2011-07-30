package pl.solr.solrla.analyzer.parser.impl;

import java.util.Collections;
import java.util.List;

import pl.solr.solrla.analyzer.parser.Parameter;
import pl.solr.solrla.analyzer.parser.ParameterName;

/**
 * Name value parameter implementation. 
 * 
 * @author Rafał Kuć
 * 
 */
public class NameValueParameter implements Parameter {
    /** Parameter name. */
    private ParameterName name;

    /** Parameter value. */
    private String value;

    /**
     * Constructor.
     * 
     * @param name
     *            parameter name
     */
    public NameValueParameter(ParameterName name) {
        super();
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    public void addValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    public ParameterName getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getValues() {
        return Collections.emptyList();
    }
}
