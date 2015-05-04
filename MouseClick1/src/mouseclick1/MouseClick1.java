package mouseclick1;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author zi
 */


public class MouseClick1 extends JFrame
{
    // Visual components
    JLabel lblX, lblY, lblA;
    JList lstX, lstY, lstA;
    
    // Constructor
    public MouseClick1()
    {
        // Intitialization
        lblX = new JLabel("X");
        lblY = new JLabel("Y");
        lblA = new JLabel("A");
    }
    
    //================================= main =================================//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MouseClick1 mainForm = new MouseClick1();
        mainForm.setVisible(true);
    }
    //============================== end of main =============================//
}
