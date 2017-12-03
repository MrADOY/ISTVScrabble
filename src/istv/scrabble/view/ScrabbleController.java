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
import istv.scrabble.objets.Joueur;
import istv.scrabble.objets.Main;
import istv.scrabble.objets.Pioche;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class ScrabbleController implements Initializable {

	/**
	 * Constructeur de ScrabbleController
	 */
	public ScrabbleController() {
		// TODO Auto-generated constructor stub
	}

	private FenetreScrabble mainApp;
	private Main m = new Main();
	private Joueur j = new Joueur("Bob");
	private Pioche p = new Pioche();

	@FXML
    private TextArea console;
    
	@FXML
	private Label leftStatus;

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

	

    public void appendText(String valueOf) {
        Platform.runLater(() -> console.appendText(valueOf));
    }

    public void initialize(URL location, ResourceBundle resources) {
    		piocher();
		setRack();
		nomJoueur.setText(j.getNom());
		debugNode.setVisible(false);
    }
	
    public void setDebug() {
      OutputStream out = new OutputStream() {
          @Override
          public void write(int b) throws IOException {
              appendText(String.valueOf((char)b));
          }
      };
      System.setOut(new PrintStream(out, true));
      System.setErr(new PrintStream(out, true));
    }
    
    public void setConsole() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            	//FIXME Rediriger vers le terminal
//            	System.console().writer().println(String.valueOf((char)b));
//            	System.out.println("Console is :" + System.console());
            	Platform.runLater(() -> console.appendText(String.valueOf((char)b)));
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
	
//	  @FXML
//	  private Node selectSource(MouseEvent event)
//	    {
////	    String source1 = event.getSource().toString(); //yields complete string
//	    Node source2 = event.getPickResult().getIntersectedNode(); //returns JUST the id of the object that was clicked
////	    System.out.println("Full String: " + source1);
////	    System.out.println("Just the id: " + source2);
////	    System.out.println(" " + source2);
//	    return source2;
//	    }

	public void melange() {
		m.melangerMain();
		afficheMain();
		setRack();
	}
	
	private void setRack() {
		List<LettreView> liste = new ArrayList<LettreView>();
		for (CelluleImpl lm : m.getCellulesJoueur()) {
			LettreView l = new LettreView(lm.getLettre().toString());
//			System.out.println(l.lettre);
			liste.add(l);
			
		}
		
		if (!m.getCellulesJoueur().isEmpty()) {
			img1.setImage(new Image("file:resources/Wood/letter_" + liste.get(0).lettre + ".png"));
			img2.setImage(new Image("file:resources/Wood/letter_" + liste.get(1).lettre + ".png"));
			img3.setImage(new Image("file:resources/Wood/letter_" + liste.get(2).lettre + ".png"));
			img4.setImage(new Image("file:resources/Wood/letter_" + liste.get(3).lettre + ".png"));
			img5.setImage(new Image("file:resources/Wood/letter_" + liste.get(4).lettre + ".png"));
			img6.setImage(new Image("file:resources/Wood/letter_" + liste.get(5).lettre + ".png"));
			img7.setImage(new Image("file:resources/Wood/letter_" + liste.get(6).lettre + ".png"));
			
			
			
			if (m.getCellulesJoueur().size() >= 1)
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
//			if (m.getMainJoueur().size() >= 2)
//				rack2.setText(liste.get(1).lettre);
//			else {
//				rack2.setText("");
//				rack3.setText("");
//				rack4.setText("");
//				rack5.setText("");
//				rack6.setText("");
//				rack7.setText("");
//			}
//			if (m.getMainJoueur().size() >= 3)
//				rack3.setText(liste.get(2).lettre);
//			else {
//				rack3.setText("");
//				rack4.setText("");
//				rack5.setText("");
//				rack6.setText("");
//				rack7.setText("");
//			}
//			if (m.getMainJoueur().size() >= 4)
//				rack4.setText(liste.get(3).lettre);
//			else {
//				rack4.setText("");
//				rack5.setText("");
//				rack6.setText("");
//				rack7.setText("");
//			}
//			if (m.getMainJoueur().size() >= 5)
//				rack5.setText(liste.get(4).lettre);
//			else {
//				rack5.setText("");
//				rack6.setText("");
//				rack7.setText("");
//			}
//			if (m.getMainJoueur().size() >= 6)
//				rack6.setText(liste.get(5).lettre);
//			else {
//				rack6.setText("");
//				rack7.setText("");
//			}
//			if (m.getMainJoueur().size() >= 7)
//				rack7.setText(liste.get(6).lettre);
//			else
//				rack7.setText("");
		}
	}

	@FXML
	private void piocher() {
		m.piocherLettreManquante();
		afficheMain();
	}

//	@FXML
//	/* Liste d'int => col - row */
//	private Node mouseEntered(MouseEvent e) {
//		Node source = e.getPickResult().getIntersectedNode();
//		Integer colIndex = GridPane.getColumnIndex(source);
//		Integer rowIndex = GridPane.getRowIndex(source);
//		int col = colIndex == null ? 0 : colIndex;
//		int row = rowIndex == null ? 0 : rowIndex;
//		/* DEBUG */
//		List<Integer> id = new ArrayList<Integer>();
//		id.add(col);
//		id.add(row);
//		/* Fin DEBUG */
//		return source;
//
//	}

	@FXML
	private void afficheMain() {
		m.afficherMainJoueur();
		leftStatus.setText(m.getCellulesJoueur().toString());
	}

	 
	
	@FXML
	private void dragText(MouseEvent event) {
		String source1 = event.getSource().toString(); //yields complete string
	    String source2 = event.getPickResult().getIntersectedNode().getId(); //returns JUST the id of the object that was clicked
	    System.out.println("Full String: " + source1);
	    System.out.println("Just the id: " + source2);
	    System.out.println(" " + source2);
	    img2.setStyle("-fx-image: url(file:resources/Wood/letter_" + m.getCellulesJoueur().get(0).getLettre() + ".png);");
	    
//
//		 Node targetDrag = selectTargetLabel(event);
//		 // Label source = (Label) sourceDrag;
//		 Label source = (Label) sourceDrag;
//		// Label target = (Label) mouseEntered(event);
//		 System.out.println(sourceDrag);
//
//		 target.setOnDragOver(new EventHandler<DragEvent>() {
//		 public void handle(DragEvent event) {
//		 /* data is dragged over the target */
//		 // System.out.println("onDragOver");
//		
//		 /*
//		 * accept it only if it is not dragged from the same node and if it has a
//		 string
//		 * data
//		 */
//		 if (event.getGestureSource() != target && event.getDragboard().hasString()) {
//		 /* allow for both copying and moving, whatever user chooses */
//		 event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//		 }
//		
//		 event.consume();
//		 }
//		 });
//		
//		 target.setOnDragEntered(new EventHandler<DragEvent>() {
//		 public void handle(DragEvent event) {
//		 /* the drag-and-drop gesture entered the target */
//		 // System.out.println("onDragEntered");
//		 /* show to the user that it is an actual gesture target */
//		 if (event.getGestureSource() != target && event.getDragboard().hasString()) {
//		 target.setText("ENTERED");
//		 }
//		
//		 event.consume();
//		 }
//		 });
//		
//		 target.setOnDragExited(new EventHandler<DragEvent>() {
//		 public void handle(DragEvent event) {
//		 /* mouse moved away, remove the graphical cues */
//		 target.setText("");
//		
//		 event.consume();
//		 }
//		 });
//		
//		 target.setOnDragDropped(new EventHandler<DragEvent>() {
//		 public void handle(DragEvent event) {
//		 /* data dropped */
//		 // System.out.println("onDragDropped");
//		 /* if there is a string data on dragboard, read it and use it */
//		 Dragboard db = event.getDragboard();
//		 boolean success = false;
//		 if (db.hasString()) {
//		 target.setText(db.getString());
//		 success = true;
//		 }
//		 /*
//		 * let the source know whether the string was successfully transferred and
//		 used
//		 */
//		 event.setDropCompleted(success);
//		
//		 event.consume();
//		 }
//		 });
//		
		
	}


	
	private Double lastX = null;
    private Double lastY = null;

	
	public void InitUi()
    {
		System.out.println("INIT DRAG");
        if (this.img1 != null)
        {
        	System.out.println("NOT NULL DRAG");
            this.img1.setOnDragOver(new EventHandler<DragEvent>()
            {
                @Override
                public void handle(DragEvent dragEvent)
                {
                    HandleMouseMovement(dragEvent.getSceneX(), dragEvent.getSceneY());
                }
            });

            this.img1.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                		System.out.println("DRAG");
                    Dragboard db = img1.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString("Does not matter");
                    db.setContent(content);
                    event.consume();

                    lastX = event.getSceneX();
                    lastY = event.getSceneY();
                }
            });
        }
    }
	
	 private synchronized void HandleMouseMovement(double sceneX, double sceneY)
	    {
	        double deltaX = sceneX - lastX;
	        double deltaY = sceneY - lastY;

	        lastX = sceneX;
	        lastY = sceneY;

	        double currentXAnchor =AnchorPane.getLeftAnchor(this.img1);
	        double currentYAnchor =AnchorPane.getTopAnchor(this.img1);

	        AnchorPane.setLeftAnchor( this.img1,  currentXAnchor + deltaX*1.5);
	        AnchorPane.setTopAnchor(this.img1, currentYAnchor + deltaY*1.5);
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
        while((ch = fis.read()) != -1){
            builder.append((char)ch);
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
        Dragboard board = event.getDragboard();
        StringBuilder builder = new StringBuilder();
        console.setText(builder.toString());
     }
	
//	@FXML
//	private void initialize() {
//		piocher();
////		setRack();
//		nomJoueur.setText(j.getNom());
//	}
}