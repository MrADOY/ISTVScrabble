/**
 * 27-10-2017
 * @author Jourdain Nicolas
 * Licence 3 FA - ISTV
 */
package istv.scrabble.view;

import istv.scrabble.objets.Lettre;
import istv.scrabble.objets.Pioche;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Nicolas JOURDAIN - Sadgasmification
 * @contributor
 *
 */
@SuppressWarnings("restriction")
public class RackView extends Parent {

	LettreViewOld[] rack;
	
	/**
	 * Constructeur de rack
	 */
	public RackView() {
		
		
		Rectangle fond_clavier = new Rectangle();
		fond_clavier.setWidth(400);
		fond_clavier.setHeight(200);
		fond_clavier.setArcWidth(30);
		fond_clavier.setArcHeight(30);
		fond_clavier.setFill(
				new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#333333")), new Stop(1, Color.web("#000000")) }));
		Reflection r = new Reflection();
		r.setFraction(0.25);
		r.setBottomOpacity(0);
		r.setTopOpacity(0.5);
		fond_clavier.setEffect(r);

		this.setTranslateX(50);
		this.setTranslateY(250);
		this.getChildren().add(fond_clavier);
		
		rack = new LettreViewOld[] {
				new LettreViewOld(Pioche.piocheLettre(1).toString(),50,20,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),128,20,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),206,20,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),284,20,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),75,98,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),153,98,60),
				new LettreViewOld(Pioche.piocheLettre(1).toString(),231,98,60)
		};
		
		for (LettreViewOld lettre : rack){
            this.getChildren().add(lettre);
        }

	}

}
