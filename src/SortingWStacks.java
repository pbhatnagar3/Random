import java.util.Random;
import java.util.Stack;

/*
 * THIS IS ONE OF THE FLAVORS OF INSERTION SORT
 * lets try some sorting with stacks. so the question is that we have to sort the stack in decreasing order
 */
public class SortingWStacks {

	static Stack<Integer> toBeSorted = new Stack<Integer>();
	static Stack<Integer> buffer = new Stack<Integer>();
	public static void place(Integer temp){
		int count = 0;
		while(buffer.size() >0 && buffer.peek() >= temp){
			toBeSorted.push(buffer.pop());
			count++;
		}
		buffer.push(temp);
		while(count>0){
			buffer.push(toBeSorted.pop());
			count--;
		}
	}
	
	public static String print(Stack<Integer> s){
		String output = "";
		Stack<Integer> temp = new Stack<Integer>();
		while(s.size()>0){
			Integer holder = s.pop();
			output = output + "->" + holder;
			temp.push(holder);
		}
		while(temp.size()>0)
			s.push(temp.pop());
		
		return output;
	}
	
	public static void main(String[] args){

		int count = 0;
		Random r = new Random();
		
		for(int i = 0; i < 10; i++)
			toBeSorted.push(r.nextInt(50) + 1);
		System.out.println(print(toBeSorted));
		int initLength = toBeSorted.size();

		while(count!= initLength){
			count++;
			Integer temp = toBeSorted.pop();
			place(temp);
		}
		System.out.println(print(buffer));
	}
	
	
	}
