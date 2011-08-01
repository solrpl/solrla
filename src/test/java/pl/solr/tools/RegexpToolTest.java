package pl.solr.tools;

import static org.junit.Assert.*;
import org.junit.Test;

public class RegexpToolTest {

	@Test
	public void beanSetter() {
		Bean bean = new Bean();
		boolean result = RegexpTool.applyRegexp("input 1234 foobar",
				"(\\w+) (\\d+) (\\w+)", new String[] {"name", "number", "rest"}, bean);
		assertTrue(result);
		assertEquals("input", bean.getName());
		assertEquals(1234, bean.getNumber());
		assertEquals("foobar", bean.getRest());
	}

	public class Bean {
		private String name;
		private int number;
		private String rest;

		public final String getName() {
			return name;
		}
		public final int getNumber() {
			return number;
		}
		public final String getRest() {
			return rest;
		}
		public final void setName(final String name) {
			this.name = name;
		}
		public final void setNumber(final int number) {
			this.number = number;
		}
		public final void setRest(final String rest) {
			this.rest = rest;
		}
	}
}
