import javax.swing.*;
import java.awt.*;

public class Driver
{
    public static void main(String[] args)
    {
        JFrame frame1 =  new JFrame();
        JFrame frame2=  new JFrame();
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT =  500;

        frame1.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Synchronised");
    frame2.setTitle("Unsynchronised");

        SystemComponent component1
                = new SystemComponent(true);
        SystemComponent component2
                = new SystemComponent(false);
        frame1.add(component1);
        frame2.add(component2);
        frame1.setVisible(true);
        frame2.setVisible(true);
        component1.startAnimation();
       component2.startAnimation();

    }
}
