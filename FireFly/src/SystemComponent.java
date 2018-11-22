import javax.swing.*;
import java.awt.*;

public class SystemComponent extends JComponent
{
    private boolean mBroadcastable; //This boolean tells if the system is synchronised or not
        private FlashingSystem system;
    public SystemComponent(boolean broadcast)
    {
        mBroadcastable = broadcast;
        system = new FlashingSystem(this);
    }

    @Override
    public void paintComponent(Graphics g)
    {
       system.draw(g, mBroadcastable);
       }

    /**
     Starts a new animation thread.
     */
    public void startAnimation()
    {
        class AnimationRunnable implements Runnable
        {
            public void run()
            {
                try
                {
                    while(true)
                    {
                        system.update(mBroadcastable);
                    }
                }
                catch (InterruptedException exception)
                {
                }
            }
        }

        Runnable r = new AnimationRunnable();
        Thread t = new Thread(r);
        t.start();
    }
}
