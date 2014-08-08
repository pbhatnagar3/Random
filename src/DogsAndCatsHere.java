//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Dogs and cats are one of the best things that have happened to mankind and we are sending them all 
 * over the place. 
 * For instance, we are creating a data Structure that will return the oldest animal, 
 * the oldest dog or the oldest cat
 * and keeps track and makes sure we return the oldest element
 * one could potentially create a class that holds the name and the time when the animal was added but 
 * that does not concern the problem and that could just be changed by changing two lines in the code
 */
public class DogsAndCatsHere {

	Queue<Integer> cats = new LinkedList<Integer>();
	Queue<Integer> dogs = new LinkedList<Integer>();
	
	public Integer dequeueCat(){
		return cats.remove();
	}
	
	public Integer dequeueDogs(){
		return dogs.remove();
	}
	
	public Integer dequeueOldest(){
		Integer temp1 = dequeueCat();
		Integer temp2 = dequeueDogs();
		if(temp1< temp2){
			dogs.add(temp2);
			return temp1;
		}
		else{
			cats.add(temp1);
			return temp2;
		}
	}
}
