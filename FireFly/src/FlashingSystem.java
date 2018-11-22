import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FlashingSystem
{
    ArrayList<Firefly> mFlies ;
    private Lock mCurrent;
    JComponent comp;

    /**
     *
     * Constructor for the System.
     */
    public FlashingSystem(JComponent cmp)
    {
        comp = cmp;
        mFlies= new ArrayList<>();
        mCurrent = new ReentrantLock();

        for(int i =1; i <= 25; i++)
        {
            mFlies.add(new Firefly());
        }
    }

    public void draw(Graphics g, boolean b)
    {
        mCurrent.lock();
        try
        {
            int x =0;
            if(b)
            { x =0;}else{x =60;};
            for (int i = 0; i < mFlies.size(); i++)
            {
                mFlies.get(i).draw(x,10, g);
                x+=10+1;
            }

        }
        finally
        {
            mCurrent.unlock();
        }
    }

    /**
     * updates based on the current phase
     * @param tellThem
     * @throws InterruptedException
     */
    public void update(boolean tellThem) throws  InterruptedException
    {
        mCurrent.lock();
        try
        {
            for (Firefly fly : mFlies) {
                fly.flasher(tellThem);
            }
        }
        finally
        {
            mCurrent.unlock();
        }
        pause(1000);
    }

    /**
     * Startles each fly wehn any flashes
     * @throws InterruptedException
     */
    public void startleThem() throws InterruptedException
    {
        mCurrent.lock();
        try
        {
            for (Firefly fly : mFlies)
            {
                fly.startle();
            }
        }
        finally
        {
            mCurrent.unlock();
        }
        pause(10);
    }

    /**
     * Pauses the processes given a delay time
     * @param delay
     * @throws InterruptedException
     */
    public void pause(int delay) throws InterruptedException
    {
        comp.repaint();
        Thread.sleep(delay);
    }

    /**
     * Models a fire fly
     */
    class Firefly
    {
        final double mNATURAL_FREQ =Math.random() * 0.26 + 0.24;
        final double mSTARTLE_FACTOR =  Math.random() * 0.08 +0.06;
        final int mNumberOfFlies = 25;
        double mCurrentFreq;
        double mCurrentPhase ;
        double mTemporaryFreq;
        boolean startled = false;
        public Firefly()
        {
            mCurrentFreq = mNATURAL_FREQ;
            mCurrentPhase = Math.random() * 2*Math.PI;

        }
        public void draw(int x, int width, Graphics g)
        {
            if(mCurrentPhase >=2*Math.PI)
            {
                mCurrentPhase = 2*Math.PI;
                g.setColor(Color.YELLOW);
                g.fillRect(x,5,width,(int)mCurrentPhase*50 );
            }
            else
            {
                g.setColor(Color.BLUE);
                g.fillRect(x,5,width,(int)mCurrentPhase*50);
            }
        }

        /**
         * This method models a the progression in the current phase
         * @param tellThem
         * @throws InterruptedException
         */
        public void flasher(boolean tellThem) throws InterruptedException
        {

            if ( mCurrentPhase>=2*Math.PI)
            {
                if (tellThem)
                {broadcast();}
                mCurrentPhase = 0;
            }
            else
            {
                if (startled)
                {
                    mCurrentPhase = mCurrentPhase + mTemporaryFreq * 4;
                    startled= false;
                }
                else
                {
                    mCurrentPhase = mCurrentPhase + mCurrentFreq * 4;
                }

            }

        }

        /**
         * This method broadcasts the startles
         * @throws InterruptedException
         */
        public void broadcast() throws InterruptedException
        { startleThem();}

        /**
         * Sets a temporary frwquency when startled
         */
        public  void startle()
        {
            mTemporaryFreq = mNATURAL_FREQ +mSTARTLE_FACTOR* mNumberOfFlies *
                    Math.sin(Math.PI-mCurrentPhase);
            startled= true;
        }
    }


}

