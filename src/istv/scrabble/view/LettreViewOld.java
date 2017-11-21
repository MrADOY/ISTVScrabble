/**
 * 27-10-2017
 * @author Jourdain Nicolas
 * Licence 3 FA - ISTV
 */
package istv.scrabble.view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Nicolas JOURDAIN - Sadgasmification
 * @contributor
 *
 */
public class LettreViewOld extends Parent {

	public String lettre;
	private int positionX = 0;
	private int positionY = 0;
	private int score = 0;

	Rectangle fond_lettre;
	Text text_lettre;

	/**
	 * Constructeur de Lettre
	 */
	public LettreViewOld(String l, int posX, int posY, int n) {
		lettre = new String(l);
		positionX = posX;
		positionY = posY;
		score = n;

		fond_lettre = new Rectangle(75, 75, Color.WHITE);
		fond_lettre.setArcHeight(10);
		fond_lettre.setArcWidth(10);
		Light.Distant light = new Light.Distant();
		light.setAzimuth(-45.0);
		Lighting li = new Lighting();
		li.setLight(light);
		fond_lettre.setEffect(li);

		this.getChildren().add(fond_lettre);

		text_lettre = new Text(lettre);
		text_lettre.setFont(new Font(25));
		text_lettre.setFill(Color.WHITE);
		text_lettre.setX(25);
		text_lettre.setY(45);

		this.getChildren().add(text_lettre);

		this.setTranslateX(positionX);
		this.setTranslateY(positionY);

		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				fond_lettre.setFill(Color.LIGHTGREY);
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				fond_lettre.setFill(Color.WHITE);
			}
		});
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				appuyer();
			}
		});
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				relacher();
			}
		});

		// this.setOnDragDetected(mouseEvent -> this.startFullDrag());
		this.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				drag(event);
				event.consume();
			}
		});
		//

		this.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				drop(event);
				event.consume();

			}
		});

		this.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragDone(event);
				if (event.getTransferMode() == TransferMode.MOVE) {
				}
				event.consume();
			}

		});

		this.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragOver(event);
			}
		});

	}

	public void drag(MouseEvent event) {
		this.startFullDrag();
		System.out.println("Drag");
		Dragboard db = this.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putString(this.lettre);
		db.setContent(content);
	}

	private void dragOver(DragEvent event) {
		Dragboard dragboard = event.getDragboard();
		if (dragboard.hasString()) {
			System.out.println("DragOver");
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		event.consume();
	}

	public void drop(DragEvent event) {
		Dragboard dragboard = event.getDragboard();

		if (dragboard.hasString()) {
			this.lettre = dragboard.getString();

			// Data transfer is successful
			event.setDropCompleted(true);
		} else {
			// Data transfer is not successful
			event.setDropCompleted(false);
		}

		event.consume();
		System.out.println("Drop");
	}

	public void dragDone(DragEvent event) {
		System.out.println("Done");
		// target.setText(this.lettre);
//		this.lettre = "";
		List<Character> l = new ArrayList<Character>();
		 for (char c : this.lettre.toCharArray()) {
			 l.add(c);
			 System.out.println(l);
		 }

		 
	}

	public void appuyer() {
		fond_lettre.setFill(Color.DARKGREY);
		this.setTranslateY(positionY + 2);
	}

	public void relacher() {
		fond_lettre.setFill(Color.WHITE);
		this.setTranslateY(positionY);
	}

}
