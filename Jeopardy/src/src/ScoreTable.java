import java.util.HashMap;

public class ScoreTable
{
    private static HashMap<Client,Integer> mTable;
    public  ScoreTable()
    {}


    public static String  print()
    {
        return mTable.toString();
    }
}
