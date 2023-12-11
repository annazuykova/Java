package org.example;

import java.util.ArrayList;
import java.util.List;

public class QuadraticEquation {
    private double[] quadraticEquation = new double[3];

    public QuadraticEquation(double a, double b, double c) {
        quadraticEquation[0] = a;
        quadraticEquation[0] = b;
        quadraticEquation[0] = c;
    }

    public List<Double> solvingQuadraticEquation(){
        List<Double> res = new ArrayList();
        if (quadraticEquation[0] != 0) {
            double d = quadraticEquation[1] * quadraticEquation[1] - 4 * quadraticEquation[0] * quadraticEquation[2];
            if (d > 0) {
                res.add((-quadraticEquation[1] - Math.sqrt(d)) / (2 * quadraticEquation[0]));
                res.add((-quadraticEquation[1] + Math.sqrt(d)) / (2 * quadraticEquation[0]));
            }
            if (d == 0) {
                res.add(-quadraticEquation[1] / (2 * quadraticEquation[0]));
            }
        } else if (quadraticEquation[1] != 0) {
            res.add(quadraticEquation[2] / -quadraticEquation[1]);
        }
        return res;
    }
}
