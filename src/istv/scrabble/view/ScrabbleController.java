/**
 * 24-10-2017
 * @author Jourdain Nicolas
 * Licence 3 FA - ISTV
 */
package istv.scrabble.view;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.objets.FenetreScrabble;
import istv.scrabble.objets.Joueur;
import istv.scrabble.objets.MainJoueur;
import istv.scrabble.objets.Pioche;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nicolas JOURDAIN - Sadgasmification
 * @contributor
 *
 */
public class ScrabbleController {

	/**
	 * Constructeur de ScrabbleController
	 */
	public ScrabbleController() {
		// TODO Auto-generated constructor stub
	}

	private FenetreScrabble mainApp;
	private MainJoueur m = new MainJoueur();
	private Joueur j = new Joueur("Bob");
	private Pioche p = new Pioche();

	@FXML
	private Label leftStatus;

	@FXML
	private GridPane rack;

	@FXML
	private ImageView img00;

	@FXML
	private ImageView img1;

	@FXML
	private ImageView img2;

	@FXML
	private ImageView img3;

	@FXML
	private ImageView img4;

	@FXML
	private ImageView img5;

	@FXML
	private ImageView img6;

	@FXML
	private ImageView img7;

	@FXML
	private Label case00;

	@FXML
	private Label nomJoueur;

	@FXML
	private Label rack1;

	@FXML
	private Label rack2;

	@FXML
	private Label rack3;

	@FXML
	private Label rack4;

	@FXML
	private Label rack5;

	@FXML
	private Label rack6;

	@FXML
	private Label rack7;

	@FXML
	private Node selectSourceLabel(MouseEvent event) {
		String source1 = event.getSource().toString(); // yields complete string
		// Node source3 = event.getPickResult().getIntersectedNode(); //yields complete
		// string
		// Object source3 = event.getSource(); //yields complete string
		// System.out.println(source3);
		Node source2 = event.getPickResult().getIntersectedNode(); // returns JUST the id of the object that was clicked
		// System.out.println("Full String: " + source1);
		// System.out.println("Just the id: " + source2);
		System.out.println("SOURCE : " + source2);
		return source2;
	}

	@FXML
	private Node selectTargetLabel(MouseEvent event) {
		String target1 = event.getTarget().toString(); // yields complete string
		// Node source3 = event.getPickResult().getIntersectedNode(); //yields complete
		// string
		// Object source3 = event.getSource(); //yields complete string
		// System.out.println(source3);
		Node target2 = event.getPickResult().getIntersectedNode(); // returns JUST the id of the object that was clicked
		// System.out.println("Full String: " + target1);
		// System.out.println("Just the id: " + target2);
		System.out.println("TARGET : " + target2);
		return target2;
	}
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(FenetreScrabble main) {
		this.mainApp = main;
	}

	public void melange() {
		m.melangerMain(m.getMainJoueur());
		setRack();
	}

	private void setRack() {
		if (!m.getMainJoueur().isEmpty()) {
			// img1.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(0).toString() + ".png"));
			// img2.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(1).toString() + ".png"));
			// img3.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(2).toString() + ".png"));
			// img4.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(3).toString() + ".png"));
			// img5.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(4).toString() + ".png"));
			// img6.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(5).toString() + ".png"));
			// img7.setImage(new Image("file:resources/Wood/letter_" +
			// m.getMainJoueur().get(6).toString() + ".png"));
			//
			System.out.println(m.getMainJoueur());
			System.out.println(m.getMainJoueur().size());
			if (m.getMainJoueur().size() >= 1)
				rack1.setText(m.getMainJoueur().get(0).toString());
			else {
				rack1.setText("");
				rack2.setText("");
				rack3.setText("");
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 2)
				rack2.setText(m.getMainJoueur().get(1).toString());
			else {
				rack2.setText("");
				rack3.setText("");
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 3)
				rack3.setText(m.getMainJoueur().get(2).toString());
			else {
				rack3.setText("");
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 4)
				rack4.setText(m.getMainJoueur().get(3).toString());
			else {
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 5)
				rack5.setText(m.getMainJoueur().get(4).toString());
			else {
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 6)
				rack6.setText(m.getMainJoueur().get(5).toString());
			else {
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 7)
				rack7.setText(m.getMainJoueur().get(6).toString());
			else
				rack7.setText("");
		}
	}



