import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class AnimationExample extends Application {
    private Node myActor;
    private Animation myAnimation;


    @Override
    public void start (Stage primaryStage) {
        primaryStage.setTitle("JavaFX Transition Animation Example");
        primaryStage.setScene(makeScene());
        primaryStage.show();
        myAnimation = makeAnimation(myActor);
        // start animation
        myAnimation.play();
    }

    private Scene makeScene () {
        Group root = new Group();
        // create something to animate
        Rectangle rect = new Rectangle(50, 50, 50, 50);
        rect.setFill(Color.BLUE);
        root.getChildren().add(rect);
        myActor = rect;
        return new Scene(root, 400, 100);
    }

    private Animation makeAnimation (Node agent) {
        // create something to follow
        Path path = new Path();
        path.getElements().addAll(new MoveTo(50, 50), new HLineTo(350));
        // create an animation where the shape follows a path
        PathTransition pt = new PathTransition(Duration.millis(4000), path, agent);
        // create an animation that rotates the shape
        RotateTransition rt = new RotateTransition(Duration.seconds(3));
        rt.setByAngle(90);
        // put them together in order 
        return new SequentialTransition(agent, pt, rt);
    }


    public static void main (String[] args) {
        Application.launch(args);
    }
}
