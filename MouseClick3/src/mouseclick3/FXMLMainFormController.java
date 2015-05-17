package mouseclick3;

//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author zi
 */


public class FXMLMainFormController implements Initializable
{
    @FXML private TextArea x;
    @FXML private TextArea y;
    @FXML private TextArea a;
    @FXML private TextArea t;
    @FXML private Label pX;
    @FXML private Label pY;
    
    private RobotThread robot;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void startOnClick(ActionEvent event)
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
    
    /*
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
    */
}
