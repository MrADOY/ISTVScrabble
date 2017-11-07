package istv.scrabble.objets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import istv.scrabble.interfaces.PiocheInt;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Nicolas JOURDAIN
 * @contributor
 *
 */
public class FenetreScrabble extends Application {

	StackPane root;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		PiocheInt p = new Pioche();
//		MainJoueur m = new MainJoueur();
		List<Character> l = new ArrayList<Character>();
		
		int IMAGE_SIZE = 50;
		
		
		FXMLLoader fxmlLoader = new FXMLLoader(new File("src/istv/scrabble/view/test.fxml").toURI().toURL());
		Node node = fxmlLoader.load();
		StackPane root = new StackPane(node);
		final Group group = new Group();
		final Scene scene = new Scene(root, 350, 300);
		
		
		
		Map<String, Object> namespace = fxmlLoader.getNamespace();
//		Label rack = (Label) namespace.get("rack1");
//		Node rack = ScrabbleController.selectSource(event);
//		Label target = (Label) namespace.get("case00");

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