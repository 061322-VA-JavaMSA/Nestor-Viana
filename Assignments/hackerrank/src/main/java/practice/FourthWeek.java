package practice;

import java.util.Scanner;

public class FourthWeek {
	
	static Scanner scan;
	public static void main(String[] args) {
		
//		stairCase();
//		simpleArraySum();
//		camelCase();
		
		int N = 30;
		int P = 4;
		int Q = 5;
		
		//5%3 = 2 BECAUSE the remainder is 2
		//7%3 = 1 BECAUSE the remainder is 1. I.e. 7 = 1 + 3*2
		
		
//		System.out.println(7%3);
//		System.out.println("Total number of turns: " + (int) N/(P+Q));
//		System.out.println("Remaining balls after all full turns: " + N%(P+Q));
		System.out.println(3%4);
		System.out.println((N%(P+Q))%P);
		System.out.println(qc(2,3,3));
	}
	
	public static void stairCase() {
		
		System.out.println("Enter a height for the staircase.");
		scan = new Scanner(System.in);
		int n = scan.nextInt();
//		int n = 3;
		int N = n-1;
		String whiteSpace = " ";
		String hashTag = "#";
			
		if(n==1) {
			System.out.println(hashTag);
		}else {
			for (int i = N; i >= 0 ; i--) {
			
			String out = "";
			int nS = i;
			int nH = N - i + 1;
			
			for (int j = 0; j < nS; j++) {
				out += whiteSpace;
			}
			for (int j = 0; j < nH; j++) {
				out += hashTag;
			}
			System.out.println(out);
			
			}
			
		}
		scan.close();
		System.out.println();
		
	}
	
	
	public static void simpleArraySum() {
		scan = new Scanner(System.in);
		System.out.println("How many numbers will you add?");
		int arraySize = Integer.parseInt(scan.nextLine());
		int[] intArray = new int[arraySize];
		System.out.println("Enter the numbers separated by a space");
		String numberString = scan.nextLine();
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(numberString.split(" ")[i]);
			
		}
		
		int sum = 0;
		for(int integer : intArray) {
			sum+=integer;
		}
		scan.close();
		System.out.println("The sum of this array is " + sum);
		System.out.println(intArray);
		
	}
	
	
	public static void camelCase() {
		System.out.println("Enter the CamelCase word");
		scan = new Scanner(System.in);
		char[] camelCase = scan.nextLine().toCharArray();
		int n = 1;
		for(char c : camelCase) {
			if(Character.isUpperCase(c)) {
				n++;
			}
		}
		System.out.println("This CamelCase word has " + n + " words in it");
		
	}



	public static int qc(int N, int P, int Q) {
		//N = total # of balls, P = Jack Balls, Q John balls
		
		//Calculate total number of Full turns (Jack and John get to both pick without problems)
		int fullTurns = N/(P+Q);
		
		//Calculate remaining number of balls after both Jack and John finish their last full turn
	    int remainingBalls = N%(P+Q);
	    
	    //If there are at most P number of balls left, Jack will pick the remaining balls
	    if(remainingBalls <= P){return P*fullTurns + remainingBalls;}
	    
	    //Otherwise, If there are at least P + 1 number of balls left, then John will pick the remaining, after Jack picks P balls on his very last turn.
	    return Q*fullTurns + remainingBalls - P;
	
	}

}	