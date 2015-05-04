package mouseclick1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.layout.*;

/**
 *
 * @author zi
 */


public class MouseClick1 extends JFrame
{
    // Visual components
    private JPanel pnlX, pnlY, pnlA;
    private JLabel lblX, lblY, lblA;
    private JTextArea lstX, lstY, lstA;
    private MenuBar menu;
    private Menu mMain;
    private MenuItem miHelp;
    
    // Constructor
    public MouseClick1()
    {
        /*
         * Initializetion
         */
        
        // Initialize visual components
        pnlX = new JPanel();
        pnlY = new JPanel();
        pnlA = new JPanel();
        lblX = new JLabel("X");
        lblY = new JLabel("Y");
        lblA = new JLabel("A");
        lstX = new JTextArea("");
        lstY = new JTextArea("");
        lstA = new JTextArea("");
        
        menu = new MenuBar();
        mMain = new Menu();
        mMain.setLabel("Opcije");
        miHelp = new MenuItem();
        miHelp.setLabel("Pomoc");
        
        mMain.add(miHelp);
        menu.add(mMain);
        
        // Initialize form
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setMenuBar(menu);
        
        this.lookAndFeel();
        
        /*
         * Draw form
         */
        
        /*
         * Events
         */
        
        // Menu - Help
        miHelp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    private void lookAndFeel()
    {
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
