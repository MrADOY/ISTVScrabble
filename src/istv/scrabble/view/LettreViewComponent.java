/**
 * 27-10-2017
 * @author Jourdain Nicolas
 * Licence 3 FA - ISTV
 */
package istv.scrabble.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ImageView;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Nicolas JOURDAIN - Sadgasmification
 * @contributor
 *
 */
@SuppressWarnings("restriction")
public class LettreViewComponent extends ImageView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lettre;
	private Image img;
	public static String style;

	Text text_lettre;

	/**
	 * Constructeur de Lettre
	 */
	public LettreViewComponent(String l, String style) {
		setLettre(new String(l));
		setImg(new Image("file:resources/" + style +"/letter_" + l + ".png"));
		text_lettre = new Text(getLettre());
		text_lettre.setFont(new Font(25));
		text_lettre.setFill(Color.WHITE);
		this.add(text_lettre);

		// this.setOnDragDetected(mouseEvent -> this.startFullDrag());
		this.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				drag(event);
				event.consume();
			}
		});

		this.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				drop(event);
				event.consume();

			}
		});

		this.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragDone(event);

				event.consume();
			}

		});

		this.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragOver(event);
			}
		});

		
		
	}

	public LettreViewComponent(String l) {
		setLettre(new String(l));
		setImg(new Image("file:resources/" + style +"/letter_" + l + ".png"));
		text_lettre = new Text(getLettre());
		text_lettre.setFont(new Font(25));
		text_lettre.setFill(Color.WHITE);
		this.getChildren().add(text_lettre);

		// this.setOnDragDetected(mouseEvent -> this.startFullDrag());
		this.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				drag(event);
				event.consume();
			}
		});

		this.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				drop(event);
				event.consume();

			}
		});

		this.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragDone(event);

				event.consume();
			}

		});

		this.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dragOver(event);
			}
		});

		
		
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public void drag(MouseEvent event) {
		this.startFullDrag();
		System.out.println("Drag");
		Dragboard db = this.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putString(this.getLettre());
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
			this.setLettre(dragboard.getString());

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
		TransferMode modeUsed = event.getTransferMode();

		if (modeUsed == TransferMode.MOVE) {
			this.setLettre("");
		}

		List<Character> l = new ArrayList<Character>();
		for (char c : this.getLettre().toCharArray()) {
			l.add(c);
			System.out.println(l);
		}

	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	// public void appuyer() {
	// fond_lettre.setFill(Color.DARKGREY);
	// this.setTranslateY(positionY + 2);
	// }
	//
	// public void relacher() {
	// fond_lettre.setFill(Color.WHITE);
	// this.setTranslateY(positionY);
	// }

}
