import java.util.ArrayList;
import java.util.Stack;

//the following is the implementation for tower of hanoi

class hanoi{
	ArrayList<Stack<Integer>> towerList = new ArrayList<Stack<Integer>>();
	public hanoi(){
		//here is a list of stacks that we will be using
		int length = 10;
		Stack<Integer> temp = new Stack<Integer>();
		for(int i = 0; i <length; i++){
			temp.add(length--); 
		}
		towerList.add(temp);
	}
	
	public void move(int source, int destination, int buffer){
		towerList.get(destination).add((towerList.get(source).pop()));
	}
	
	public void letsPlay(){
		
	}
	}
