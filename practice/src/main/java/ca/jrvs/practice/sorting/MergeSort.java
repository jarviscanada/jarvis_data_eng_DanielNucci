package ca.jrvs.practice.sorting;

public class MergeSort {
	
	public void mergeSort(int[] arr, int length) {
		if (length < 2) {
			return;
		}
		
		int mid = length / 2;
		int[] leftArr = new int[mid];
		int[] rightArr = new int[length - mid];
		
		for (int i = 0; i < mid; i++) {
			leftArr[i] = arr[i];
		}
		for (int i = mid; i < length; i++) {
			rightArr[i - mid] = arr[i];
		}
		
		mergeSort(leftArr, mid);
		mergeSort(rightArr, length - mid);
		
		merge(arr, leftArr, rightArr, mid, length - mid);
	}
	
	private void merge(int[] resultArr, int[] leftArr, int[] rightArr, int left, int right) {
		int lIndex = 0, rIndex = 0, resIndex = 0;
		
		while (lIndex < left && rIndex < right) {
			if (leftArr[lIndex] <= rightArr[rIndex]) {
				resultArr[resIndex++] = leftArr[lIndex++];
			} 
			else {
				resultArr[resIndex++] = rightArr[rIndex++];
			}
		}
		while (lIndex < left) {
			resultArr[resIndex++] = leftArr[lIndex++];
		}
		while (rIndex < right) {
			resultArr[resIndex++] = rightArr[rIndex++];
		}
	}
}
