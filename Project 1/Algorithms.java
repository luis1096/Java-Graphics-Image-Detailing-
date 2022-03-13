package Assignment1;
/**
 * This class implements several algorithms.
 */
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */
public class Algorithms
{
    /**
     * Determines the closest pair of points. Brute-force solution is used.
     * 
     * @param points input points. Array is assumed to be fully populated.
     * @param indices output array containing indices of closest pair
     */
    public static void closestPairOfPoints(Point[] points, int[] indices)
    {
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<points.length; i++)
        {
            for (int j=i+1; j<points.length; j++)
            {
               double d = points[i].distance(points[j]);
               if (d<minDistance)
               {
                   minDistance = d;
                   indices[0] = i;
                   indices[1] = j;
               }
            }
        }
    }

    public static int isPointContainedIn(GeometricObject[] g, Point p)
    {
        RecPolygon[] rArray = (RecPolygon[])g;
        
        for (int i=0; i < g.length; i++)
        {
            if (rArray[i].isPointInRecPolygon(p))
                return i;
        }
        
        return -1;
    }
}
