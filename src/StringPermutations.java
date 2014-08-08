import java.util.ArrayList;


public class StringPermutations {

	public ArrayList<String> permute(String s){
		if(s.length()==1){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(s);
			return temp;
		}
		ArrayList<String> subOutput= permute(s.substring(1, s.length()));
		char current = s.charAt(0);
		ArrayList<String> output = new ArrayList<String>();
		for(String temp : subOutput){
			for(int i = 0; i < temp.length()+1; i++){
				output.add(temp.substring(0,i) + current + temp.substring(i, temp.length()));
			}
		}
		return output;
		
	}
	
	public static void main(String[] args) {
		StringPermutations t = new StringPermutations();
		ArrayList<String> permutedList = t.permute("abcd");
		for(String s : permutedList){
			System.out.println(s);
		}
		System.out.println(String.format("%d number of permutations were seen", permutedList.size()));
	}
}
