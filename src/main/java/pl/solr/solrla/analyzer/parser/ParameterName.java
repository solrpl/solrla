package pl.solr.solrla.analyzer.parser;

/**
 * Query parameter name.
 * 
 * @author Rafał Kuć
 * 
 */
public enum ParameterName {
    Q("q", false), FQ("fq", true), QF("qf", false), BF("bf", false), PF("pf",
            false), MM("mm", false), START("start", false), ROWS("rows", false), DEFTYPE(
            "defType", false), FACET("facet", false), FACETFIELD("facet.field",
            true), FACETQUERY("facet.query", true), FACETRANGE("facet.range",
            true), FACETDATE("facet.date", true), GROUP("group", false), GROUPFIELD(
            "group.field", false), UNKNOWN("", true);

    /**
     * Constructor.
     * 
     * @param name
     *            name in the log file
     * @param multiple
     *            can be multuiple
     */
    private ParameterName(String name, Boolean multiple) {
        this.logName = name;
        this.multiple = multiple;
    }

    /** Log name. */
    private String logName;

    /** Can be multiple. */
    private Boolean multiple;

    public final String getLogName() {
        return logName;
    }

    public final Boolean isMultiple() {
        return multiple;
    }
}
