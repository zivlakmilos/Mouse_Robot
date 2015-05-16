package mouseclick2;

import java.awt.AWTException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZI
 */


public class FXMLMainFormController implements Initializable
{
    // Visual componenets
    @FXML private Label pX, pY;
    @FXML private TextArea x, y, a, t;
    
    // Global Variables
    RobotThread robot = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
    
    @FXML
    private void startOnClick(ActionEvent e)
    {
        robot = new RobotThread();
        if(robot != null)
        {
            robot.setX(x.getText().split(System.getProperty("line.separator")));
            robot.setY(y.getText().split(System.getProperty("line.separator")));
            robot.setA(a.getText().split(System.getProperty("line.separator")));
            robot.setT(t.getText().split(System.getProperty("line.separator")));
            robot.start();
        }
    }
    
    @FXML
    private void stopOnclick(ActionEvent e)
    {
    }
    
    private class MouseListener implements MouseMotionListener
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
        }
        
        @Override
        public void mouseMoved(MouseEvent e)
        {
            pX.setText(String.valueOf(e.getX()));
            pY.setText(String.valueOf(e.getY()));
        }
    }
}
