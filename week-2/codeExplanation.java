//Go line by line, and explain what's happening in each line.

int score = 80; // A variable of type int and of name score is declared and is assigned a value of 80;

String result; // A variable called result with a type string declared

if (score == 80) { // An if statement checking if int score is equal to 80
	result = "You passed!"; // if the above statement is true result is assigned the string "you passed!"
} else if (score > 80) { // else if the value stored in the variable store is greather than 80
	result = "You did great!";// result will be assigned the string "you did great!"
} else { // else meaning if the both of the above statements are false
	result = "You did not pass. Try again!";// result will be assigned the string "you did not pass. Try again!"
}

System.out.println(result);//we then step out of the if statement and print out the string stored in the variable called result to the console
