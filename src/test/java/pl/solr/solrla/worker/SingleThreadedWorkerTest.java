package pl.solr.solrla.worker;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.junit.Test;

import pl.solr.solrla.collector.MaxQueryTimeCollector;
import pl.solr.solrla.input.ClasspathInputHandler;
import pl.solr.solrla.input.InputHandler;
import pl.solr.solrla.output.OutputHandler;
import pl.solr.solrla.parser.Parser;
import pl.solr.solrla.parser.StandardParser;

public class SingleThreadedWorkerTest {

	@Test
	public void one() throws IOException {
		InputHandler inputHandler = new ClasspathInputHandler();
		inputHandler.setLocation("/log1.log");
		OutputHandler outputHandler = mock(OutputHandler.class);
		Parser parser = new StandardParser();

		SingleThreadedWorker worker = new SingleThreadedWorker(inputHandler, outputHandler, parser);
		worker.addCollector(new MaxQueryTimeCollector());

		worker.run();
	}

}
