public class javaPractice{
        public static void main(String[] args){
                System.out.println("hello");

		String A = "Dog";
		int favNum = 2;

			System.out.println("Patience's favorite # is 2");
			System.out.println("Patience's favorite animal is "+ A);

		char letter = 'a';
        	char end = 'z';
		do{
            		System.out.print(letter);
            		letter++;
        	}while(letter <= end);
			System.out.println("Print all letter between a and z");

		String[] siblingsNames = {"Daniel", "Goodness", "Wisdom", "Confidence", "Divine", "David", "Messi"};

		 System.out.println("My sibling's names are: ");
			for(int i = 0; i < siblingsNames.length; i++){
				System.out.println( siblingsNames[i]);
			}
        }
}

