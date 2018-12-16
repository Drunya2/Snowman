package Snowman;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Snowman {
    private final static int circlesHead = 3;
    static Random random = new Random();
    private static double radiusCircle;

    private static Paint generateRandomColor() {
        String rgb = "#";
        for (int i = 0; i < 6; i++) {
            rgb += (char) ('0' + random.nextInt(9));
        }
        return Paint.valueOf(rgb);
    }

    void parametersOfCircle(Circle circle) {
        circle.setStrokeWidth(1);
        circle.setStroke(generateRandomColor());
        circle.setFill(Paint.valueOf("#00000000"));
    }

    Circle createMouth(Circle circle) {
        double maxRadius = radiusCircle / 5;
        double minRadius = radiusCircle / 9;
        double radiusForMouth = maxRadius * random.nextDouble() + minRadius;
        double centerMouth = circle.getCenterY() + (radiusCircle / 3);
        Circle mouth = new Circle(circle.getCenterX(), centerMouth, radiusForMouth);
        parametersOfCircle(mouth);
        return mouth;
    }

    Circle createLeftEye(Circle circle) {
        double maxRadius = radiusCircle / 5;
        double minRadius = radiusCircle / 9;
        double radiusForLeftEye = maxRadius * random.nextDouble() + minRadius;
        double centerX1 = circle.getCenterX() - (radiusCircle / 3);
        double centerY1 = circle.getCenterY() - (radiusCircle / 3);
        Circle eye = new Circle(centerX1, centerY1, radiusForLeftEye);
        parametersOfCircle(eye);
        return eye;
    }

    Circle createRightEye(Circle circle) {
        double maxRadius = radiusCircle / 5;
        double minRadius = radiusCircle / 9;
        double radiusForRightEye = maxRadius * random.nextDouble() + minRadius;
        double centerX2 = circle.getCenterX() + (radiusCircle / 3);
        double centerY1 = circle.getCenterY() - (radiusCircle / 3);
        Circle eye = new Circle(centerX2, centerY1, radiusForRightEye);
        parametersOfCircle(eye);
        return eye;
    }

    void createHead(Circle circle, Pane root) {
        Circle leftEye = createLeftEye(circle);
        Circle rightEye = createRightEye(circle);
        Circle mouth = createMouth(circle);
        root.getChildren().addAll(leftEye, rightEye, mouth);
    }

    public Circle createFirstCircle(Pane root, int min, int max) {
        radiusCircle = random.nextInt(max) + (min + 1);
        Circle circle = new Circle(350, 110, radiusCircle);
        parametersOfCircle(circle);
        root.getChildren().addAll(circle);
        createHead(circle, root);
        return circle;
    }

    public Circle createCircle(Circle circle, Pane root, int min, int max) {
        radiusCircle = random.nextInt(max) + (min + 1);
        double centerY = circle.getCenterY() + circle.getRadius() + radiusCircle;
        Circle circ = new Circle(circle.getCenterX(), centerY, radiusCircle);
        parametersOfCircle(circ);
        root.getChildren().add(circ);
        return circ;
    }

}
