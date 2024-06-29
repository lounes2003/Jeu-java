package Representation;

import Univers.Monde;
import Univers.Personnage;
import java.util.Scanner;
/* cette classe represente le node ou y a des décisions qui impacte le parcours et l'histoire
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
 */
public class DecisionNode extends Node {
    private Monde monde;
    private NoeudTerminal fin;

    public DecisionNode(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
        this.fin = new NoeudTerminal(1000, "FIN", monde);
    }

    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }

    @Override
    public void display(int id) {
        NodeN nami = new NodeN(1000, "hehe", monde);
        NodeU ussop = new NodeU(1000, "hehe", monde);
        NodeZ zoro = new NodeZ(1000, "hehe", monde);

        if (id == 1) {
            System.out.println("1: Monkey D. Luffy\n2: Sakura Haruno");
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.next();
            Personnage personnage;

            while (!choix.equals("1") && !choix.equals("2")) {
                System.out.println("Erreur. Entrez 1 ou 2 :");
                choix = scanner.next();
            }

            if (choix.equals("1")) {
                personnage = new Personnage("Monkey D. Luffy", "Luffy");
                monde.setPersonnage(personnage); // Assurez-vous de définir le personnage dans Monde
                System.out.println("Vous avez choisi Monkey D. Luffy.");
                System.out.println("un jeune pirate plein de fougue et d'espoir avec des techniques plus fortes les unes que les autres.");
                System.out.println("Voulez-vous voir à quoi ressemble votre personnage. Entrez 'O' pour oui et 'N' pour non.");
                Scanner s = new Scanner (System.in);
                String c = s.next().toUpperCase();
                while (!c.equals("O") && !c.equals("N")) {
                    System.out.println("Erreur. Entrez O ou N :");
                    c = scanner.next();
                }
                if(c.equals("O")){
                    // Chemin de l'image
                    String imagePath = "C://Users//boudi/Downloads/OIP.jpg";
                    // Créer une instance de ImageDisplay
                    ImageDisplay imageDisplay = new ImageDisplay(imagePath);
                    // Afficher l'image dans un cadre
                    imageDisplay.showImageInFrame();
                }
                afficherPoints();

            } else if (choix.equals("2")) {
                personnage = new Personnage("Sakura Haruno", "Sakura");
                monde.setPersonnage(personnage); // Assurez-vous de définir le personnage dans Monde
                System.out.println("Vous avez choisi Sakura Haruno.");
                System.out.println("une kunoichi déterminée à prouver sa valeur dotée d’une force brute incroyable.");
                System.out.println("Voulez-vous voir à quoi ressemble votre personnage. Entrez 'O' pour oui et 'N' pour non.");
                Scanner s = new Scanner (System.in);
                String c = s.next().toUpperCase();
                while (!c.equals("O") && !c.equals("N")) {
                    System.out.println("Erreur. Entrez O ou N :");
                    c = scanner.next();
                }
                if(c.equals("O")){
                    // Chemin de l'image
                    String imagePath = "C://Users//boudi/Downloads/B.jpg";
                    // Créer une instance de ImageDisplay
                    ImageDisplay imageDisplay = new ImageDisplay(imagePath);
                    // Afficher l'image dans un cadre
                    imageDisplay.showImageInFrame();
                }
                afficherPoints();
            }
        }

        if (id == 2) {
            System.out.println("1: Nami\n2: Ussop\n3: Zoro");
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.next();

            while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3")) {
                System.out.println("Erreur. Entrez 1, 2 ou 3 :");
                choix = scanner.next();
            }

            if (choix.equals("1")) {
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Vous avez choisi comme allié Nami.");
                System.out.println("Voulez-vous voir à quoi ressemble votre alliée. Entrez 'O' pour oui et 'N' pour non.");
                Scanner s = new Scanner (System.in);
                String c = s.next().toUpperCase();
                while (!c.equals("O") && !c.equals("N")) {
                    System.out.println("Erreur. Entrez O ou N :");
                    c = scanner.next();
                }
                if(c.equals("O")){
                    // Chemin de l'image
                    String imagePath = "C://Users//boudi/Downloads/N.jpg";
                    // Créer une instance de ImageDisplay
                    ImageDisplay imageDisplay = new ImageDisplay(imagePath);
                    // Afficher l'image dans un cadre
                    imageDisplay.showImageInFrame();
                }
                System.out.println("Votre chemin sera plus rapide et court.");
                System.out.println("Vous gagnez 10 points supplémentaires.");
                monde.getPersonnage().ajouterPoints(10);
                afficherPoints();
                System.out.println("Une énigme s'offre à vous afin d'avoir le plus possible de points avant votre combat final.");
                System.out.println("----------------------------------------------------------------------------");
                nami.display(10);
            } else if (choix.equals("2")) {
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Vous avez choisi comme allié Ussop.");
                System.out.println("Voulez-vous voir à quoi ressemble votre allié. Entrez 'O' pour oui et 'N' pour non.");
                Scanner s = new Scanner (System.in);
                String c = s.next().toUpperCase();
                while (!c.equals("O") && !c.equals("N")) {
                    System.out.println("Erreur. Entrez O ou N :");
                    c = scanner.next();
                }
                if(c.equals("O")){
                    // Chemin de l'image
                    String imagePath = "C://Users//boudi/Downloads/U.jpg";
                    // Créer une instance de ImageDisplay
                    ImageDisplay imageDisplay = new ImageDisplay(imagePath);
                    // Afficher l'image dans un cadre
                    imageDisplay.showImageInFrame();
                }
                System.out.println("Votre chemin sera un peu plus long.");
                afficherPoints();
                System.out.println("Vous devrez trouver une clé afin d'atteindre le boss final sinon c'est la mort assurée.");
                System.out.println("Ensuite une énigme pour gagner des points en plus vous sera proposée.");
                System.out.println("----------------------------------------------------------------------------");
                ussop.display(11);
            } else if (choix.equals("3")) {
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Vous avez choisi comme allié Zoro.");
                System.out.println("Voulez-vous voir à quoi ressemble votre allié. Entrez 'O' pour oui et 'N' pour non.");
                monde.getPersonnage().retirerPoints(10);
                afficherPoints();
                fin.pointsNégatifs();
                Scanner s = new Scanner (System.in);
                String c = s.next().toUpperCase();
                while (!c.equals("O") && !c.equals("N")) {
                    System.out.println("Erreur. Entrez O ou N :");
                    c = scanner.next();
                }
                if(c.equals("O")){
                    // Chemin de l'image
                    String imagePath = "C://Users//boudi/Downloads/Z.jpg";
                    // Créer une instance de ImageDisplay
                    ImageDisplay imageDisplay = new ImageDisplay(imagePath);
                    // Afficher l'image dans un cadre
                    imageDisplay.showImageInFrame();
                }
                System.out.println("Votre chemin sera beaucoup plus long et plus difficile.");
                System.out.println("Vous serez obligé de trouver les 2 clés afin d'arriver au boss final sinon c'est la mort assurée.");
                System.out.println("Ensuite une énigme bonus vous sera proposée afin de cumuler le maximum de points.");
                System.out.println("----------------------------------------------------------------------------");
                zoro.display(12);
            }
        }
    }

    @Override
    public Node chooseNext(int id) {
        if (id == 2) {
            return new InnerNode(id, "ec", monde);
        }
        if (id == 10) {
            return new NodeN(id, "NAMI", monde);
        }
        if (id == 11) {
            return new NodeU(id, "USSOP", monde);
        }
        if (id == 12) {
            return new NodeZ(id, "ZORO", monde);
        }
        throw new IllegalArgumentException("ID non reconnu : " + id);
    }
}
