import java.util.ArrayList;


public class testing {
public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp = new ArrayList<Integer>();
	temp.add(123);
	listOfList.add(temp);
	ArrayList<Integer> yolo = listOfList.get(0);
	yolo.add(123322);
			
}
}
