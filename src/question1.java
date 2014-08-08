import java.util.Scanner;

//import java.util.Scanner;
//
//
//public class question1 {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	System.out.println("enter the number of elements");
//	Integer[] number = new Integer[scan.nextInt()];
//	
////	int front = 0, middle = number.length/3, rear = 2*number.length/3;
////	System.out.println("enter the stack number");
////	int stack_number = scan.nextInt();
////	int head, tail;
////	if(stack_number == 0){
////		head = front;
////		tail = middle;
////	}
////	else if(stack_number == 1){
////		head = middle;
////		tail = rear;
////	}
////	
////	else{
////		head = rear;
////		tail = number.length-1;
////	}
//	
//	int[] head = new int[3];
//	int[] tail = new int[3];
//	head[0] = 0;
//	tail[0] = 0;
//	head[1] = number.length/3 + 1;
//	tail[1] = number.length/3 + 1;
//	head[2] = number.length/3 * 2 + 1;
//	tail[2] = number.length/3 * 2 + 1;
//	
//	System.out.println("enter the stack number");
//	int sindx = scan.nextInt(); 
////	//since we are implementing stacks, we will have to remove from the back and push in the front
//	System.out.println("enter 1 for pushing an element");
//	if(scan.nextInt() == 1){
//		System.out.println(push(head, tail, scan.nextInt(), sindx, number.length)); 
//	}
//	else{
//		System.out.println(pop(head, tail));
//	}
//}
//
//private static String push(int[] head, int[] tail, int input, int sindx, int length){
//	if(tail[sindx] + 1 == head[sindx] || tail[sindx]-head[sindx]==length/3){
//		return "stack full";
//	}
//	
//	
//	if(head[sindx] == tail[sindx]){
//		if(sindx == 0){
//			head[sindx] = 0;
//		}
//		else if(sindx == 1){
//			head[sindx] = length/3+1;
//		}
//		else if(sindx == 2){
//			head[sindx] = length/3 * 2 +1;
//		}
//		tail[sindx] = head[sindx];
//	}
//	return null;
//}
//
//}

class question1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number of elements");
		int length = scan.nextInt();
		int[] num = new int[length];
		int top[] = new int[3];
		top[0] = 0;
		top[1] = length/3;
		top[2] = length/3 * 2;
		while(true){
		System.out.println("enter the stack you want to insert to");
		int sNo = scan.nextInt();
		System.out.println(push(num,top, sNo, length));
		System.out.println(num.toString());
		}
	}
	
	private static String push(int[] num, int[] top, int sNo, int length){
		int end;
		if(sNo == 0)
			end = length/3;
		else if(sNo == 1)
			end = 2*length/3;
		else
			end = length/3 -1;
		if(top[sNo] == end)
			return "No space";
		else
			System.out.println("enter the number to push");
			Scanner scan = new Scanner(System.in);
			num[top[sNo]] = scan.nextInt();
			top[sNo]++;
			return "Pushed";
	}
}