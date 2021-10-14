import java.util.Scanner;
public class calMethods{
	public static void main(String[] args){
		
		// int sum = add(3,4);
		System.out.println(add(3,4));

		// int sub = subtract(6,2);
		System.out.println(subtract(6,2));
		System.out.println(mutiply(5.0,2.0));
		System.out.println(remainder(5,2));

		// String day = "Friday";
		// int startValue = 50;

		//input for countdown
		// Scanner inputNum = new Scanner(System.in);  // Create a Scanner object
		// System.out.println("Enter a Number");
		// int startValue = inputNum.nextLine();

		//name sentence
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a name");
		String name = input.nextLine();
		System.out.println("hello " + name + " Hope you are having a good day!");

		//input for weekday
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a day");
		String day = myObj.nextLine();

		switch(day){
			case "Monday":
				System.out.println("Monday is hard");
				break;
				case "Tuesday":
				System.out.println("3 days until Friday");
				break;
			case "Wednesday":
				System.out.println("2 days until Friday");
				break;
			case "Thursday":
				System.out.println("Tomorrow is Friday");
				break;
			case "Friday":
				System.out.println("Can't wait for Friday");
				break;
			default:
				System.out.println("Not a day, please try again.");
		}

		

	}
	public static int add(int a, int b) {
		return a+b;
		
	}
	public static int subtract(int a, int b) {
		return a-b;
		
	}
	public static double mutiply(Double a, Double b) {
		return a*b;
		
	}
	public static int remainder(int a, int b) {
		return a%b;
	}
	
	// public void countdown(int startValue) { 
	// 	startValue = 50;
	// if(startValue < 0){
	// 	System.out.println("please provide a positive number");
	// }
	// 	while(startValue > 0){
	// 		System.out.println(startValue);
	// 		startValue--;
	// 	}
	// }

}
