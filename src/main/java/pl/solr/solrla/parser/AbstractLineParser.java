package pl.solr.solrla.parser;

import java.io.BufferedReader;
import java.io.IOException;

import pl.solr.solrla.analyzer.parser.LogLine;

public abstract class AbstractLineParser implements Parser {

	public LogLine readLine(BufferedReader stream) throws IOException {
		String line;
		while ((line = stream.readLine()) != null) {
			LogLine parsed = parseLine(line);
			if (parsed != null) {
				return parsed;
			}
		}
		return null;
	}
	
	abstract LogLine parseLine(String line);
}
