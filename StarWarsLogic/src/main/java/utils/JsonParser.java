package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.ApiCaller;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<String[]> JsonGPtoGPArray(String json){
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonRoot = objectMapper.readTree(json);

            ArrayList<String[]> galacticCitizens = new ArrayList<String[]>();

            JsonNode resultsNode = jsonRoot.get("results");

            for(JsonNode galacticCitizen: resultsNode) {

                String[] tempArray = new String[3];

                tempArray[0] = galacticCitizen.get("name").asText();
                tempArray[1] = String.valueOf(galacticCitizen.get("height").asInt());
                tempArray[2] = galacticCitizen.get("birth_year").asText();

                galacticCitizens.add(tempArray);
            }

            return galacticCitizens;



        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String[][] getAllStarWarsCharacters(){
        ArrayList<String[]> galactics = new ArrayList<String[]>();
        String currentJson = ApiCaller.getAllStarWarsCharactersFromPage(1);
        int currentPage = 1;
        while(!currentJson.equals("")){
            ArrayList<String[]> tempArray = JsonGPtoGPArray(currentJson);
            galactics.addAll(tempArray);
            currentPage++;
            currentJson = ApiCaller.getAllStarWarsCharactersFromPage(currentPage);
        }

        String[][] galacticArray = new String [galactics.size()][3];

        galactics.toArray(galacticArray);

        return galacticArray;
    }
}
