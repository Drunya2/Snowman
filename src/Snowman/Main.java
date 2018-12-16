package Snowman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    void draw(Pane root2, int min, int max, int count){
        Snowman snowman = new Snowman();
        Circle head = null;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                head = snowman.createFirstCircle(root2, min, max);
            } else head = snowman.createCircle(head, root2, min, max);
        }
    }

    void initWindow(Pane root, Pane root2) {
        TextField countOfCircles = new TextField();
        countOfCircles.setTranslateX(10);
        countOfCircles.setTranslateY(10);
        countOfCircles.setPromptText("Кол-во кругов");

        TextField minRadius = new TextField();
        minRadius.setTranslateX(10);
        minRadius.setTranslateY(40);
        minRadius.setPromptText("Минимальный радиус");

        TextField maxRadius = new TextField();
        maxRadius.setTranslateX(10);
        maxRadius.setTranslateY(70);
        maxRadius.setPromptText("Максимальный радиус");

        Button draw = new Button("Draw");
        draw.setTranslateX(10);
        draw.setTranslateY(100);

        draw.setOnAction(event -> {
            root2.getChildren().clear();
            int min = 0;
            int max = 0;
            int count = 0;
            try {
                min = Integer.parseInt(minRadius.getText());
                max = Integer.parseInt(maxRadius.getText());
                count = Integer.parseInt(countOfCircles.getText());
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный формат");
                return;
            }
            draw(root2, min, max, count);
        });
        root.getChildren().addAll(countOfCircles, minRadius, maxRadius, draw);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Pane root2 = new Pane();
        root.getChildren().add(root2);
        initWindow(root, root2);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

}
