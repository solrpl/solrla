package pl.solr.solrla.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.solr.solrla.analyzer.parser.LogLine;
import pl.solr.solrla.input.InputHandler;
import static org.mockito.Mockito.*;

public class StandardParserTest {
	private StandardParser parser = new StandardParser();

	@Test
	public void first() {
		InputHandler m = mock(InputHandler.class);
		//TODO
		//LogLine line = parser.readLine();
		//assertNotNull(line);
	}

}
