/**
 * 24-10-2017
 * @author Jourdain Nicolas
 * Licence 3 FA - ISTV
 */
package istv.scrabble.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.FenetreScrabble;
import istv.scrabble.objets.Scrabble;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nicolas JOURDAIN - Sadgasmification
 * @contributor
 *
 */
@SuppressWarnings("restriction")
public class ScrabbleController implements Initializable {

	@SuppressWarnings("unused")
	private FenetreScrabble mainApp;
	@SuppressWarnings("unused")
	private Scrabble scrabble = new Scrabble("Marcel", "Michel");
	Node target = null;
	Node source = null;
	int i = -1;
	int j = -1;
	String style = "Wood";
	
	@FXML
    private TextArea console;
    
	@FXML
	private Label scoresNomJ1;
	
	@FXML
	private Label scoresNomJ2;
	
	@FXML
	private Label scoresJ1;
	
	@FXML
	private Label nbTour;
	
	@FXML
	private Label scoresJ2;
	
	@FXML
	private Label messages;

	@FXML
	private AnchorPane debugNode;

	@FXML
	private MenuItem showDebug;
	
	@FXML
	private MenuItem hideDebug;

	@FXML
	private GridPane rack;

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
	private Label nomJoueur;
	
//	private static final LettreView customFormat =
//		    new LettreView("a");


	public void appendText(String valueOf) {
		Platform.runLater(() -> console.appendText(valueOf));
	}

