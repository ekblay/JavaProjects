import javafx.util.Pair;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionService
{
    public QuestionService()
    {}
    public Question getQuestion() throws IOException, ParseException {
        JSon js = new JSon();
        //Create url for category
         String url =  "http://jservice.io/api/categories?count=1&offset=";
        int offset = (int) (Math.random() * 18419) + 1; //generate s random offset value
        url = url + offset;

        //Get  a category first
        HttpReader reader = new HttpReader(url);
        Pair p = js.parsingCategory(reader.getLine());

        //then create the url for the question
        url = "http://jservice.io/api/clues?category=" + p.getValue();
         reader = new HttpReader(url);

         ArrayList<Question> questions = js.parsingQuestion(reader.getLine());
        //set the category in the questions
        for(Question  q : questions)
        {
            q.setTitle((String)p.getKey());
        }
        int rand = questions.size() - 1;
        int index = (int) (Math.random()*rand);
        return  questions.get(index);
    }


}
