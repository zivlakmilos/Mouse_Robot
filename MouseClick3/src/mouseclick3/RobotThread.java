package mouseclick3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author ZI
 */


public class RobotThread extends Thread
{
    // Global variables
    int[] x, y, a, t;
    
    Robot robot = null;
    
    // Constructor
    public RobotThread()
    {
        try
        {
            robot = new Robot();
        } catch(AWTException ex){}
    }
    
    public void setX(String[] value)
    {
        x = null;
        for(int i = 0; i < value.length; i++)
            x[i] = Integer.parseInt(value[i]);
    }
    
    public void setY(String[] value)
    {
        y = null;
        for(int i = 0; i < value.length; i++)
            y[i] = Integer.parseInt(value[i]);
    }
    
    public void setA(String[] value)
    {
        a = null;
        for(int i = 0; i < value.length; i++)
            a[i] = Integer.parseInt(value[i]);
    }
    
    public void setT(String[] value)
    {
        t = null;
        for(int i = 0; i < value.length; i++)
            t[i] = Integer.parseInt(value[i]);
    }
    
    @Override
    public void run()
    {
        for(int i = 0; i < x.length; i++)
        {
            robot.mouseMove(x[i], y[i]);
            if(a[i] == 1)
            {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            } else
            {
                robot.mousePress(InputEvent.BUTTON2_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);
            }
            
            try
            {
                Thread.sleep(t[i]);
            } catch(InterruptedException ex){}
        }
    }
}