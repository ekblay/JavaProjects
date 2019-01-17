package Jeopardy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Help with JSON Parsing
 */
public class JSonExample {

    public static void main(String [] args){

        //this is cut and paste from an actual jservice web api response to:
        //http://jservice.io/api/categories?count=1&offset=312
        String jsonCategory = "[{\"id\":11765,\"title\":\"name that game show\",\"clues_count\":5}]";

        //this is cut and paste from an actual jservice web api response to:
        //http://jservice.io/api/clues?category=11765
        String jsonQuestions = "[{\"id\":89255,\"answer\":\"\\u003Ci\\u003EDeal or No Deal\\u003C/i\\u003E\",\"question\":\"Choose from 26 hot babes holding 26 briefcases on this hit game show\",\"value\":200,\"airdate\":\"2009-05-11T12:00:00.000Z\",\"created_at\":\"2014-02-14T01:54:53.332Z\",\"updated_at\":\"2014-02-14T01:54:53.332Z\",\"category_id\":11765,\"game_id\":null,\"invalid_count\":null,\"category\":{\"id\":11765,\"title\":\"name that game show\",\"created_at\":\"2014-02-14T01:54:53.099Z\",\"updated_at\":\"2014-02-14T01:54:53.099Z\",\"clues_count\":5}},{\"id\":89261,\"answer\":\"\\u003Ci\\u003E1 vs. 100\\u003C/i\\u003E\",\"question\":\"You face off against the mob on this Bob Saget-hosted show\",\"value\":400,\"airdate\":\"2009-05-11T12:00:00.000Z\",\"created_at\":\"2014-02-14T01:54:53.681Z\",\"updated_at\":\"2014-02-14T01:54:53.681Z\",\"category_id\":11765,\"game_id\":null,\"invalid_count\":null,\"category\":{\"id\":11765,\"title\":\"name that game show\",\"created_at\":\"2014-02-14T01:54:53.099Z\",\"updated_at\":\"2014-02-14T01:54:53.099Z\",\"clues_count\":5}},{\"id\":89267,\"answer\":\"\\u003Ci\\u003EThe Price Is Right\\u003C/i\\u003E\",\"question\":\"Though Bob has retired from this game show, it still tapes in the \\\"Bob Barker Studio\\\"\",\"value\":600,\"airdate\":\"2009-05-11T12:00:00.000Z\",\"created_at\":\"2014-02-14T01:54:54.168Z\",\"updated_at\":\"2014-02-14T01:54:54.168Z\",\"category_id\":11765,\"game_id\":null,\"invalid_count\":null,\"category\":{\"id\":11765,\"title\":\"name that game show\",\"created_at\":\"2014-02-14T01:54:53.099Z\",\"updated_at\":\"2014-02-14T01:54:53.099Z\",\"clues_count\":5}},{\"id\":89273,\"answer\":\"\\u003Ci\\u003EAre You Smarter than a 5th Grader?\\u003C/i\\u003E\",\"question\":\"5 elementary school kids help adults make the grade on this Jeff Foxworthy game show\",\"value\":800,\"airdate\":\"2009-05-11T12:00:00.000Z\",\"created_at\":\"2014-02-14T01:54:54.414Z\",\"updated_at\":\"2014-02-14T01:54:54.414Z\",\"category_id\":11765,\"game_id\":null,\"invalid_count\":null,\"category\":{\"id\":11765,\"title\":\"name that game show\",\"created_at\":\"2014-02-14T01:54:53.099Z\",\"updated_at\":\"2014-02-14T01:54:53.099Z\",\"clues_count\":5}},{\"id\":89279,\"answer\":\"\\u003Ci\\u003EFamily Feud\\u003C/i\\u003E\",\"question\":\"Show on which 2 clans compete to guess the top responses to survey questions\",\"value\":1000,\"airdate\":\"2009-05-11T12:00:00.000Z\",\"created_at\":\"2014-02-14T01:54:54.642Z\",\"updated_at\":\"2014-02-14T01:54:54.642Z\",\"category_id\":11765,\"game_id\":null,\"invalid_count\":null,\"category\":{\"id\":11765,\"title\":\"name that game show\",\"created_at\":\"2014-02-14T01:54:53.099Z\",\"updated_at\":\"2014-02-14T01:54:53.099Z\",\"clues_count\":5}}]";


        JSONParser parser = new JSONParser();

        try {


            //parse the category

            //the leading "[" tells me the json is an array
            JSONArray categoryArray = (JSONArray) parser.parse(jsonCategory);

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

                System.out.print("Title of Category: ");
                System.out.println(title);

                System.out.print("Id of Category: ");
                System.out.println(id);

                System.out.println();

            }
            //parse the questions

            //the leading "[" tells me the json is an array
            JSONArray jsonArray = (JSONArray) parser.parse(jsonQuestions);


            for (int i = 0; i < jsonArray.size(); i++) {
                //with the array the {'s start json objects

                //get all the objects
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                //get the question
                long id = (Long) jsonObject.get("id");
                String answer = (String) jsonObject.get("answer");
                //i know, i know in jeopardy the questions are supposed to be the answers
                String question = (String) jsonObject.get("question");
                long value = (Long) jsonObject.get("value");

                answer = answer.replace("<i>", "");
                answer = answer.replace("</i>", "");

                System.out.println("Jeopardy Question:");
                System.out.println(question);
                System.out.println("Jeopardy Answer:");
                System.out.println(answer);

                System.out.println("Value:");
                System.out.println(value);

                System.out.println();

            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
