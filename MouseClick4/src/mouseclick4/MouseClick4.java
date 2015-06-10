package mouseclick4;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

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
	
	// Global variables
	MouseRobot robot;
	
	// Constructor
	public MouseClick4()
	{
		/*
		 * Initialization
		 */
		
		// Form initialization
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		setTitle("Mouse Click   ZI");
		setLayout(new MigLayout("wrap 1"));
		
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
		
		// Global variables initialization
		// robot = new MouseRobot();
		
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
				String[] sX, sY, sA, sT;
				int[] iX, iY, iA, iT;
				
				sX = txtX.getText().split("\n");
				sY = txtY.getText().split("\n");
				sA = txtA.getText().split("\n");
				sT = txtT.getText().split("\n");
				
				iX = new int[sX.length];
				iY = new int[sY.length];
				iA = new int[sA.length];
				iT = new int[sT.length];
				
				for(int i = 0; i < sX.length; i++)
				{
					iX[i] = Integer.parseInt(sX[i]);
					iY[i] = Integer.parseInt(sY[i]);
					iA[i] = Integer.parseInt(sA[i]);
					iT[i] = Integer.parseInt(sT[i]);
				}
				
				robot = new MouseRobot();
				
				robot.setX(iX);
				robot.setY(iY);
				robot.setA(iA);
				robot.setT(iT);
				robot.setNumOfRepeats(Integer.parseInt(txtRepeats.getText()));
				
				robot.start();
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
