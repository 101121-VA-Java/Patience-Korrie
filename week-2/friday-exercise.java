public class Food {//Creating a public class called Food
	public String name;//declaring a String variable called name with a public acess modifier
	public String type;//declaring a String variable called type with a public acess modifier

	public Food(String name, String type) {//creating a method called Food with a public acess modifier and passing in a String called name and a String called type in the parameter
		this.name = name;//this is assigning the declared name in the Food class above to the string name being passed in
		this.type = type;//this is assigning the declared type in the Food class above to the string type being passed in
	}

	public void cook() { //creating another method called cook that is void and public with no parameters 
		if (!name.contains("cooked")) {//starts an if statment that checks if name does not contain the string "cooked"
			name = "cooked " + name;//if it doesn't assigen name the string cooked plus the the content of name
		}
	}
}

public class Main {// creating a class called main with a public acess modifier
	public static void main(String[] args) {// in the class main, this is the main method that is void, public, and static which also has a parametter of String arr and args
		Food myFood = new Food("potato", "vegetable");// Declaring an instance of the class Food and assiging it a string called potato for the name and vegetable for the type
		myFood.cook();//calling the method cook and passin in the values contained in myFood

		System.out.println(myFood.name);//prints the name of the food that was passed in to the console, in this case potato
	}
}