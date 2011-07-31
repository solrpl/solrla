package pl.solr.solrla.analyzer;

import java.io.IOException;

public class LogAnalyzer {

	public void run(final LogAnalyzerArguments params) throws IOException {
		params.getWorker().run();
	}

}
