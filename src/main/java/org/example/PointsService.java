package org.example;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class PointsService {
    static List<Points> pointsList = new ArrayList<>();
    public static List<Points> getPoints() {
        return pointsList;
    }
    public static List<Points> getFirstNPoints(int n) {
        return pointsList.subList(0, n);
    }

    public static double getDistanceBetweenPoints(int x, int y) {
        return pointsList.get(x).getPoint().distance(pointsList.get(y).getPoint());
    }

    public static void addPoint(Point point) {
        pointsList.add(new Points(point));
    }

    public static void deletePoint(int id) {
        pointsList.remove(id);
    }

}
