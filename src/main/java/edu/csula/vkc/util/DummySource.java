package edu.csula.vkc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.MPG;
import edu.csula.vkc.models.Make;
import edu.csula.vkc.models.Model;
import edu.csula.vkc.models.Price;
import edu.csula.vkc.models.Styles;
import edu.csula.vkc.models.Years;

public class DummySource implements Source<Make> {

	long minId;

	public DummySource(long id) {
		this.minId = id;
	}

	@Override
	public boolean hasNext() {
		return minId > 0;
	}

	@Override
	public Collection<Make> next() {

		List<Styles> listStyles1 = new ArrayList<>();
		Styles style1 = new Styles(12, "MarutiLX", 4, new MPG(11.111, 00000), new Price(111.111, 11111.8899), "car", 2,
				"rear", "10LPg", "hello", "petrol", "MA");
		listStyles1.add(style1);

		List<Years> listyear = new ArrayList<>();
		Years year = new Years(1, "2011", listStyles1);
		listyear.add(year);

		List<Styles> listStyles1a = new ArrayList<>();
		Styles style1a = new Styles(16, "MarutiTX", 4, new MPG(11.111, 00000), new Price(111.111, 2155111), "car", 2,
				"rear", "10LPg", "hii", "Diesel", "MA");
		listStyles1a.add(style1a);

		List<Model> listModels = new ArrayList<>();
		Model model = new Model(11, "Maruti", listyear);
		listModels.add(model);

		Make makes1 = new Make(1, 1, "Maruti", "new", listModels);

		// 2nd
		List<Styles> listStyles2 = new ArrayList<>();
		Styles style2 = new Styles(13, "SwitDesire", 4, new MPG(455.333, 00000), null, "car", 2, "rear", "10LPg",
				"hello", "Diesel", "Sw");
		listStyles2.add(style2);

		List<Years> listyear2 = new ArrayList<>();
		Years year2 = new Years(1, "2016", listStyles2);
		listyear2.add(year2);

		List<Model> listModels2 = new ArrayList<>();
		Model model2 = new Model(14, "Swift", listyear2);
		listModels2.add(model2);

		Make makes2 = new Make(2, 22, "Maruti", "new", listModels2);

		// 3rd
		List<Styles> listStyles3 = new ArrayList<>();
		Styles style3 = new Styles(13, "AudiR8", 4, new MPG(455.333, 00000), new Price(233456678.00054, 344562662),
				"car", 2, "rear", "10LPg", null, "Diesel", "Sw");
		listStyles3.add(style3);

		List<Years> listyear3 = new ArrayList<>();
		Years year3 = new Years(17, "2016", listStyles3);
		listyear3.add(year3);

		List<Model> listModels3 = new ArrayList<>();
		Model model3 = new Model(18, "Audi", listyear3);
		listModels3.add(model3);

		Make makes3 = new Make(3, 33, "Audi", "new", listModels3);

		// 4rd
		List<Styles> listStyles4 = new ArrayList<>();
		Styles style4 = new Styles(13, "Ferrari", 4, new MPG(455.333, 00000), null, "car", 2, "rear", "10LPg",
				"heelloo", "Diesel", "Sw");
		listStyles4.add(style4);

		List<Years> listyear4 = new ArrayList<>();
		Years year4 = new Years(17, "2016", listStyles4);
		listyear4.add(year4);

		List<Model> listModels4 = new ArrayList<>();
		Model model4 = new Model(18, "Ferrari", listyear4);
		listModels4.add(model4);

		Make makes4 = new Make(4, 44, "Ferrari", "new", listModels4);

		// 5rd
		List<Styles> listStyles5 = new ArrayList<>();
		Styles style5 = new Styles(17654, "WagaonR", 4, new MPG(455.333, 00000), null, "car", 2, "rear", "10LPg",
				"heelloo", "Diesel", "Sw");
		listStyles5.add(style5);

		List<Years> listyear5 = new ArrayList<>();
		Years year5 = new Years(17546, "2016", listStyles5);
		listyear5.add(year5);

		List<Model> listModels5 = new ArrayList<>();
		Model model5 = new Model(184567, "Maruti", listyear5);
		listModels5.add(model5);

		Make makes5 = new Make(5, 55, "Maruti", "old", listModels5);

		// 6rd
		List<Styles> listStyles6 = new ArrayList<>();
		Styles style6 = new Styles(17654, "JeepLX", 4, new MPG(455.333, 00000), new Price(233456678.00054, 344562662),
				null, 2, "rear", "10LPg", "heelloo", "Diesel", "Je");
		listStyles6.add(style6);

		List<Years> listyear6 = new ArrayList<>();
		Years year6 = new Years(17987, "2013", listStyles6);
		listyear6.add(year6);

		List<Model> listModels6 = new ArrayList<>();
		Model model6 = new Model(18567, "Jeep", listyear6);
		listModels6.add(model6);

		Make makes6 = new Make(6, 66, "Jeep", "old", listModels6);

		List<Make> makesall = new ArrayList<>();
		makesall.add(makes6);
		makesall.add(makes5);
		makesall.add(makes4);
		makesall.add(makes3);
		makesall.add(makes2);
		makesall.add(makes1);

		return makesall;

	}

}
