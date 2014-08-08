//implementing all the sorting algorithms 

public class Sort {
public int[] mergeSort(int[] arr, int p, int r){
	if(p==r){
		int[] output = new int[1];
		output[0] = arr[p];
		return output;
	}
	if(p+1==r){
		int[] output = new int[2];
		if(arr[p]<arr[r]){
			output[0] = arr[p];
			output[1] = arr[r];
		}
		else{
			output[1] = arr[p];
			output[0] = arr[r];
		}
			
		return output;
	}
	int q = (p + r)/2;
	int[] arr1 = mergeSort(arr, p, q);
	int[] arr2 = mergeSort(arr, q+1, r);
	int[] result = merge(arr1, arr2);
	return result;
}
public int[] merge(int[] arr1, int[] arr2){
	int[] output = new int[arr1.length+arr2.length];
	int count1 = 0;
	int count2 = 0;
	for(int i = 0; i < arr1.length+arr2.length; i++){
		if(count1 < arr1.length && count2 <arr2.length){
			if(arr1[count1] < arr2[count2]){
				output[i] = arr1[count1++];
		}
			else
				output[i] = arr2[count2++];
		}
		else if(count1 >= arr1.length){
			output[i] = arr2[count2++];
		}
		else{
			output[i] = arr1[count1++];
		}
	}
	return output;
}
public int[] subArray(int[] input, int p, int q){
	int[] output = new int[q-p+1];
	for(int i = 0; i <output.length; i++){
		output[i] = input[p++];
	}
	return output;
}

public static class testing{

	public static void main(String[] args) {
		Sort s = new Sort();
		int[] arr1 = {1,7,4,4,4,4,3,2,100};
		int[] arr2 = {4,5,6};
		
//		int[] output = s.merge(arr1, arr2);
		int[] output = s.mergeSort(arr1, 0, arr1.length-1);
//		int[] output = s.subArray(arr1, 0, 1);
		for(int i = 0; i < output.length; i++){
			System.out.println(output[i]);
		}
	}
	
}
}
