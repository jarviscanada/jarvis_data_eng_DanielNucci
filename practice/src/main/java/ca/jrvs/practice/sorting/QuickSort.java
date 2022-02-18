package ca.jrvs.practice.sorting;

public class QuickSort {
	public void quickSort(int arr[], int start, int end) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			
			quickSort(arr, start, partitionIndex - 1);
		    quickSort(arr, partitionIndex + 1, end);
		}
	}
	
	private int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int index = start - 1;
		
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				index++;
				int swap = arr[index];
				arr[index] = arr[i];
				arr[i] = swap;
			}
		}
		int swap = arr[index + 1];
		arr[index + 1] = arr[end];
		arr[end] = swap;
		return index + 1;
	}
}
