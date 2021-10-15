public class ReversedArray{
	public static void main(String[] args){
        String[] letters = {"red", "Black", "Blue","Gray"};

        System.out.println("Original array: ");  
        for (int i = 0; i < letters.length; i++) {  
            System.out.print(letters[i] + " "); 
        }
        System.out.println(arrayList(letters));
   	
    }
    public static String[] arrayList(String letters[]) {
        System.out.println();  
        System.out.println("Array in reverse order: ");
        for (int i = letters.length-1; i >= 0; i--) {  
            System.out.print(letters[i] + " ");
        }

      return letters;
    }
}
		
