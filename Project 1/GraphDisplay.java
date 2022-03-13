package Assignment1;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */
public class GraphDisplay extends JPanel implements MouseMotionListener
{
    GeometricObject[] gArray; //geometric objects
    private BufferedImage image; //background image
    String description; //description of map element
    
    /**
     * Parameterized constructor.
     */
    public GraphDisplay(GeometricObject[] g)
    {
        this.gArray = g;
        addMouseMotionListener(this);
        
        try
        {
            image = ImageIO.read(new File("disney.PNG"));
        }
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        }        
        
        description = "";
    }
    
    public void mouseDragged(MouseEvent e)
    {	
    }

    /**
     * Captures mouse movement events.
     * 
     * @param e contains current location of mouse
     */
    public void mouseMoved(MouseEvent e)
    {
    	/**
        //only for coordinates lookup; remove after project completion
        System.out.println("(" + e.getPoint().x + ", " +
                           e.getPoint().y + ")");
        */
        
        //is current mouse location inside a geometric object?
        //Set description accordingly
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        Point p = new Point(e.getPoint().x, e.getPoint().y);
        int loc = Algorithms.isPointContainedIn(gArray, p);
        
        switch (loc)
        {
            case 0:
                description = "The Great Movie Ride";
                break;
            case 1:
                description = "Toy Story Mania";
                break;
            case 2:
                description = "Premier Theater";
                break;
            case 3:
                description = "Rock 'N' Roller Coaster";
                break;
            case 4:
                description = "Public Bathroom";
                break;
            default:
                description = "";
                break;
        }
        
        repaint();
    }
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    @Override
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draws background image
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);
        
        //outputs description
        g.setColor(new Color(64, 64, 64, 128));
        g.fillRoundRect(29, 75, 150, 30, 5, 5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString(description, 35, 96);
    }
}
