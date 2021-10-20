import java.util.Arrays;
import java.util.Scanner;

public class Hats {
    public static void main(String[] args){
        Hats listOfHats= new Hats(); //new instance of the class Hats

        //Created a string array with elements and stored them in a variable called strHats
         String[] strHats = {"Bucket, ", "Baseball, ", "Beanie, ", "Cowboy, ", "Straw-hat, ", "Visor."};
         Store hotHats = new Store(strHats); //created a new instance of the store class, gave it a new name and pass it the array.
        
         typesOfHats(hotHats);//able to call the method this way because its a static method
         
         //Adding a new type of hat
        Scanner inputType = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a type of hat");
		String newHat = inputType.nextLine();
         addHat(newHat, hotHats);

    }

    public  static void typesOfHats(Store anyStoreObj){
        System.out.println("Types of hats Avalible: ");
        String[] storeTypes = anyStoreObj.types;
        for(int i=0; i<storeTypes.length; i++){
            System.out.print( storeTypes[i]);
        }
    }

    public  static void addHat(String newHat, Store hotHats){
         hotHats.add(0, newHat);
		System.out.println( newHat + " has been added sucessfully!");
    }
}
