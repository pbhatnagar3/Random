import java.util.ArrayList;
import java.util.Arrays;


public class SubSetOptimised {
public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index){
	//BC
	ArrayList<ArrayList<Integer>> allSubSets;
	if(set.size() == index){
		allSubSets = new ArrayList<ArrayList<Integer>>();
		allSubSets.add(new ArrayList<Integer>());
	}
	else{
		//assuming that you have done the thing for n-1 elements
		allSubSets = powerSet(set, index+1);
		//using the assumption stated in the above statement, what is left to be done
		ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
		int currentValue = set.get(index);
		for(ArrayList<Integer> temp : allSubSets){
//			moreSubSets.addAll(temp)
			ArrayList<Integer> whatSoEver = new ArrayList<Integer>(temp);
			whatSoEver.add(currentValue);
			moreSubSets.add(whatSoEver);
		}
		allSubSets.addAll(moreSubSets);
		
	}
	return allSubSets;	
	
}
public static void main(String[] args){
	SubSetOptimised s = new SubSetOptimised();
	ArrayList arr = new ArrayList<Integer>();
	arr.add(1);
	arr.add(2);
	arr.add(3);
	ArrayList<ArrayList<Integer>> powerSet = s.powerSet(arr, 0);
	System.out.println("power transformation");
}
}
