package Representation;

import Univers.Cle;
import Univers.Monde;
import Univers.Personnage;

import java.util.Scanner;

/* cette classe represente le choix de suivre NAMI
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
méthode poserclé1 est une méthode dans laquelle la clé pour avancer est créée
méthode poserenigme2 est une méthode dans laquelle l'énigme pour gagner des points est créée
méthode résoudrecleetEnigmeUssop est une méthode dans laquelle on demande a l'utilisateur de répondre a l'enigme et trouver la clé avec le respect de l'utilisation unique de l'indice
 */

public class NodeU extends Node {
    private Monde monde;
    private Scanner scanner;
    private boolean enigmeSurpriseUtilisee = false;
    private boolean aideUtilisee = false;
    private boolean flag = true;
    private NoeudTerminal fin;
    private Cle cle = new Cle(true);

    public NodeU(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
        this.scanner = new Scanner(System.in);
        this.fin = new NoeudTerminal(1000, "FIN", monde);
    }

    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }

    void resoudreCleEtEnigmeUssop() {
        // Première clé
        resoudreCle1();
        afficherPoints();
        aideUtilisee = false;

        // Deuxième énigme
        resoudreEnigme2();
        afficherPoints();
        aideUtilisee = false;
    }

    void resoudreCle1() {
        System.out.println("Clé : 'Je suis plus grand que Dieu et plus méchant que le diable. Les riches en ont besoin, les pauvres en ont et si vous le mangez, vous mourrez. Qu'est-ce que c'est ?'");
        if (!aideUtilisee) {
            System.out.println("1: Répondre ('Rien')\n2: Répondre ('L'argent')\n3: Répondre ('Le pouvoir')\n4: Répondre ('L'orgueil')\n5: Demander de l'aide à Ussop");
        } else {
            System.out.println("1: Répondre ('Rien')\n2: Répondre ('L'argent')\n3: Répondre ('Le pouvoir')\n4: Répondre ('L'orgueil')");
        }
        String choix = scanner.next();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")) {
            System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
            choix = scanner.next();
        }
        if (choix.equals("1")) {
            System.out.println("Bonne réponse ! +20 points");
            monde.getPersonnage().ajouterPoints(20);
        } else if (choix.equals("5") && !aideUtilisee) {
            System.out.println("Indice : Ce n'est pas un objet tangible.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour avoir demandé de l'aide");
            aideUtilisee = true;
            resoudreCle1(); // Redemande l'énigme après l'indice
        } else {
            cle.setFlag(false);
            fin.cleNonTrouvee(cle);
        }
    }

    void resoudreEnigme2() {
        System.out.println("Enigme : 'Quel est l'objet qui appartient à vous, mais que les autres utilisent plus souvent que vous ?'");
        System.out.println("1: Répondre ('Le temps')\n2: Répondre ('La patience')\n3: Répondre ('Notre prénom')\n4: Répondre ('Notre argent')\n5: Demander de l'aide à Ussop\n6: Ne pas répondre et passer à autre chose");

        String choix = scanner.next();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")) {
            System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
            choix = scanner.next();
        }
        if (choix.equals("3")) {
            System.out.println("Bonne réponse ! +20 points");
            monde.getPersonnage().ajouterPoints(20);
        } else if (choix.equals("5") && !aideUtilisee) {
            System.out.println("Indice : C'est quelque chose d'intangible mais personnel.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour demander de l'aide");
            aideUtilisee = true;
            resoudreEnigme2(); // Redemande l'énigme après l'indice
        } else if (choix.equals("6")) {
            System.out.println("Vous avez choisi de ne pas répondre et de passer à autre chose.");
        } else {
            System.out.println("Mauvaise réponse. -10 points");
            monde.getPersonnage().retirerPoints(10);
        }
        fin.pointsNégatifs();
    }

    public boolean getFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void display(int id) {
        if (id == 11) {
            resoudreCleEtEnigmeUssop();
            NodeCombat combat = new NodeCombat(1000, "hehe", monde);
            combat.display(22);
        }
    }

    @Override
    public Node chooseNext(int id) {
        if (id == 22) {
            return new NodeCombat(1000, "deee", monde);
        }
        return null;
    }
}
