import java.applet.Applet;
import java.awt.*;

public class map extends Applet
{
    public void paint(Graphics g)
    {
    	//Draw Basic Map Grid
        g.drawRect(0,0,600,900);
        for (int x = 0; x < 12; x++){
            g.drawLine(0,(900/12)*x,600,(900/12)*x);
        }
        for (int y = 0; y < 8; y++){
            g.drawLine((600/8)*y,0,(600/8)*y,900);
        }
        
        //Draw Player
        g.drawLine(25/2,25,125/2,25);
        g.drawOval(33,33,17,17);
        g.drawLine((25+50)/2,2,45,23);
        g.drawLine((25+50)/2,2,30,23);
        g.drawLine(35,50,30,73);
        g.drawLine(40,50,45,73);

    }
}