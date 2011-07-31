package pl.solr.solrla.worker;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.InputStream;

import org.junit.Test;

import pl.solr.solrla.analyzer.parser.impl.SimpleLogLine;
import pl.solr.solrla.input.ClasspathInputHandler;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;
import pl.solr.solrla.parser.StandardParser;

public class SingleThreadedWorkerTest {

	@Test
	public void one() {
		InputHandler inputHandler = new ClasspathInputHandler();
		inputHandler.setLocation("/log1.log");
		OutputHandler outputHandler = mock(OutputHandler.class);
		Parser parser = new StandardParser();

		SingleThreadedWorker worker = new SingleThreadedWorker(inputHandler, outputHandler, parser);

		worker.run();
	}

}
