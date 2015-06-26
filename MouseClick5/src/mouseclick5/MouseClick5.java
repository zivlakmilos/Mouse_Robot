package mouseclick5;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import net.miginfocom.swing.*;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.*;
import org.jnativehook.keyboard.*;

/**
 * 
 * @author ZI
 *
 */


public class MouseClick5  extends JFrame
{
	// Visual components
	private JPanel pnlCoordinates;
	private JLabel lblX, lblY, lblA, lblT;
	private JTextArea txtX, txtY, txtA, txtT;
	private JPanel pnlOptions;
	private JLabel lblXN, lblYN;
	private JTextField txtRepeats;
	private JButton btnStart, btnRecord;
	
	// Global variables
	private MouseRobot robot;
	private boolean recording = false;
	
	// Constructor
	public MouseClick5()
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
		setLookAndFeel();
		
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
		btnRecord = new JButton("Snimi");
		
		txtRepeats.setText("1");
		
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
		pnlOptions.add(btnRecord);
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
		
		btnRecord.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				recording = true;
				minimize();
			}
		});
		
		// Mouse and Key Listeners
		try
		{
			GlobalScreen.registerNativeHook();
		} catch(Exception err){}
		MouseListener mouseListener = new MouseListener();
		GlobalScreen.addNativeMouseListener(mouseListener);
		//GlobalScreen.addNativeMouseMotionListener(mouseListener);
		GlobalScreen.addNativeKeyListener(new KeyListener());
	}
	
	// Minimize form
	private void minimize()
	{
		this.setState(JFrame.ICONIFIED);
	}
	
	// Restore form
	private void restore()
	{
		this.setState(JFrame.NORMAL);
	}
	
	// Set look and feel
	private void setLookAndFeel()
	{
		String laf = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
		
		try
		{
			UIManager.setLookAndFeel(laf);
			SwingUtilities.updateComponentTreeUI(this);
		} catch(Exception err){}
	}
	
	// Mouse listener
	private class MouseListener implements NativeMouseInputListener
	{
		private long tOld = System.currentTimeMillis();
		
		@Override
		public void nativeMouseClicked(NativeMouseEvent e)
		{
			if(recording)
			{
				int x, y, a, t;
				x = e.getX();
				y = e.getY();
				a = e.getButton();
				t = (int) ((int) System.currentTimeMillis() - tOld);
				tOld = System.currentTimeMillis();
				txtX.append(String.valueOf(x) + "\n");
				txtY.append(String.valueOf(y) + "\n");
				txtA.append(String.valueOf(a) + "\n");
				txtT.append(String.valueOf(t) + "\n");
			}
		}

		@Override
		public void nativeMousePressed(NativeMouseEvent e)
		{
		}

		@Override
		public void nativeMouseReleased(NativeMouseEvent e)
		{
		}

		@Override
		public void nativeMouseDragged(NativeMouseEvent e)
		{
		}

		@Override
		public void nativeMouseMoved(NativeMouseEvent e)
		{
			lblXN.setText("X: " + String.valueOf(e.getX()));
			lblYN.setText("Y: " + String.valueOf(e.getY()));
		}
	}
	
	// Keyboard listener
	private class KeyListener implements NativeKeyListener
	{

		@Override
		public void nativeKeyPressed(NativeKeyEvent e)
		{
			if(recording && e.getKeyCode() == NativeKeyEvent.VC_ESCAPE)
			{
				recording = false;
				restore();
			}
		}

		@Override
		public void nativeKeyReleased(NativeKeyEvent e)
		{
		}

		@Override
		public void nativeKeyTyped(NativeKeyEvent e)
		{
		}
	}
	
	//=================== main =====================//
	public static void main(String[] args)
	{
		MouseClick5 mainFrame = new MouseClick5();
		mainFrame.setVisible(true);
	}
	//================ end of main =================//
}
