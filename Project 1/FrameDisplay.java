package Assignment1;
import javax.swing.*;
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */

public class FrameDisplay extends JFrame
{   
    private GraphDisplay panel;

    /**
     * Creates an initializes the window frame.
     * 
     * @param width frame width
     * @param height frame height
     * @param g geometric objects to be depicted in this frame
     */
    public FrameDisplay(int width, int height, GeometricObject[] g)
    {
        setTitle("Disney Hollywood Studios Map");
        setSize(width, height);
        setResizable(false);

        panel = new GraphDisplay(g);
        add(panel);
    }
}
