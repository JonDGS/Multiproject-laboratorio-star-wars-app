import utils.JsonParser;

public class Main {
    public static void main(String[] args){
        for(String[] galactiCitizen: JsonParser.getAllStarWarsCharacters()){
            for(String data: galactiCitizen){
                System.out.print(data);
                System.out.print("~");
            }

            System.out.println();
        }
    }
}
