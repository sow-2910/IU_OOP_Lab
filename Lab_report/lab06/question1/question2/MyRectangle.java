package question2;

import java.awt.geom.*;

public class MyRectangle {
    private Point2D.Double bottomLeftPoint;
    private Point2D.Double topRightPoint;

    public MyRectangle(Point2D.Double pt1, Point2D.Double pt2) {
        double xMin = Math.min(pt1.getX(), pt2.getX());
        double yMin = Math.min(pt1.getY(), pt2.getY());

        double xMax = Math.max(pt1.getX(), pt2.getX());
        double yMax = Math.max(pt1.getY(), pt2.getY());

        this.bottomLeftPoint = new Point2D.Double(xMin, yMin);
        this.topRightPoint = new Point2D.Double(xMax, yMax);
    }

    public Point2D.Double getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public void setBottomLeftPoint(Point2D.Double bottomLeftPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
    }

    public Point2D.Double getTopRightPoint() {
        return topRightPoint;
    }

    public void setTopRightPoint(Point2D.Double topRightPoint) {
        this.topRightPoint = topRightPoint;
    }

    public double getXmin() {
        return bottomLeftPoint.getX();
    }

    public double getYmin() {
        return bottomLeftPoint.getY();
    }

    public double getXmax() {
        return topRightPoint.getX();
    }

    public double getYmax() {
        return topRightPoint.getY();
    }

    @Override
    public String toString() {
        return "[" + bottomLeftPoint + "]" + "[" + topRightPoint + "]";
    }
}
