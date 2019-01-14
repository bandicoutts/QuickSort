class QuickSort {

	/* Swap function and assistance with sort function from jayeshsolanki93's QuickSort.java on Github.
	Also used mycodeschool's video on QuickSort to understand the theory behind QuickSort.

	The main intention behind this exercise was to practice recursion, abstraction and get a better understanding of
	the time complexity of QuickSort, which is the reason for the returnTime function used below.
	 */


	private static int[] generateArray() {
		int[] array = new int[10];
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random() * 10000);
		}
		System.out.println(array);
		return array;
	}

	private static long returnTime() {
		// returnTime was used to measure the amount of time taken to compute n number of swaps within the array.
		return System.nanoTime();
	}

	private static int partition(int arrayOfIntegers[], int start, int end){
		/* Partition will select the value stored in the last index in arrayOfIntegers,
		then iterate through arrayOfIntegers. If the value stored at index i in array arrayOfIntegers is equal
		to or bigger than the value stored in pivot (the value at the last index), it will move the smaller value
		to the left of the pivot value. Once that's done, the value stored at pIndex will be swapped with the end,
		which allows us to split the array into smaller pieces.
		 */

		int pivot = arrayOfIntegers[end];
		int pIndex = start;
		for (int i = start; i < end; i++){
			if (arrayOfIntegers[i] <= pivot){
				swap(arrayOfIntegers, i, pIndex);
				pIndex++;
			}
		}
		swap(arrayOfIntegers, pIndex, end);
		return pIndex;
	}

	private static void sort(int arrayOfIntegers[], int start, int end){
		/* If the start value is smaller than the end value (i.e. if there's anything in the array)
		then it will send the array up to partition to do it's magic. partition then returns a value which
		is used in sort to call partition again which splits the array into a smaller piece around a new pivot.
		 */


		if (start < end) {
			int pIndex = partition(arrayOfIntegers, start, end);
			sort(arrayOfIntegers, start, pIndex - 1);
			sort(arrayOfIntegers, pIndex + 1, end);
		}
	}

	private static void swap(int arrayOfIntegers[], int i, int j) {
		int temp = arrayOfIntegers[i];
		arrayOfIntegers[i] = arrayOfIntegers[j];
		arrayOfIntegers[j] = temp;
	}


	private static void printArray(int arrayOfIntegers[]){
		int lengthOfArray = arrayOfIntegers.length;
		System.out.print("[");
		for (int i = 0; i < lengthOfArray - 1; i++){
			System.out.print(arrayOfIntegers[i] + ",");
		}
		System.out.print(arrayOfIntegers[lengthOfArray - 1] + "] \n");

	}

	public static void main(String args[]){
		//long startTime = returnTime();

		int arrayOfIntegers[] = generateArray();
		System.out.println("Before:");
		printArray(arrayOfIntegers);


		QuickSort result = new QuickSort();
		result.sort(arrayOfIntegers, 0, arrayOfIntegers.length - 1);

		System.out.println("After:");
		printArray(arrayOfIntegers);

		//long endTime = returnTime();
		//System.out.println("Took "+(endTime - startTime) + " ns");

	}

}
