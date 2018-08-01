package HW180725;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Queen's choice:");
		queenChoise();
		
		System.out.println("Average of even numbers:");
		evenNumbersAverage(sc);
	
		System.out.println("Walking:");
		walking(sc);
		
		System.out.println("Recursive multiplying:");
		recursiveMultiplying(sc);
		
		System.out.println("Recursive division:");
		recursiveDivision(sc);
		
		System.out.println("Recursive modulo:");
		recursiveModulo(sc);
		
		sc.close();

	}

	private static void queenChoise() {
		
		int numberOfMen=100;
		int countingForKilling=7;
		int survivingMen=numberOfMen;
		int killingCount=1;
		boolean[] isDead=new boolean[numberOfMen];
		int counter=0;
		
		while(survivingMen > 1) {
//			if(counter>99) {
//				counter=0;
//			}
			if(!isDead[counter]) {
				if (killingCount == countingForKilling) {
					killingCount = 1;
					isDead[counter] = true;
					--survivingMen;
				}
				else ++killingCount;
			}
			counter = (counter + 1) % numberOfMen;
		}
		
		for (int i = 0; i < isDead.length; ++i) {
			if(!isDead[i]) {
				System.out.println("The man in place " + (i + 1) + " survived");
				break;
			}
		}
		
		
	}

	private static void evenNumbersAverage(Scanner sc) {

		int sum = 0;
		int evenNumberCount = 0;
		int numberOfNumbers = 10;
		
		for(int i = 1; i <= numberOfNumbers; ++i) {
			System.out.println("Please put number number " + i + ":");
			int number = sc.nextInt();
			if(number % 2 == 0) {
				sum += number;
				++evenNumberCount;
			}
		}
		
		if(evenNumberCount == 0) {
			System.out.println("No even numbers where put.");
		}
		else {
			System.out.println("The average of even numbers: " + sum / evenNumberCount);
		}
		
	}

	private static void walking(Scanner sc) {

		boolean correctInput=false;
		Person p=null;
		while(!correctInput) {
			System.out.println("Please insert 1 for man or 2 for woman:");
			int input=sc.nextInt();
			switch (input) {
			case 1: p=new Man();
					correctInput=true;
					break;
					
			case 2: p=new Woman();
					correctInput=true;
					break;
					
			default:break;
			}
		}
		
		p.walk();
		
	}	

	private static void recursiveMultiplying(Scanner sc) {

		System.out.println("Please insert two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int multipication=recursiveMultiplying(num1, num2);
		System.out.println("The multipication of " + num1 + " and " + num2 + " is " + multipication);
		
	}

	private static int recursiveMultiplying(int num1, int num2) {		
		
		if(num2 == 0) {
			return 0;
		}
		else {
			--num2;
			return num1 + recursiveMultiplying(num1,num2);
		}		
		
	}
	
	private static void recursiveDivision(Scanner sc) {

		System.out.println("Please insert two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if (num2 == 0) {
			System.out.println("Cannot divide by 0");
			return;
		}
		int devision = recursiveDivision(num1,num2);
		System.out.println("The devision of " + num1 + " by " + num2 + " is "+devision);
		
	}
	
	private static int recursiveDivision(int num1, int num2) {		
		
		if(num1 <= num2) {
			return 0;
		}
		else {
			num1 -= num2;
			return 1+recursiveDivision(num1,num2);
		}		
		
	}
	
	private static void recursiveModulo(Scanner sc) {

		System.out.println("Please insert two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int modulo = recursiveModulo(num1, num2);
		System.out.println("The modulo of " + num1 + " and " + num2 + " is " + modulo);
		
	}

	private static int recursiveModulo(int num1, int num2) {

		
		if(num1<num2) {
			return num1;
		}
		else {
			num1 -= num2;
			return recursiveModulo(num1, num2);
		}
	}


}
