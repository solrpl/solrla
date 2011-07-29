package pl.solr.solrla.analyzer.parser.impl;

import java.util.ArrayList;
import java.util.List;

import pl.solr.solrla.analyzer.parser.ParameterName;

/** 
 * Single name, multiple values parameter. 
 * 
 * @author Rafał Kuć
 *
 */
public class NameValuesParameter extends NameValueParameter {
    /** Values. */
    List<String> values = new ArrayList<String>();
    
    /** 
     * Constructor. 
     * @param name parameter name
     */
    public NameValuesParameter(ParameterName name) {
        super(name);
    }
    
    /** 
     * {@inheritDoc}
     */
    @Override
    public void addValue(String value) {
        values.add(value);
    }
    
    /**
     * {@inheritDoc}
     */
    public ParameterName getName() {
        return super.getName();
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getValues() {
        return values;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getValue() {
        StringBuffer buffer = new StringBuffer();
        for (String value : values) {
            buffer.append(value).append(" ");
        }
        return buffer.toString().trim();
    }
}
