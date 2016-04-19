package study.leet.sort.crack;

import java.util.Random;

public class SortTest  {
	  private int[] numbers;
	  private int number;

	  public void sort(int[] values) {
	    // check for empty or null array
	    if (values ==null || values.length==0){
	      return;
	    }
	    this.numbers = values;
	    number = values.length;
	    quicksort(0, number - 1);
	  }

	  private void quicksort(int low, int high) {
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    int pivot = numbers[low + (high-low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (numbers[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (numbers[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i <= j) {
	    	  if (i < j) {
	    		  exchange(i, j);
			}
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  private void exchange(int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	  }
	  public static void main(String[] args) {
		  int num = 10000;
			int[] unsorted = new int[num];
			for (int i = 0; i < num; i++) {
				unsorted[i] = new Random().nextInt(1000000000);
			}
			//int[] unsorted = {4,3,5,6,7,4,2,1,3,2,4};
			SortTest sortTest = new SortTest();
			sortTest.sort(unsorted);
			for (int i : unsorted) {
				System.out.println(i);
			}
	}
	} 
