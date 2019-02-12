public class Question
{
    String mQuestion, mTitle;
    String mAnswer;
    long mValue;

    public Question()
    {}
    public Question(String q, String a, long value)
    {
        mQuestion=q;
        mAnswer = a;
        mValue =value;
    }

    /**
     *  This method gets the question
     * @rretur question
     */
    public String getQuestion()
    {
        return mQuestion;
    }

    /**
     * This method returns the answer for the question
     * @return answer
     */
    public String getAnswer()
    {
        return mAnswer;
    }

    /**
     * Set the title of the question
     * @param title
     */
    public void setTitle(String title){mTitle = title;}

    /**
     * Sets the question
     * @param q
     */
    public void setQuestion(String q)
    {
        mQuestion = q;
    }
    public void setAnswer(String a)
    {
        mAnswer = a;
    }
    public void setValue(long v)
    {
        mValue = v;
    }
    public long getValue()
    {return mValue;}

    /**
     * Checks the answer of the question
     * @param uAnswer
     * @return
     */
    public boolean checkAnswer(String uAnswer)
{
        boolean okay =true;
    String array[]= uAnswer.split(" ", 0);
    //This iterates to see if the answer provided by the user is close or
    // similar to the right answer
    for (String str: array)
    {
      if(!(mAnswer.toLowerCase().trim().contains(str.toLowerCase().trim())))
      {
        okay =false;

      }
    }
    return okay;
}
public String toString()
{
 return   "\nCATEGORY: " + mTitle + "\n VALUE IS " + mValue+ " \n\t\tQUESTION:\n\n" +
            mQuestion;
}
}
