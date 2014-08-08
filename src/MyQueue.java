import java.util.Stack;

/*
 * this is what I like to call as my implementation of a queue
 *  what is interesting about this implementation is that we will be using two stacks for the queue implementation
 */
public class MyQueue {

	Stack<Integer> oldStack = new Stack<Integer>();
	Stack<Integer> newStack = new Stack<Integer>();
	
	public void enqueue(Integer number){
		newStack.add(number);
		if(oldStack.size()== 0){
			while(newStack.size()!=0){
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public Integer deque(){
		if(oldStack.size()!=0)
			return oldStack.pop();
		else{
			while(newStack.size()!=0)
				oldStack.push(newStack.pop());
			return oldStack.pop();
		}
	}
	
		public Integer peek(){
			if(oldStack.size()!=0){
				int temp =  oldStack.pop();
				oldStack.push(temp);
				return temp;
			}			
			else{
				while(newStack.size()!=0)
					oldStack.push(newStack.pop());
				int temp =  oldStack.pop();
				oldStack.push(temp);
				return temp;
			}
	}
		
		public static void main(String[] args){
			MyQueue q = new MyQueue();
			for(int i = 0; i < 10; i++)
				q.enqueue(i);
			
			System.out.println(q.peek());
			int n = 10;
			while(n>0){
				System.out.println(q.deque());
				n--;
			}
		}
	
}
