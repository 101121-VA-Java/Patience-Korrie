public static void main(String[] args) { /* Here we are creating a main class with a public access modifier, made static with no return type(void), 
											and passing in an array type String and an argement*/
	String[] foodTypes = getFoodTypes();// we then are declaring a string array called foodTypes and assiging it to a method called getFoodTypes
	String myType = foodTypes[2];//here we are declaying a string called myType and assiging it foodTypes(the pervious array created) with the content at index 2 which is "dinner"

	String[] foodsOfMyType = getFoodsByType(myType); /* we are also declaring another string array called foodOfMyType and assiging it a 
														method called getFoodsByType and passing it the string myType created above*/
	
	for (String food : foodsOfMyType) { // Creating a for loop that goes through each food in the array foodOfMyType
		System.out.println(food); // Prints each food to the console...which would print the contents of foods in case the third case,dinner
	}
}

public static String[] getFoodTypes() { /* Here we are creating the method called getFoodTypes with the acesse modifier of public, 
											making it static, with a type string array*/
	String[] foodTypes = {"breakfast","lunch","dinner","dessert","snack"}; // Here we are specify each element in an array and assiging it to the string arr foodTypes
	return foodTypes; // Returing variable foodTypes and what it contains 
}

public static String[] getFoodsByType(String type) { /* Here we are creating the method called getFoodsByType with the acesse modifier of public, 
														making it static, with a type string array and passing in a string variable called type*/
	String[] foods = new String[3]; // Declaring a strin arr called foods and assiging it a neww string with 3 element/indexes

	switch(type) { //start a switch statment with type(the string being pass in at the begining of the method) passed in the parameter
	case "breakfast": //first case; if its a food of type "breakfast"
		foods[0] = "pancakes"; //add "pancakes" to the first index of the arr foods
		foods[1] = "cereal"; //add "cereal" to the second index of the arr foods
		foods[2] = "omelette"; //add "omelette" to the third index of the arr foods
		break; //break out of the switch statement after filling the foods arr
	case "lunch"://secound case; if its a food of type "lunch"
		foods[0] = "sandwich";//add "sandwich" to the first index of the arr foods
		foods[1] = "salad";//add "salad" to the second index of the arr foods
		foods[2] = "soup";//add "soup" to the third index of the arr foods
		break;//break out of the switch statement after filling the foods arr
	case "dinner": //third case; if its a food of type "dinner"
		foods[0] = "curry";//add "curry" to the first index of the arr foods
		foods[1] = "stir fry";//add "stir fry" to the second index of the arr foods
		foods[2] = "burger";//add "burger" to the third index of the arr foods
		break;//break out of the switch statement after filling the foods arr
	case "dessert"://forth case; if its a food of type "dessert"
		foods[0] = "cake";//add "cake" to the first index of the arr foods
		foods[1] = "ice cream";//add "ice cream" to the second index of the arr foods
		foods[2] = "candy";//add "candy" to the third index of the arr foods
		break;//break out of the switch statement after filling the foods arr
	case "snack"://fifth case; if its a food of type "snack"
		foods[0] = "chips";//add "chips" to the first index of the arr foods
		foods[1] = "apple";//add "apple" to the second index of the arr foods
		foods[2] = "samosa";//add "samosa" to the third index of the arr foods
		break;//break out of the switch statement after filling the foods arr
	default: // the default run if the types speficied in the switch statment were not called
		foods[0] = "Banana";//add "Banana" to the first index of the arr foods
		foods[1] = "Apple";//add "Apple" to the second index of the arr foods
		foods[2] = "Orange";//add "Orange" to the third index of the arr foods
		break;//break out of the switch statement after filling the foods arr
	}

	return foods; // stepping out of the switch statement and returning foods with whaterver elements were stored
}