import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame
{
    JButton mQuitButton, mRegister, mPlayButton, mScoreButton,
            mAnswerButton;
    JPanel mActivity, mMenu;
    ActionListener ls;
    JTextField mField, mBet;
    String mName, mAnswer;
    int mBetamount, mCurrentScore;
    final int SBAP_PORT = 8888;
    Scanner mIn;
    PrintWriter mOut;
    Question mCurrentQuestion;
    public Client()
    {

        setSocket();  //establish connection

        /*
            Initialise the components in the frame
         */
        mActivity = new JPanel();
        mMenu = new JPanel();
        mScoreButton= new JButton("Score Table");
        mQuitButton = new JButton("Quit");
        ls = new ButtonListener();
        mQuitButton.addActionListener(ls);
        mScoreButton.addActionListener(ls);
        getInfo(); // ask user for information
        // clientsMenu();

        this.add(mActivity);
        this.add(BorderLayout.SOUTH, mMenu);
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 450;

        this. setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Client");


    }

    /**
     * Asks the user for their information
     */
    public void getInfo()
    {
        JLabel label = new JLabel("Enter you Name ");
        mActivity.add(label);
        mRegister = new JButton("Register");//Add a listener for this buttton ...it addds the user to the map
        mField = new JTextField(10);
        mActivity.add(mField);
        mActivity.add(mRegister);
        mRegister.addActionListener(ls);
    }

    /**
     * Sets up a connection with the servers socket
     */
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

    /**
     * This metghod does the asking of the question
     * @throws IOException
     * @throws ParseException
     */
    public void askQuestion() throws IOException, ParseException //this should actually pass an object called question
    {
        //change the question and create a text field to collect the question and return the answer
        mCurrentQuestion = Server.service.getQuestion();
        JTextArea area = new JTextArea(10,30);
        area.append("\nANSWER THE QUESTION IN THE BOX BELOW\n");
        area.append(mCurrentQuestion.toString());
        JLabel label = new JLabel("Enter your answer ");
        mAnswerButton = new JButton("Answer");//Add a listener for this buttton ...it addds the user to the map
        mField = new JTextField(10);
        JLabel label1 = new JLabel("How much do you want to bet: ");
        mBet = new JTextField(10);
        mActivity.add(area);

        mActivity.add(BorderLayout.SOUTH,label);
        mActivity.add(BorderLayout.SOUTH,mField);
        mActivity.add(BorderLayout.SOUTH,mAnswerButton);
        mActivity.add(BorderLayout.SOUTH,label1);
        mActivity.add(BorderLayout.SOUTH,mBet);
        mAnswerButton.addActionListener(ls);
        System.out.println("\nThis is the answer for the question: " + mCurrentQuestion.getAnswer());
        //The answer for the question is printed out everytime teh question is asked so that you don't lose you bet
        //:)

    }

    /**
     * This is another version of the previous method except it takes ina question as parameter
     * @param question
     * @throws IOException
     */
    public void askQuestion(Question question) throws IOException //this should actually pass an object called question
    {
        //change the question and create a text field to collect the question and return the answer
        mCurrentQuestion = question;
        JTextArea area = new JTextArea(10,30);
        area.append("\nANSWER THE QUESION IN THE BOX BELOW" +
                "AND HOW MUCH YOU WANT TO BET");
        area.append(mCurrentQuestion.toString());
        JLabel label = new JLabel("Enter your answer ");
        mAnswerButton = new JButton("Answer");//Add a listener for this buttton ...it addds the user to the map
        mField = new JTextField(10);
        JLabel label1 = new JLabel("How much do you want to bet: ");
        mBet = new JTextField(10);
        JLabel label2 = new JLabel("Enter a bet amount greater  than 0");
        label2.setForeground (Color.red);
        mActivity.add(area);
        mActivity.add(BorderLayout.SOUTH,label);
        mActivity.add(BorderLayout.SOUTH,mField);
        mActivity.add(BorderLayout.SOUTH,mAnswerButton);
        mActivity.add(BorderLayout.SOUTH,label1);
        mActivity.add(BorderLayout.SOUTH,mBet);
        mActivity.add(BorderLayout.SOUTH, label2);
        mAnswerButton.addActionListener(ls);

    }

    /**
     * This sets the clients menu
     */
    public  void clientsMenu()
    {
        //asks if the user wants to play game see leader board or quit
        mPlayButton= new JButton("Play Game");
        mMenu.add(mPlayButton);
        mPlayButton.addActionListener(ls);
        mMenu.add(mScoreButton);
        mMenu.add(mQuitButton);
    }
    //this connects to the scoreboard class and collect the scoretable's data
    public void showScores()
    {
        //displays the highscores
        // HashMap<String, Integer> map = ScoreTable.mTable;
        JTextArea area = new JTextArea(10,30);
        area.append("\n\tSCOREBOARD\n\nCLIENT NAME\t\tSCORE");
        for (String key : ScoreTable.mTable.keySet())
        {
            long value = ScoreTable.mTable.get(key);
            area.append("\n" + key + "\t\t" + value);
        }
        mActivity.add(area);
    }

    /**
     * This is the button Listener class
     */
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource()==mPlayButton)   //If tbe play Button is clicked on
            {
                mActivity.removeAll();
                mMenu.removeAll();
                mActivity.updateUI();
                mMenu.updateUI();
                mMenu.add(mScoreButton);
                mMenu.add(mQuitButton);
                try
                {
                    askQuestion(); //asks a questioin
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            else if(event.getSource()==mQuitButton)   //When the quit button is clicked on
            {
                System.out.println(mName +" has been disconnected.");

                dispose();  //quit without closing all other processes
            }
            else if(event.getSource()==mScoreButton)  //if score button is clicked
            {
                mActivity.removeAll();
                mActivity.updateUI();
                showScores();
            }
            else if(event.getSource()==mRegister) // if the register button is clicked
            {
                mName = mField.getText();
                mActivity.removeAll();
                mActivity.updateUI();
                String res = ScoreTable.addClient(mName);
                JLabel label  = new JLabel(res);
                label.setFont(new Font("Serif",Font.PLAIN,18));
                mActivity.add(BorderLayout.CENTER,  label);
                clientsMenu();
            }else if(event.getSource() == mAnswerButton)   // if the answer button is clicked
            {
                mBetamount = Integer.parseInt(mBet.getText());
                mAnswer = mField.getText();
                if(mBetamount < 0 || !(mBetamount >= 0) || mAnswer.equals(""))  //validate the input first
                {
                    try {
                        mActivity.removeAll();
                        mActivity.updateUI();
                        askQuestion(mCurrentQuestion);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    JLabel label;
                    if (mCurrentQuestion.checkAnswer(mAnswer))  //check the answer
                    {
                        mCurrentScore += mBetamount;
                        label = new JLabel("\n\tCorrect");
                        JLabel label2 = new JLabel("Your current score is $" + mCurrentScore);
                        mActivity.removeAll();
                        mActivity.updateUI();
                        mActivity.add(label);
                        mActivity.add(label2);
                    } else {
                        mCurrentScore -= mBetamount;
                        label = new JLabel("\n\tWrong, the right answer  is " + mCurrentQuestion.mAnswer);
                        JLabel label2 = new JLabel("Your current score is $" + mCurrentScore);

                        mActivity.removeAll();
                        mActivity.updateUI();
                        mActivity.add(label);
                        mActivity.add(label2);
                    }
                    ScoreTable.update(mName,mCurrentScore);  //update score Table
                    mMenu.add(mPlayButton);
                }
            }
        }
    }
}
