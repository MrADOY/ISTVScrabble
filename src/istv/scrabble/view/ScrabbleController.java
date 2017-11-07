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
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
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
	private Label case01;

	@FXML
	private Label case02;

	@FXML
	private Label case03;

	@FXML
	private Label case04;

	@FXML
	private Label case05;

	@FXML
	private Label case06;

	@FXML
	private Label case07;

	@FXML
	private Label case08;

	@FXML
	private Label case09;

	@FXML
	private Label case010;

	@FXML
	private Label case011;

	@FXML
	private Label case012;

	@FXML
	private Label case013;

	@FXML
	private Label case014;

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
		// System.out.println("SOURCE : " + source2);
		return source2;
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(FenetreScrabble main) {
		this.mainApp = main;
	}
	
	  @FXML
	  public Node selectSource(MouseEvent event)
	    {
//	    String source1 = event.getSource().toString(); //yields complete string
	    Node source2 = event.getPickResult().getIntersectedNode(); //returns JUST the id of the object that was clicked
//	    System.out.println("Full String: " + source1);
//	    System.out.println("Just the id: " + source2);
//	    System.out.println(" " + source2);
	    return source2;
	    }

	public void melange() {
		m.melangerMain(m.getMainJoueur());
		afficheMain();
		setRack();
	}

	private void setRack() {
		List<LettreView> liste = new ArrayList<LettreView>();
		for (Character lm : m.getMainJoueur()) {
			LettreView l = new LettreView(lm.toString());
//			System.out.println(l.lettre);
			liste.add(l);
			
		}
		System.out.println(m.getMainJoueur());
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
			// System.out.println(m.getMainJoueur());
			// System.out.println(m.getMainJoueur().size());
			if (m.getMainJoueur().size() >= 1)
				rack1.setText(liste.get(0).lettre);
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
				rack2.setText(liste.get(1).lettre);
			else {
				rack2.setText("");
				rack3.setText("");
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 3)
				rack3.setText(liste.get(2).lettre);
			else {
				rack3.setText("");
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 4)
				rack4.setText(liste.get(3).lettre);
			else {
				rack4.setText("");
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 5)
				rack5.setText(liste.get(4).lettre);
			else {
				rack5.setText("");
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 6)
				rack6.setText(liste.get(5).lettre);
			else {
				rack6.setText("");
				rack7.setText("");
			}
			if (m.getMainJoueur().size() >= 7)
				rack7.setText(liste.get(6).lettre);
			else
				rack7.setText("");
		}
	}

	@FXML
	private void piocher() {
		int nbPieces = 7 - m.getMainJoueur().size();
		m.ajoutLettreMain(Pioche.piocheLettre(nbPieces));
		afficheMain();
	}

	@FXML
	/* Liste d'int => col - row */
	private Node mouseEntered(MouseEvent e) {
		Node source = e.getPickResult().getIntersectedNode();
		Integer colIndex = GridPane.getColumnIndex(source);
		Integer rowIndex = GridPane.getRowIndex(source);
		int col = colIndex == null ? 0 : colIndex;
		int row = rowIndex == null ? 0 : rowIndex;
		/* DEBUG */
		List<Integer> id = new ArrayList<Integer>();
		id.add(col);
		id.add(row);
		/* Fin DEBUG */
		return source;

	}

	@FXML
	private void afficheMain() {
		leftStatus.setText(m.getMainJoueur().toString());
		// setRack();
	}

	@FXML
	private void dragText(DragEvent event) {
		// final Object source = dragEvent.getGestureSource();
		// final Label target = dragEvent.getGestureTarget();
		System.out.println("Drag");
		Object sourceDrag = event.getGestureSource();
		System.out.println(sourceDrag);

		// Node targetDrag = selectTargetLabel(event);
		// // Label source = (Label) sourceDrag;
		// Label source = (Label) sourceDrag;
		//// Label target = (Label) mouseEntered(event);
		// System.out.println(sourceDrag);

		// target.setOnDragOver(new EventHandler<DragEvent>() {
		// public void handle(DragEvent event) {
		// /* data is dragged over the target */
		// // System.out.println("onDragOver");
		//
		// /*
		// * accept it only if it is not dragged from the same node and if it has a
		// string
		// * data
		// */
		// if (event.getGestureSource() != target && event.getDragboard().hasString()) {
		// /* allow for both copying and moving, whatever user chooses */
		// event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		// }
		//
		// event.consume();
		// }
		// });
		//
		// target.setOnDragEntered(new EventHandler<DragEvent>() {
		// public void handle(DragEvent event) {
		// /* the drag-and-drop gesture entered the target */
		// // System.out.println("onDragEntered");
		// /* show to the user that it is an actual gesture target */
		// if (event.getGestureSource() != target && event.getDragboard().hasString()) {
		// target.setText("ENTERED");
		// }
		//
		// event.consume();
		// }
		// });
		//
		// target.setOnDragExited(new EventHandler<DragEvent>() {
		// public void handle(DragEvent event) {
		// /* mouse moved away, remove the graphical cues */
		// target.setText("");
		//
		// event.consume();
		// }
		// });
		//
		// target.setOnDragDropped(new EventHandler<DragEvent>() {
		// public void handle(DragEvent event) {
		// /* data dropped */
		// // System.out.println("onDragDropped");
		// /* if there is a string data on dragboard, read it and use it */
		// Dragboard db = event.getDragboard();
		// boolean success = false;
		// if (db.hasString()) {
		// target.setText(db.getString());
		// success = true;
		// }
		// /*
		// * let the source know whether the string was successfully transferred and
		// used
		// */
		// event.setDropCompleted(success);
		//
		// event.consume();
		// }
		// });
		//
		//
	}

	@FXML
	private void initialize() {
		piocher();
		setRack();
		nomJoueur.setText(j.getNom());
	}
}
