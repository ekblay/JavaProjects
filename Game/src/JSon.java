import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Help with JSON Parsing
 */
public class JSon
{


    public JSon( ) {
         }

    public  Pair parsingCategory(String parsee)
    {
        JSONParser parser = new JSONParser();
        Pair<String,Long> result = null;

        try {

            JSONArray categoryArray = (JSONArray) parser.parse(parsee);
            //there should only be one category in the array
            for (int i = 0; i < categoryArray.size(); i++) {

                //get all the objects
                JSONObject jsonObject = (JSONObject) categoryArray.get(i);

                //get the id
                long id = (Long) jsonObject.get("id");
                //get the title
                String title = (String) jsonObject.get("title");
                //get the number of questions
                long numOfQuestions = (Long) jsonObject.get("clues_count");

                result = new Pair<>(title,id);
            }
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Question> parsingQuestion(String parsee) throws ParseException {
        //parse the questions
        JSONParser parser = new JSONParser();
        ArrayList <Question> list= new ArrayList<>();

        try {
            //the leading "[" tells me the json is an array
            JSONArray jsonArray = (JSONArray) parser.parse(parsee);

            for (int i = 0; i < jsonArray.size(); i++) {
                //with the array the {'s start json objects

                //get all the objects
                Question quest = null;
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                //get the question
                long id = (Long) jsonObject.get("id");
                String answer = (String) jsonObject.get("answer");

                String question = (String) jsonObject.get("question");
                long value = (Long) jsonObject.get("value");

                answer = answer.replace("<i>", "");
                answer = answer.replace("</i>", "");
                 quest = new Question(question,answer,value);
                 list.add(quest);
                }
        }
        catch(NullPointerException e){return list;}
        return list;
    }
}




