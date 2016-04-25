package edu.csula.datascience.acquisition;

import com.google.common.collect.Lists;

import edu.csula.vkc.models.Make;
import edu.csula.vkc.models.Model;
import edu.csula.vkc.models.Price;
import edu.csula.vkc.models.Styles;
import edu.csula.vkc.models.Years;
import edu.csula.vkc.util.DummySource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * A test case to show how to use Collector and Source
 */
public class CollectorTest {
	private Collector<SimpleModel, MockData> collector;
	private Source<MockData> source;

	@Before
	public void setup() {
		collector = new MockCollector();
		source = new MockSource();
	}

	@Test
	public void mungee() throws Exception {
		List<SimpleModel> list = (List<SimpleModel>) collector.mungee(source.next());
		List<SimpleModel> expectedList = Lists.newArrayList(new SimpleModel("2", "content2"),
				new SimpleModel("3", "content3"));

		Assert.assertEquals(list.size(), 2);

		for (int i = 0; i < 2; i++) {
			Assert.assertEquals(list.get(i).getId(), expectedList.get(i).getId());
			Assert.assertEquals(list.get(i).getContent(), expectedList.get(i).getContent());
		}
	}

}