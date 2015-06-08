package mouseclick4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.miginfocom.swing.*;

/**
 * 
 * @author ZI
 *
 */


public class MouseClick4  extends JFrame
{
	// Visual components
	private JPanel pnlCoordinates;
	private JLabel lblX, lblY, lblA, lblT;
	private JTextArea txtX, txtY, txtA, txtT;
	private JPanel pnlOptions;
	private JLabel lblXN, lblYN;
	private JTextField txtRepeats;
	private JButton btnStart, btnStop;
	
	// Constructor
	public MouseClick4()
	{
		/*
		 * Initialization
		 */
		
		// Form initialization
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(500, 500);
		//setResizable(false);
		setTitle("Mouse Click   ZI");
		//setLayout(new MigLayout("wrap 1"));
		
		// Visual components initialization
		pnlCoordinates = new JPanel(new MigLayout("wrap 4"));
		lblX = new JLabel("X:");
		lblY = new JLabel("Y:");
		lblA = new JLabel("Akcija:");
		lblT = new JLabel("Vreme:");
		txtX = new JTextArea(50, 8);
		txtY = new JTextArea(50, 8);
		txtA = new JTextArea(50, 8);
		txtT = new JTextArea(50, 8);
		pnlOptions = new JPanel(new MigLayout());
		lblXN = new JLabel();
		lblYN = new JLabel();
		txtRepeats = new JTextField(5);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		
		/*
		 * Draw
		 */
		
		pnlCoordinates.add(lblX);
		pnlCoordinates.add(lblY);
		pnlCoordinates.add(lblA);
		pnlCoordinates.add(lblT);
		pnlCoordinates.add(txtX);
		pnlCoordinates.add(txtY);
		pnlCoordinates.add(txtA);
		pnlCoordinates.add(txtT);
		pnlOptions.add(lblXN);
		pnlOptions.add(lblYN, "wrap");
		pnlOptions.add(txtRepeats);
		pnlOptions.add(btnStart);
		pnlOptions.add(btnStop);
		add(pnlCoordinates);
		add(pnlOptions);
		
		/*
		 * Actions
		 */
		
		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		
		btnStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});
	}
	
	//=================== main =====================//
	public static void main(String[] args)
	{
		MouseClick4 mainFrame = new MouseClick4();
		mainFrame.setVisible(true);
	}
	//================ end of main =================//
}
