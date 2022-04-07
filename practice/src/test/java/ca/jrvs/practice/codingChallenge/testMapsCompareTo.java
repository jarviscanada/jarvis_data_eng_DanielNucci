package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class testMapsCompareTo {
	
	@Test
	void testMapsCompareToExample1() {
		MapsCompareTo mct = new MapsCompareTo();
		
		Map<String, String> captitalCities1 = new HashMap<String, String>();
		Map<String, String> captitalCities2 = new HashMap<String, String>();
		
		assertTrue(mct.compareMaps(captitalCities1, captitalCities2));
	}
	
	@Test
	void testMapsCompareToExample2() {
		MapsCompareTo mct = new MapsCompareTo();
		
		Map<String, String> captitalCities1 = new HashMap<String, String>();
		Map<String, String> captitalCities2 = new HashMap<String, String>();
		
		captitalCities1.put("Ontario", "Toronto");
		captitalCities1.put("Texas", "Austin");
		
		captitalCities2.put("Texas", "Austin");
		captitalCities2.put("Ontario", "Toronto");
		
		assertTrue(mct.compareMaps(captitalCities1, captitalCities2));
	}

	@Test
	void testMapsCompareToExample3() {
		MapsCompareTo mct = new MapsCompareTo();
		
		Map<String, String> captitalCities1 = new HashMap<String, String>();
		Map<String, String> captitalCities2 = new HashMap<String, String>();
		
		captitalCities1.put("Ontario", "Toronto");
		captitalCities1.put("Texas", "Austin");
		
		captitalCities2.put("Texas", "Austin");
		captitalCities2.put("Quebec", "Quebec City");
		
		assertFalse(mct.compareMaps(captitalCities1, captitalCities2));
	}
	
}
