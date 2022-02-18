package ca.jrvs.practice.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class BinarySearch {

	/**
	 * find the the target index in a sorted array
	 *
	 * @param arr input array is sorted
	 * @param target value to be searched
	 * @return target index or Optional.empty() if not found
	 */
	public <E> Optional<Integer> binarySearchRecursion(E[] arr, E target) {

		Comparator<E> compare = new Comparator<E>() {
			@Override
			public int compare(E o1, E o2) {
				String sort1;
				String sort2;
				try {
					sort1 = (String) o1;
					sort2 = (String) o2;
				} catch (Exception e) {
					sort1 = o1.toString();
					sort2 = o2.toString();
				}
				return sort1.compareTo(sort2);
			}
		};
		
		int mid = arr.length / 2;
		
		if (arr.length < 1) {
			return Optional.empty();
		}
		else if (compare.compare(arr[mid], target) == 0) {
			return Optional.of(mid);
		}
		else if (compare.compare(arr[mid], target) < 0) {
			return Optional.of(mid + binarySearchRecursion(Arrays.copyOfRange(arr, mid, arr.length), target).get());
		}
		else if (compare.compare(arr[mid], target) > 0) {
			return binarySearchRecursion(Arrays.copyOfRange(arr, 0, mid), target);
		}
		else {
			return Optional.empty();
		}
	}

	/**
	* find the the target index in a sorted array
	*
	* @param arr input array is sorted
	* @param target value to be searched
	* @return target index or Optional.empty() if not found
	*/
	public <E> Optional<Integer> binarySearchIteration(E[] arr, E target) {
		
		Comparator<E> compare = new Comparator<E>() {
			@Override
			public int compare(E o1, E o2) {
				String sort1;
				String sort2;
				try {
					sort1 = (String) o1;
					sort2 = (String) o2;
				} catch (Exception e) {
					sort1 = o1.toString();
					sort2 = o2.toString();
				}
				return sort1.compareTo(sort2);
			}
		};
		
		int arrStart = 0;
		int arrMid = arr.length / 2;
		int arrEnd = arr.length;
		
		while (arrStart <= arrEnd) {
			int compared = compare.compare(arr[arrMid], target);
			if (compared == 0) {
				return Optional.of(arrMid);
			}
			else if (compared < 0) {
				arrStart = arrMid + 1;
				arrMid = (arrEnd + arrStart) / 2;
			}
			else if (compared > 0) {
				arrEnd = arrMid - 1;
				arrMid = (arrEnd + arrStart) / 2;
			}
			else {
				return Optional.empty();
			}
		}
		return Optional.empty();
	}
}