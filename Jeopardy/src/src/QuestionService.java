import javax.swing.*;

public class QuestionService
{
    public static void main(String[] args)
    {
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        Client frame = new Client();
        frame. setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Client");
        frame.setVisible(true);
    }
}