	public void initialize(URL location, ResourceBundle resources) {
		piocher();
		setRack();
		String nomJ1 = Scrabble.getJoueur1().getNom();
		String nomJ2 = Scrabble.getJoueur2().getNom();
		scoresNomJ1.setText(nomJ1);
		scoresNomJ2.setText(nomJ2);
		setScores();
		setTour();
		nomJoueur.setText(Scrabble.getJoueurActuel().getNom());
		debugNode.setVisible(false);
		
		img1.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img1.setOnMouseReleased((event) -> {
//			System.out.println(event);
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(0, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});

		img2.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img2.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(1, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
		img3.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img3.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(2, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
		img4.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img4.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(3, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
		img5.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img5.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(4, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
		img6.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img6.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(5, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
		img7.setOnMousePressed((event) -> {
			source = getSource(event);
		});
		img7.setOnMouseReleased((event) -> {
			target = getTarget(event);
			if (!(target.getId().equals("img7") || target.getId().equals("img6") || target.getId().equals("img5") || target.getId().equals("img4") || target.getId().equals("img3") || target.getId().equals("img2") || target.getId().equals("img1"))) {
			
				// => Get I
				i =(int) target.getLayoutX() / 30;
				// => Get J
				j =(int) target.getLayoutY() / 30;
				
				// TODO Vérifier taille tableau pour poser cellule (i< XX && j< YY)
				if(i>=0 && j>=0 && i<15 && j<15){
					if(Scrabble.getJoueurActuel().poserCellule2(6, i, j)){
						((ImageView) target).setImage(((ImageView) source).getImage());
						messages.setText("");
					}
					else
						messages.setText("Vous ne pouvez pas jouer ici");
					setRack();
				}
			}
		});
		
	}

	@FXML
	private void tourSuivant(){
		if(Scrabble.verificationFinTour2()){
			nomJoueur.setText(Scrabble.getJoueurActuel().getNom());
			setRack();
		}
		setScores();
		setTour();
	}
	
	@FXML
	private void styleSuivant(){
		if(style == "Wood"){
			style = "Marble";
		}
		else if(style == "Marble"){
			style = "Metal";
		}
		else if(style == "Metal"){
			style = "Wood";
		}
		setRack();
	}
	

	private void setTour(){
		nbTour.setText(String.valueOf(Scrabble.nbTour));
	}
	
	
	private void setScores(){
		String scoreJ1 = Scrabble.getJoueur1().getScore() + "";
		String scoreJ2 = Scrabble.getJoueur2().getScore() + "";
		scoresJ1.setText(scoreJ1);
		scoresJ2.setText(scoreJ2);
	}
	
	@FXML
	private void annulerCoup(){
		Scrabble.plateau.supprimerPileCaseJouee();		
	}
	
	public void setDebug() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				appendText(String.valueOf((char) b));
			}
		};
		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	public void setConsole() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// FIXME Rediriger vers le terminal
				// System.console().writer().println(String.valueOf((char)b));
				// System.out.println("Console is :" + System.console());
				Platform.runLater(() -> console.appendText(String.valueOf((char) b)));
			}
		};
		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	@FXML
	private Node selectSourceLabel(DragEvent event) {
		String source1 = event.getSource().toString(); // yields complete string
		// Node source3 = event.getPickResult().getIntersectedNode(); //yields complete
		// string
		// Object source3 = event.getSource(); //yields complete string
		// System.out.println(source3);
		Node source2 = event.getPickResult().getIntersectedNode(); // returns JUST the id of the object that was clicked
		System.out.println("Full String: " + source1);
		// System.out.println("Just the id: " + source2);
		System.out.println("SOURCE : " + source2);
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

	// @FXML
	// private Node selectSource(MouseEvent event)
	// {
	//// String source1 = event.getSource().toString(); //yields complete string
	// Node source2 = event.getPickResult().getIntersectedNode(); //returns JUST the
	// id of the object that was clicked
	//// System.out.println("Full String: " + source1);
	//// System.out.println("Just the id: " + source2);
	//// System.out.println(" " + source2);
	// return source2;
	// }

	public void melange() {
		Scrabble.getJoueurActuel().getMain().melangerMain();
		afficheMain();
		setRack();
	}

	private void setRack() {
		List<LettreView> liste = new ArrayList<LettreView>();
		for (CelluleImpl lm : Scrabble.getJoueurActuel().getMain().getCellulesJoueur()) {
			LettreView l = new LettreView(lm.getLettre().toString(), style);
			liste.add(l);
		}

		if (!Scrabble.getJoueurActuel().getMain().getCellulesJoueur().isEmpty()) {
			
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 1) {
				img1.setImage(liste.get(0).getImg());
//				img1.setImage(new Image("file:resources/" + style +"/letter_" + liste.get(0).getLettre() + ".png"));
			} else {
				img1.setImage(null);
				img2.setImage(null);
				img3.setImage(null);
				img4.setImage(null);
				img5.setImage(null);
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 2) {
				img2.setImage(liste.get(1).getImg());
			} else {
				img2.setImage(null);
				img3.setImage(null);
				img4.setImage(null);
				img5.setImage(null);
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 3) {
				img3.setImage(liste.get(2).getImg());
			} else {
				img3.setImage(null);
				img4.setImage(null);
				img5.setImage(null);
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 4) {
				img4.setImage(liste.get(3).getImg());
			} else {
				img4.setImage(null);
				img5.setImage(null);
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 5) {
				img5.setImage(liste.get(4).getImg());
			} else {
				img5.setImage(null);
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 6) {
				img6.setImage(liste.get(5).getImg());
			} else {
				img6.setImage(null);
				img7.setImage(null);
			}
			if (Scrabble.getJoueurActuel().getMain().getCellulesJoueur().size() >= 7) {
				img7.setImage(liste.get(6).getImg());
			} else {
				img7.setImage(null);
			}
		}
		else
		{
			img1.setImage(null);
			img2.setImage(null);
			img3.setImage(null);
			img4.setImage(null);
			img5.setImage(null);
			img6.setImage(null);
			img7.setImage(null);
		}
	}

	@FXML
	private void piocher() {
		Scrabble.getJoueurActuel().getMain().piocherLettreManquante();
		afficheMain();
		setRack();
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
		Scrabble.getJoueurActuel().getMain().toString();
//		messages.setText(Scrabble.getJoueurActuel().getMain().getCellulesJoueur().toString());
	}

	// @FXML
	// private Node getSource(MouseEvent event) {
	// ImageView source = (ImageView) event.getPickResult().getIntersectedNode();
	// Image image = source.getImage();
	// // System.out.println(source);
	// // System.out.println(image);
	//
	// System.out.println("Source " + event.getPickResult().getIntersectedNode());
	//
	// return event.getPickResult().getIntersectedNode();
	// //
	// // Node targetDrag = selectTargetLabel(event);
	// // // Label source = (Label) sourceDrag;
	// // Label source = (Label) sourceDrag;
	// // // Label target = (Label) mouseEntered(event);
	// //
	// //
	// // target.setOnDragOver(new EventHandler<DragEvent>() {
	// // public void handle(DragEvent event) {
	// // /* data is dragged over the target */
	// // // System.out.println("onDragOver");
	// //
	// // /*
	// // * accept it only if it is not dragged from the same node and if it has a
	// // string
	// // * data
	// // */
	// // if (event.getGestureSource() != target &&
	// event.getDragboard().hasString()) {
	// // /* allow for both copying and moving, whatever user chooses */
	// // event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	// // }
	// //
	// // event.consume();
	// // }
	// // });
	// //
	// // target.setOnDragEntered(new EventHandler<DragEvent>() {
	// // public void handle(DragEvent event) {
	// // /* the drag-and-drop gesture entered the target */
	// // // System.out.println("onDragEntered");
	// // /* show to the user that it is an actual gesture target */
	// // if (event.getGestureSource() != target &&
	// event.getDragboard().hasString()) {
	// // target.setText("ENTERED");
	// // }
	// //
	// // event.consume();
	// // }
	// // });
	// //
	// // target.setOnDragExited(new EventHandler<DragEvent>() {
	// // public void handle(DragEvent event) {
	// // /* mouse moved away, remove the graphical cues */
	// // target.setText("");
	// //
	// // event.consume();
	// // }
	// // });
	// //
	// // target.setOnDragDropped(new EventHandler<DragEvent>() {
	// // public void handle(DragEvent event) {
	// // /* data dropped */
	// // // System.out.println("onDragDropped");
	// // /* if there is a string data on dragboard, read it and use it */
	// // Dragboard db = event.getDragboard();
	// // boolean success = false;
	// // if (db.hasString()) {
	// // target.setText(db.getString());
	// // success = true;
	// // }
	// // /*
	// // * let the source know whether the string was successfully transferred and
	// // used
	// // */
	// // event.setDropCompleted(success);
	// //
	// // event.consume();
	// // }
	// // });
	// //
	//
	// }

	@FXML
	private Node getSource(MouseEvent event) {
//		ImageView source = (ImageView) event.getPickResult().getIntersectedNode();
//		Image image = source.getImage();
		// System.out.println(source);
		// System.out.println(image);

//		System.out.println("Source " + event.getPickResult().getIntersectedNode());

		return event.getPickResult().getIntersectedNode();
	}

	@FXML
	private Node getTarget(MouseEvent event) {
//		System.out.println("Target " + event.getPickResult().getIntersectedNode());
		return event.getPickResult().getIntersectedNode();
	}

	@FXML
	private Node getTargetDrop(DragEvent event) {
//		System.out.println("Target " + event.getPickResult().getIntersectedNode());
		return event.getPickResult().getIntersectedNode();
	}
	
	@FXML
	private void handleButtonClick(ActionEvent event) {
		if (event.getSource() == showDebug) {
			setDebug();
			debugNode.setVisible(true);
		} else if (event.getSource() == hideDebug) {
			setConsole();
			debugNode.setVisible(false);
		}
	}

	@FXML
	private void draggingOver(DragEvent event) {
		Dragboard board = event.getDragboard();
		if (board.hasFiles()) {
			event.acceptTransferModes(TransferMode.ANY);
		}
	}

	@FXML
	private void dropping(DragEvent event) {
		try {
			Dragboard board = event.getDragboard();
			List<File> phil = board.getFiles();
			FileInputStream fis;
			fis = new FileInputStream(phil.get(0));

			StringBuilder builder = new StringBuilder();
			int ch;
			while ((ch = fis.read()) != -1) {
				builder.append((char) ch);
			}

			fis.close();

			console.setText(builder.toString());

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@FXML
	private void drop(DragEvent event) {
//		Dragboard board = event.getDragboard();
		StringBuilder builder = new StringBuilder();
		console.setText(builder.toString());
	}

	// @FXML
	// private void initialize() {
	// piocher();
	//// setRack();
	// nomJoueur.setText(j.getNom());
	// }
}