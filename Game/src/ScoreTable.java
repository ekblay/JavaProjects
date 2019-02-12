import java.util.HashMap;

public class ScoreTable
{
    public static HashMap<String,Long> mTable = new HashMap<>();
    public  ScoreTable()
    {}


    public static HashMap<String, Long> getTable()
    {

        return mTable;
    }
    /*
            Adds client upon registration and prints meaningful message
     */
    public static String addClient(String name)
    {
        if (mTable.containsKey(name))
        {
            return "Welcome Back " + name + " Your current score is " + mTable.get(name);
        }
        else
        {
            mTable.put(name,(long)0 );
            return "Welcome to Jeopardy " + name + ", you have been registered successfully";
        }
    }
    //updates the score of the specified client
    public static void update(String name, long score)
    {
        mTable.put(name,score);
    }
}
