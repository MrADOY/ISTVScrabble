package istv.scrabble.objets;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Nicolas JOURDAIN
 * @contributor
 *
 */
@SuppressWarnings("restriction")
public class FenetreScrabble extends Application {

	StackPane root;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(new File("src/istv/scrabble/view/test.fxml").toURI().toURL());
		Node node = fxmlLoader.load();
		StackPane root = new StackPane(node);
		final Scene scene = new Scene(root, 350, 300);
		

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setTitle("Scrabble");
		primaryStage.setScene(scene);
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());
//		primaryStage.setFullScreen(true);
//		primaryStage.setMaximized(true);
		primaryStage.show();
	}
			
	/*  MAIN */
	public static void main(String[] args) {
		launch(args);
	}
	
}