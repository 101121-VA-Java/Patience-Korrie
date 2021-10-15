public class Hats {
    public static void main(String[] args){
        Hats listOfHats= new Hats();
         String[] str = {"Bucket", "Baseball", "Beanie", "Cowboy", "Straw hat", "Visor"};
        //  Store types = {"Bucket", "Baseball", "Beanie", "Cowboy", "Straw hat", "Visor"};
        Store nike = new Store(str);
        
        typesOfHats(nike);
    }

    public  static void typesOfHats(Store anyStoreObj){
        String[] storeTypes = anyStoreObj.types;
        for(int i=0; i<storeTypes.length; i++){
            System.out.println(storeTypes[i]);
        }
    }
}
