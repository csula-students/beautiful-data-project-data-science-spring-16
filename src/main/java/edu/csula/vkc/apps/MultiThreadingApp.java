package edu.csula.vkc.apps;

import java.util.Collection;

import edu.csula.vkc.models.Make;
import edu.csula.vkc.util.GenericCollector;
import edu.csula.vkc.util.LemonSource;

public class MultiThreadingApp implements Runnable {
	public void run() {
		System.out.println("My thread is in running state.");
		LemonSource source = new LemonSource();
		GenericCollector collector = new GenericCollector();
		try {

			if (source.hasNext()) {
				Collection<Make> carMetadata = source.getData();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void main(String args[]) {
		MultiThreadingApp obj = new MultiThreadingApp();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);
		t1.start();
		t2.start();
		t3.start();
	}
}