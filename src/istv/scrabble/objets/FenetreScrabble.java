package istv.scrabble.objets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import istv.scrabble.interfaces.PiocheInt;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
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
public class FenetreScrabble extends Application implements EventHandler<MouseEvent> {
	
	
	
	@Override 
    public void start(Stage primaryStage) throws IOException { 
		PiocheInt p = new Pioche();
		MainJoueur m = new MainJoueur();
		List<Character> l = new ArrayList<Character>();
		m.ajoutLettreMain(Pioche.piocheLettre(7));

		FXMLLoader fxmlLoader = new FXMLLoader(new File("/Users/neal/eclipse-workspace-java/Scrabble/ISTVScrabble/src/istv/scrabble/view/test.fxml").toURI().toURL());
		final Node node = fxmlLoader.load();
        final StackPane root = new StackPane(node);
        Map<String, Object> namespace = fxmlLoader.getNamespace();
        ImageView rack = (ImageView) namespace.get("img1");
        ImageView imagePane = (ImageView) namespace.get("Img00");
        
        
        int IMAGE_SIZE = 50;
        
//		File file = new File("file:/Users/neal/eclipse-workspace-java/Scrabble_Graphique/resources/Wood/letter_a.png");
//		GridPane gridPane = new GridPane();
//		gridPane.setGridLinesVisible(true);
	
//		rack.setOnMouseDragged(new EventHandler <MouseEvent>() {
//			public void handle(MouseEvent event) {
//				System.out.println("DRAG");
//              /* allow any transfer mode */
//              Dragboard db = rack.startDragAndDrop(TransferMode.ANY);
//              
////              ClipboardContent content = new ClipboardContent();
////              content.put(source.getImage());
////              db.setContent(content);
////              
//              event.consume();
//          }
//      });
//		
////		System.out.println(rack.getProperties());
//        imagePane.setOnDragDropped(event -> {
//            Dragboard db = event.getDragboard();
//            if (db.hasImage()) {
//                ImageView imageView = new ImageView(db.getImage());
//                imageView.setFitHeight(IMAGE_SIZE);
//                imageView.setFitWidth(IMAGE_SIZE);
//                imageView.setPreserveRatio(true);
//                imagePane.setImage(db.getImage());
//                event.setDropCompleted(true);
//            } else if (db.hasFiles()) {
//                db.getFiles().forEach(file -> {
//                    try {
//                        Image image = new Image(file.toURI().toURL().toExternalForm(), IMAGE_SIZE, IMAGE_SIZE, true, true);
//                        ImageView imageView = new ImageView(image);
//                        imagePane.setImage(image);
//                    } catch (Exception exc) {
//                        System.out.println("Could not load image "+file);
//                    }
//                });
//                event.setDropCompleted(true);
//            }
//        });
//
//       
//  
//        
       
        final Scene scene = new Scene(root, 350, 300); 
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds(); 
        primaryStage.setTitle("Scrabble"); 
        primaryStage.setScene(scene); 
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.show();
        	} 
    

    /**lancement du prog*/
    public static void main(String[] args) {
       launch(args);
    }


	/* (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}


	
	
}