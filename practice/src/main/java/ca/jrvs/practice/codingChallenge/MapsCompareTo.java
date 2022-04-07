package ca.jrvs.practice.codingChallenge;

import java.util.Map;

/**
 * https://www.notion.so/jarvisdev/How-to-compare-two-maps-7207bda24cc5477bb9972d7a8be2a601
 * Online Judge N/A
 */
public class MapsCompareTo {
	
	/**
	 * An algorithm that will compare two maps and if they have a .equals method implemented for types K and V will return if they equal
	 * @param <K>
	 * @param <V>
	 * @param m1
	 * @param m2
	 * @return true if they have the same keys and values
	 */
	public <K,V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2){
		return m1.equals(m2);
	}

}
