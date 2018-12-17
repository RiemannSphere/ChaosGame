import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Plot extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = WIDTH;
    private final int POINTS = 1000000;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,WIDTH,HEIGHT);

        ChaosGame chaosGame = new ChaosGame(HEIGHT,WIDTH,POINTS);

        WritableImage writableImage = new WritableImage(WIDTH,HEIGHT);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for( Point<Integer,Integer> point : chaosGame.generate(3,0.5) ){
            //System.out.println("x = " + point.getX() + "; y = " + point.getY());
            pixelWriter.setColor(point.getX(),point.getY(), Color.BLACK);
        }

        ImageView imageView = new ImageView(writableImage);
        root.getChildren().add(imageView);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
