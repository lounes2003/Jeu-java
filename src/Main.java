import Univers.*;
import Representation.*;

public class Main {
    public static void main(String[] args) {
        // Initialisation des personnages
        PersonnageDeBase naruto = new Allie(100, 50, 20);
        PersonnageDeBase sakura = new Allie(80, 40, 30);

        // Initialisation des énigmes et des clés
        Enigme enigme1 = new Enigme(
                "Je suis plus grand que Dieu et plus méchant que le diable. Les riches en ont besoin, les pauvres en ont et si vous le mangez, vous mourrez. Qu'est-ce que c'est ?",
                new String[]{"1. Rien", "2. Tout", "3. Amour", "4. Haine"}
        );

        Cle cle1 = new Cle("Clé mystique", "Cette clé ouvre une porte vers un trésor caché.", 50);

        // Initialisation des noeuds
        TerminalNode fin = new TerminalNode(4, "Vous avez atteint la fin de votre aventure.");
        DecisionNode debut = new DecisionNode(1, "Choisissez votre personnage : \n1. Naruto\n2. Sakura", new Node[]{fin, fin});

        // Démarrer le jeu
        Node currentNode = debut;
        while (!(currentNode instanceof TerminalNode)) {
            currentNode.display();
        }
    }
}
