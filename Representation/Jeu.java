package Representation;

import Univers.Personnage;
import Univers.Monde;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/* cette classe represente la classe jeu qui est composé
d'une méthode void qui instance un personnage ainsi qu'un monde
puis appelle les méthodes des differents nodes pour display
puis choosenext afin de créer une suite logique et un scénario
 */

public class Jeu {
    public void jeu() {
        // Créez un personnage et un monde

        Personnage personnage = new Personnage("Monkey D. Luffy", "Luffy"); //Exemple
        Monde monde = new Monde(personnage);

        InnerNode intro = new InnerNode(1, "Introduction", monde);
        intro.display(1);
        Node choix1 = intro.chooseNext(1);
        choix1.display(1);
        Node d1 = choix1.chooseNext(2);
        d1.display(2);
        Node c1 = d1.chooseNext(50);
        c1.display(50);
        Node d2 = c1.chooseNext(3);
        d2.display(3);
        Node choix2 = d2.chooseNext(2);
        choix2.display(2);

        // Les appels pour le nodeN , nodeU , nodeZ se font dans le DecisionNode avec id=2
        // l'appel pour le NodeCombat se fait dans un des nodes choisit lors du jeu.
        // L'appel de NoeudTerminal se fait dans le nodeCombat.
    }
}
