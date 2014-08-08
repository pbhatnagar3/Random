import java.util.Scanner;
import java.util.Stack;


public class TowersOfHanoi {

	static class Tower{
		Stack<Integer> tower = new Stack<Integer>();
		
		public void move(Tower destination){
			destination.tower.push(this.tower.pop());
		}
		
		public int playTheGame(Tower destination, Tower buffer, int n, int count){
			if(n < 2){
				if(n == 1){
					this.move(destination);
					count++;
					return count;
				}
					
			}
			count = this.playTheGame(buffer, destination, n-1, count);
			this.move(destination);
			count++;
			count = buffer.playTheGame(destination, this, n-1, count);
//			count++;
			return count;
		}
	}
	
	public static void main(String[] args){
		Tower[] towersOfHanoi = new Tower[3];
		for(int i = 0; i < 3; i++){
			towersOfHanoi[i] = new Tower();
		}
		System.out.println("enter the number of disks to place in the first pillar");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = n;
		while(i>0)
			towersOfHanoi[0].tower.push(i--);
		System.out.println("here is the number of moments" + towersOfHanoi[0].playTheGame(towersOfHanoi[2], towersOfHanoi[1], n, 0));
	}
	
	
}
