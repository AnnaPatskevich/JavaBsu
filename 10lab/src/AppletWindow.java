import java.applet.Applet;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class AppletWindow extends Applet
{
    private Rectangle2D rectangle;
    private Ellipse2D ellipse;
    private Color[] colors = new Color[3];
    private int angle=0;
    @Override
    public void init()
    {
        super.init();
        initalize_params();
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                angle+=10;
                repaint();
            }
        },1000,50);
    }

    public void paint(Graphics gr)
    {
        setBackground(colors[0]);
        Graphics2D graphics2D = (Graphics2D)gr.create();
        graphics2D.setPaint(colors[1]);
        graphics2D.rotate(Math.toRadians(angle),rectangle.getCenterX(),rectangle.getCenterY());
        graphics2D.fill(rectangle);
        graphics2D = (Graphics2D)gr.create();
        graphics2D.setPaint(colors[2]);
        graphics2D.rotate(Math.toRadians(-angle),ellipse.getCenterX(),ellipse.getCenterY());
        graphics2D.fill(ellipse);
    }
    void initalize_params()
    {
        String tmp=null;
        int [] points = new int[4];
        try
        {
            tmp = getParameter("back_color");
            colors[0] = new Color( Integer.parseInt( tmp.substring( 1 ), 16 ) );
        }
        catch ( Exception e )
        {
            colors[0] = Color.CYAN;
        }
        try
        {
            tmp = getParameter("rect_color");
            colors[1] = new Color( Integer.parseInt( tmp.substring( 1 ), 16 ) );
        }
        catch ( Exception e )
        {
            colors[1] = Color.BLUE;
        }
        try
        {
            tmp = getParameter("ell_color");
            colors[2] = new Color( Integer.parseInt( tmp.substring( 1 ), 16 ) );
        }
        catch ( Exception e )
        {
            colors[2] = Color.RED;
        }
        try
        {
            tmp = getParameter("x");
            points[0]=Integer.parseInt(tmp);
        }
        catch (Exception e)
        {
            points[0]=150;
        }
        try
        {
            tmp = getParameter("y");
            points[1]=Integer.parseInt(tmp);
        }
        catch (Exception e)
        {
            points[1]=50;
        }
        try
        {
            tmp = getParameter("width_f");
            points[2]=Integer.parseInt(tmp);
        }
        catch (Exception e)
        {
            points[2]=150;
        }
        try
        {
            tmp = getParameter("height_f");
            points[3]=Integer.parseInt(tmp);
        }
        catch (Exception e)
        {
            points[3]=100;
        }
        rectangle = new Rectangle2D.Double(points[0],points[1],points[2],points[3]);
        ellipse = new Ellipse2D.Double(points[0],points[1],points[2],points[3]);
    }
}
