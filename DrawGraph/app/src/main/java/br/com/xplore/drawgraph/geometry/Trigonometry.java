package br.com.xplore.drawgraph.geometry;


import static java.lang.Math.atan2;
import static java.lang.Math.PI;

public class Trigonometry {

    public static double angleRadBetweenPoints(double px1, double py1, double px2, double py2) {
        return atan2(py2 - py1, px2 - px1);
    }

    public static  double angleDegBetweenPoints(double px1, double py1, double px2, double py2) {
        return angleRadBetweenPoints(px1, py1, px2, py2) * 180.0 / PI;
    }

}
