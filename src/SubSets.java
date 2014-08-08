import java.util.ArrayList;
import java.util.Arrays;

//one of the methods finds all the subsets of a given set
public class SubSets {

	public static ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();

	public static void printOut(ArrayList<ArrayList<Integer>> powerSet){
		for(int i = 0; i < powerSet.size(); i++){
			System.out.print("ArrayList " + i + " is the follows:  ");
			if(powerSet.get(i).size() == 0)
				System.out.print("none");
			else{
			for(int j = 0; j < powerSet.get(i).size(); j++)
				System.out.print(powerSet.get(i).get(j) + "--");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		//assuming that this was the array that was read into the console
		int[] arr = {1,2,3};
		powerSetter(arr);
		printOut(powerSet);

	}

	public static void powerSetter(int[] arr){
		if(arr.length == 0)
			return;
		else
			if( powerSet.size() == 0){
				ArrayList<Integer> t1 = new ArrayList<Integer>();
				t1.add(arr[0]);		
				ArrayList<Integer> t2 = new ArrayList<Integer>();
				powerSet.add(t1);
				powerSet.add(t2);
				System.out.println("powerSet size"+ powerSet.size() );
				System.out.println("powerSet size"+ powerSet.get(0).size() );
				arr = Arrays.copyOfRange(arr, 1, arr.length);
				powerSetter(arr);

			}
			else{
//				System.out.println("asdf");
//				printOut(powerSet);
				int powerSetSize = powerSet.size();					
				for(int i = 0; i < powerSetSize; i++){
					ArrayList<Integer> temp = new ArrayList<Integer>(powerSet.get(i));
					temp.add(arr[0]);
					powerSet.add(temp);
								
				}
				arr = Arrays.copyOfRange(arr, 1, arr.length);
				powerSetter(arr);	
				
			}

	}
}
