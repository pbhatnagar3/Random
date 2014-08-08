//implementation of quick sort

public class QuickSort {

	public void quickSort(int[] arr, int left, int right){
		int index = partition(arr, left, right);
		if(left < index - 1){
			quickSort(arr, left, index-1);
		}
		if(index < right){
			quickSort(arr, index, right);
		}
		
	}
	
	public int partition(int[] arr, int left, int right){
		int pivot = arr[(left+ right)/2];
		while(left <= right){
			while(arr[left] < pivot)
				left++;
			while(arr[right] > pivot)
				right--;
			// now since we have the correct positions to replace all the elements. 
			if(left <= right){
				swap(arr, left, right);
				left++;
				right--;
			}			
		}// end of the main while loop
		return left;
	}
	
	public void swap(int[] arr, int left, int right){		
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static class tester{
		public static void main(String[] args) {
			System.out.println("this is the implementation of quick sort");
			QuickSort quick = new QuickSort();
			int[] arr = {1,2,3,-4,0,1,6,7};
			quick.quickSort(arr, 0, arr.length-1);
			for(int i = 0; i < arr.length; i++){
				if(i == arr.length -1)
					System.out.println(arr[i]);
				else
					System.out.print(arr[i] + "->");
			}
		}
	}

}