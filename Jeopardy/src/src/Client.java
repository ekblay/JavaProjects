import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame
{
    JButton mScoreButton;
    JButton mQuitButton ;
    JButton mPlayButton;
    JPanel mComponent;
    String mName;
    int mBetamount, mCurrentScore;
    final int SBAP_PORT = 8888;
    Scanner mIn;
    PrintWriter mOut;

    public Client()
    {
        //     setSocket();
        mComponent = new JPanel();
        mScoreButton= new JButton("Score Table");
        mQuitButton = new JButton("Quit");
        clientsMenu();

    }
    public void getInfo()
    {
        JTextField name = new JTextField(10);
    }
    public void setSocket()
    {
        try (Socket s = new Socket("localhost", SBAP_PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            mIn = new Scanner(instream);
            mOut = new PrintWriter(outstream);

        }
        catch (IOException e)
        {
            //Display on the component.
        }
    }
    public String askQuestion(String question) //this should actually pass an object called question
    {

        //change the question and create a text field to collect the question and return the answer
        return "";
    }
    public  void clientsMenu()
    {
        //asks if the user wants to play game see leader board or quit
       mPlayButton= new JButton("Play Game");
        mComponent.add(BorderLayout.CENTER, mPlayButton);
    }
    public void showScores(String leadersBoardtoString)
    {
        //displays the highscores
        JLabel label = new JLabel(ScoreTable.print());
        mComponent.add(BorderLayout.CENTER, label);
    }
    class ChoiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource()==mPlayButton)
            {}
            else if(event.getSource()==mQuitButton)
            {}
            else if(event.getSource()==mScoreButton)
            {}
        }
    }
}
