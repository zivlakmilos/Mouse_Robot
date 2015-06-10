package mouseclick4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 * @author ZI
 *
 */

public class MouseRobot extends Thread
{
	// Global variables
	int[] x, y, a, t;
	int numOfRepeats;
	
	Robot robot;
	
	// Constructor
	public MouseRobot()
	{
		try
		{
			robot = new Robot();
		} catch (AWTException err) {}
	}
	
	// Set runnable
	public void setNumOfRepeats(int value)
	{
		numOfRepeats = value;
	}
	
	public void setX(int[] value)
	{
		x = value;
	}
	
	public void setY(int[] value)
	{
		y = value;
	}
	
	public void setA(int[] value)
	{
		a = value;
	}
	
	public void setT(int[] value)
	{
		t = value;
	}
	
	// Main function of thread
	@Override
	public void run()
	{
		for(int i = 0; i < numOfRepeats; i++)
		{
			for(int j = 0; j < x.length; j++)
			{
				robot.mouseMove(x[j], y[j]);
				switch(a[j])
				{
					case 1:
						robot.mousePress(InputEvent.BUTTON1_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_MASK);
						break;
						
					case 2:
						robot.mousePress(InputEvent.BUTTON3_MASK);
						robot.mouseRelease(InputEvent.BUTTON3_MASK);
						break;
				}
				
				try
				{
					Thread.sleep(t[j]);
				} catch (InterruptedException err) {}
			}
		}
	}
}