	public void dragText(MouseEvent event) {
		// final Object source = dragEvent.getGestureSource();
		// final Label target = dragEvent.getGestureTarget();
		Node sourceDrag = selectSourceLabel(event);
		Node targetDrag = selectTargetLabel(event);
		Label source = (Label) sourceDrag;
		Label target = (Label) targetDrag;
				
		source.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				/* drag was detected, start drag-and-drop gesture */
				// System.out.println("onDragDetected");
				/* allow any transfer mode */
				Dragboard db = source.startDragAndDrop(TransferMode.ANY);

				/* put a string on dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putString(source.getText());
				db.setContent(content);

				event.consume();
			}
		});

		target.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* data is dragged over the target */
				// System.out.println("onDragOver");

				/*
				 * accept it only if it is not dragged from the same node and if it has a string
				 * data
				 */
				if (event.getGestureSource() != target && event.getDragboard().hasString()) {
					/* allow for both copying and moving, whatever user chooses */
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}

				event.consume();
			}
		});

		target.setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* the drag-and-drop gesture entered the target */
				// System.out.println("onDragEntered");
				/* show to the user that it is an actual gesture target */
				if (event.getGestureSource() != target && event.getDragboard().hasString()) {
					target.setText("ENTERED");
				}

				event.consume();
			}
		});

		target.setOnDragExited(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* mouse moved away, remove the graphical cues */
				target.setText("");

				event.consume();
			}
		});

		target.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* data dropped */
				// System.out.println("onDragDropped");
				/* if there is a string data on dragboard, read it and use it */
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasString()) {
					target.setText(db.getString());
					success = true;
				}
				/*
				 * let the source know whether the string was successfully transferred and used
				 */
				event.setDropCompleted(success);

				event.consume();
			}
		});

		source.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* the drag-and-drop gesture ended */
				// System.out.println("onDragDone");
				target.setText(source.getText());
				source.setText("");
				List<Character> l = new ArrayList<Character>();
				for (char c : target.getText().toCharArray()) {
					l.add(c);
				}

				m.retirerLettreMain(l);

				/* if the data was successfully moved, clear it */
				if (event.getTransferMode() == TransferMode.MOVE) {
				}
				event.consume();
			}
		});
	}

	//
	// public void dragImage() {
	// leftStatus.setText("Drag");
	//// final Object source = dragEvent.getGestureSource();
	//// final Label target = dragEvent.getGestureTarget();
	// ImageView source = img1;
	// ImageView target = img00;
	// source.setOnMouseDragged(new EventHandler <MouseEvent>() {
	// public void handle(MouseEvent event) {
	// System.out.println("DRAG");
	// /* allow any transfer mode */
	// Dragboard db = source.startDragAndDrop(TransferMode.ANY);
	//
	//// ClipboardContent content = new ClipboardContent();
	//// content.put(source.getImage());
	//// db.setContent(content);
	////
	// event.consume();
	// }
	// });
	//
	// target.setOnDragOver(new EventHandler <DragEvent>() {
	// public void handle(DragEvent event) {
	// /* data is dragged over the target */
	//// System.out.println("onDragOver");
	//
	// /* accept it only if it is not dragged from the same node
	// * and if it has a string data */
	// if (event.getGestureSource() != target &&
	// event.getDragboard().hasString()) {
	// /* allow for both copying and moving, whatever user chooses */
	// event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	// }
	//
	// event.consume();
	// }
	// });
	//
	// target.setOnDragEntered(new EventHandler <DragEvent>() {
	// public void handle(DragEvent event) {
	// /* the drag-and-drop gesture entered the target */
	//// System.out.println("onDragEntered");
	// /* show to the user that it is an actual gesture target */
	// if (event.getGestureSource() != target &&
	// event.getDragboard().hasString()) {
	//// target.setText("ENTERED");
	// }
	//
	// event.consume();
	// }
	// });
	//
	// target.setOnDragExited(new EventHandler <DragEvent>() {
	// public void handle(DragEvent event) {
	// /* mouse moved away, remove the graphical cues */
	//// target.setImage(source.getImage());
	//
	// event.consume();
	// }
	// });
	//
	// target.setOnDragDropped(new EventHandler <DragEvent>() {
	// public void handle(DragEvent event) {
	// /* data dropped */
	// System.out.println("onDragDropped");
	// /* if there is a string data on dragboard, read it and use it */
	// Dragboard db = event.getDragboard();
	// boolean success = false;
	// if (db.hasString()) {
	// target.setImage(source.getImage());
	// success = true;
	// }
	// /* let the source know whether the string was successfully
	// * transferred and used */
	// event.setDropCompleted(success);
	//
	// event.consume();
	// }
	// });
	//
	// source.setOnDragDone(new EventHandler <DragEvent>() {
	// public void handle(DragEvent event) {
	// /* the drag-and-drop gesture ended */
	// System.out.println("onDragDone");
	// target.setImage(source.getImage());
	// source.setImage(null);
	// List<Character> l = new ArrayList<Character>();
	// l.add(m.getMainJoueur().get(0));
	// m.retirerLettreMain(l);
	// /* if the data was successfully moved, clear it */
	// if (event.getTransferMode() == TransferMode.MOVE) {
	//
	//
	// }
	//
	// event.consume();
	// }
	// });
	// }
	//
	@FXML
	private void initialize() {
		setRack();
		nomJoueur.setText(j.getNom());
	}
}
