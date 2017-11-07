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
public class FenetreScrabble extends Application implements EventHandler<DragEvent> {

	StackPane root;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		PiocheInt p = new Pioche();
		MainJoueur m = new MainJoueur();
		List<Character> l = new ArrayList<Character>();
		m.ajoutLettreMain(Pioche.piocheLettre(7));
		int IMAGE_SIZE = 50;
		
		
		FXMLLoader fxmlLoader = new FXMLLoader(new File("src/istv/scrabble/view/test.fxml").toURI().toURL());
		Node node = fxmlLoader.load();
		StackPane root = new StackPane(node);
		final Group group = new Group();
		final Scene scene = new Scene(root, 350, 300);
		
		Map<String, Object> namespace = fxmlLoader.getNamespace();
		Label rack = (Label) namespace.get("rack1");
//		Node rack = ScrabbleController.selectSource(event);
		Label target = (Label) namespace.get("case00");
		
		root.setOnDragOver(new EventHandler() {
            public void handle(final DragEvent event) {
                mouseDragOver(event);
            }

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
        });
 
        root.setOnDragDropped(new EventHandler() {
            public void handle(final DragEvent event) {
                mouseDragDropped(event);
            }

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
        });
 
         root.setOnDragExited(new EventHandler() {
            public void handle(final DragEvent event) {
                root.setStyle("-fx-border-color: #C6C6C6;");
            }

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
        });
		
         
        
		
		
//		rack.setOnDragDetected(new EventHandler<MouseEvent>() {
//			public void handle(MouseEvent event) {
//				rack.startFullDrag();
////				System.out.println("Drag");
//				Dragboard db = rack.startDragAndDrop(TransferMode.MOVE);
//				String url = "file:resources/Wood/letter_"+rack.getText()+".png";
//				Image im = new Image(url, IMAGE_SIZE, IMAGE_SIZE, false, false);
//				db.setDragView(im, IMAGE_SIZE, IMAGE_SIZE);
//				ClipboardContent content = new ClipboardContent();
//				content.putString(rack.getText());
//				db.setContent(content);
//				event.consume();
////				System.out.println(db.getString());
//			}
//		});
//		//
//		
//		rack.setOnDragDropped(new EventHandler<DragEvent>() {
//			public void handle(DragEvent event) {
//				Dragboard dragboard = event.getDragboard();
//
//				if (dragboard.hasString()) {
//					rack.setText(dragboard.getString());
//
//					// Data transfer is successful
//					event.setDropCompleted(true);
//				} else {
//					// Data transfer is not successful
//					event.setDropCompleted(false);
//				}
//
//				event.consume();
////				System.out.println("Drop");
//				event.consume();
//
//			}
//		});
//
//		rack.setOnDragDone(new EventHandler<DragEvent>() {
//			public void handle(DragEvent event) {
//				TransferMode modeUsed = event.getTransferMode();
//
//				if (modeUsed == TransferMode.MOVE) {
//					List<Character> liste = new ArrayList<Character>();
//					for(Character r : rack.getText().toCharArray())
//						liste.add(r);
//					m.retirerLettreMain(l, m);
//					
//					//FIXME Problème Main Joueur ≠ Rack
//					//FIXME Problème Main Joueur Appli ≠ Main Joueur Controller
//					m.afficherMainJoueur();
//					rack.setText("");
//				}
//
//				List<Character> l = new ArrayList<Character>();
//				for (char c : rack.getText().toCharArray()) {
//					l.add(c);
//					System.out.println(l);
//				}
//
//				event.consume();
//			}
//
//		});
//
//		rack.setOnDragOver(new EventHandler<DragEvent>() {
//			public void handle(DragEvent event) {
//				Dragboard dragboard = event.getDragboard();
//				if (dragboard.hasString()) {
////					System.out.println("DragOver");
//					event.acceptTransferModes(TransferMode.MOVE);
//				}
//				event.consume();
//			}
//		});
		
		
		
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
	
	void addImage(Image i, StackPane pane){
		 
        ImageView imageView = new ImageView();
        imageView.setImage(i);
        pane.getChildren().add(imageView);
    }
	
	private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            final File file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {
                        if(!root.getChildren().isEmpty()){
                            root.getChildren().remove(0);
                        }
                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));  
 
                        addImage(img, root);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FenetreScrabble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        e.setDropCompleted(success);
        e.consume();
    }
 
    private  void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();
 
        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg");
 
        if (db.hasFiles()) {
            if (isAccepted) {
                root.setStyle("-fx-border-color: red;"
              + "-fx-border-width: 5;"
              + "-fx-background-color: #C6C6C6;"
              + "-fx-border-style: solid;");
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }
	
	
	/*  MAIN */
	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	public void handle(DragEvent event) {
		
	}


}