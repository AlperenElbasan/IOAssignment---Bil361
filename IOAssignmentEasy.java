import java.util.ArrayList;
import java.util.Scanner;

public class IOAssignmentEasy {
	
	static ArrayList<Integer> listA = new ArrayList<Integer>();
	static ArrayList<Integer> listB = new ArrayList<Integer>();
	static ArrayList<Integer> listC = new ArrayList<Integer>();
	
	static int[][] arr = new int[3][3];
	
	final static int FINISH = 4200;
	static int aCount = 1, bCount = 1, cCount = 1;
	static int waitTime = 0;
	private static Scanner keyboard;

	public static void main(String ...strings){
		addJob('A', 30, 50, 2);
		addJob('B', 25, 75, 3);
		addJob('C', 50, 100, 1);
		
		keyboard = new Scanner(System.in);
		System.out.println("Which question: a or b");
		char c = keyboard.nextLine().charAt(0);
		
		for(int time=1; time < FINISH; time++){
			for(int j=0; j < arr.length; j++){
				if(time % arr[j][2] == 0){
					switch(arr[j][0]){
					case 'A':
						listA.add(arr[j][2]); break;
					case 'B':
						listB.add(arr[j][2]); break;
					case 'C':
						listC.add(arr[j][2]); break;
					default:
						System.out.println("SMTH WRONG"); System.exit(-1);
					}
				} 
			}
			if(c == 'a' || c == 'A')
				Q1(time);
			else if(c == 'b' || c == 'B')
				Q2(time);
			else{ 
				System.out.println("Wrong entry! Run again!");
				System.exit(-1);
			}
			if(waitTime > 0) waitTime--;
			
		}
	}
	
	public static void Q1(int time){
		if(waitTime == 0){ //Only it is available
			if(!listA.isEmpty()){
				listA.remove(0); waitTime = 30; System.out.println("A"+(aCount++) + " : "+ time);
			}else if(!listB.isEmpty()){
				listB.remove(0); waitTime = 25; System.out.println("B"+(bCount++) + " : "+ time);
			}else if(!listC.isEmpty()){
				listC.remove(0); waitTime = 50; System.out.println("C"+(cCount++) + " : "+ time);
			}
		}
	}
	
	public static void Q2(int time){
		if(waitTime == 0){ //Only it is available
			if(!listC.isEmpty()){
				listC.remove(0); waitTime = 50; System.out.println("C"+(cCount++) + " : "+ time);
			}else if(!listA.isEmpty()){
				listA.remove(0); waitTime = 30; System.out.println("A"+(aCount++) + " : "+ time);
			}else if(!listB.isEmpty()){
				listB.remove(0); waitTime = 25; System.out.println("B"+(bCount++) + " : "+ time);
			}
		}
	}
	
	public static void addJob(char c, int jobtime , int requesttime, int w){
		int where = w-1;
		arr[where][0] = c;	
		arr[where][1] = jobtime;
		arr[where][2] = requesttime;
	}
}
