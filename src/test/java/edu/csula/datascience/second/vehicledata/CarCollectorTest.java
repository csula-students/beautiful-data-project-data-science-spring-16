package edu.csula.datascience.second.vehicledata;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.csula.vkc.second.models.Make;
import edu.csula.vkc.second.util.GenericCollector;

public class CarCollectorTest {

	private GenericCollector collector;
	private MockCar source;

	@Before
	public void setup() {
		collector = new GenericCollector();
		source = new MockCar();
	}

	@Test
	public void testcase() {

		if (source.hasNext()) {
			Collection<Make> dummyData = source.next();
			Assert.assertEquals(dummyData.size(), 6);

			Collection<Make> cleanedDummyData = collector.mungee(dummyData);
			// collector.save(cleanedDummyData);

			Assert.assertEquals(cleanedDummyData.size(), 3);

		}
	}

}
