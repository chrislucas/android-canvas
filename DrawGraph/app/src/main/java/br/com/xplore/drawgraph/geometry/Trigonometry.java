package br.com.xplore.drawgraph.geometry;


import static java.lang.Math.atan2;

public class Trigonometry {

    public static double angleDegBetweenPoints(double px, double py, double cx, double cy) {
        return atan2(px - cx, py - cy);
    }

}
