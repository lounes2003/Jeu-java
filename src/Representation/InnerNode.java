package Representation;

import Univers.Monde;
import Univers.Personnage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
/* cette classe represente le node qui relie chaque node via un scénario
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
 */
public class InnerNode extends Node {

    private Monde monde;

    public InnerNode(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
    }
    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }

    @Override
    public void display(int id) {

        if (id == 1) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|                   Titre du jeu : Le Monde des Pirates                     |");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Voulez-vous voir le logo du jeu?. Tapez 'O' pour OUI et 'N' pour NON");
            Scanner scanner = new Scanner(System.in);
            String c = scanner.next();
            while (!c.equals("O") && !c.equals("N")) {
                System.out.println("Erreur. Entrez O ou N :");
                c = scanner.next();
            }
            if(c.equals("O")){
                //Chemin de l'image
                String imagePath0 = "C://Users//boudi/Downloads/ONE.jpg";
                // Créer une instance de ImageDisplay
                ImageDisplay imageDisplay0 = new ImageDisplay(imagePath0);
                // Afficher l'image dans un cadre
                imageDisplay0.showImageInFrame();
            }
            //Lancer le son
            Sound sound = new Sound();
            try {
                sound.playmusic();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
            System.out.println("Introduction :");
            System.out.println("Vous êtes un jeune marin qui voyage à travers les mers tumultueuses de l'univers où se croisent le monde One Piece.");
            System.out.println("Voulez-vous voir à quoi ressemble le paysage. Entrez 'O' pour oui et 'N' pour non.");
            Scanner s = new Scanner (System.in);
            String c1 = s.next().toUpperCase();
            while (!c1.equals("O") && !c1.equals("N")) {
                System.out.println("Erreur. Entrez O ou N :");
                c1 = s.next();
            }
            if(c1.equals("O")){
            // Chemin de l'image
            String imagePath1 = "C://Users//boudi/Downloads/wanok.jpg";
            // Créer une instance de ImageDisplay
            ImageDisplay imageDisplay1 = new ImageDisplay(imagePath1);
            // Afficher l'image dans un cadre
            imageDisplay1.showImageInFrame();}
            System.out.println("Votre destinée est entre vos mains, et chaque choix que vous ferez façonnera votre aventure.");
            System.out.println("Choix de personnage :");
        }
        if (id == 2) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Sur votre chemin vers Grand Line, vous rencontrez un groupe de chasseurs de primes redoutables.");
            System.out.println("Allez-vous affronter ces chasseurs de primes ou les éviter habilement en utilisant vos compétences?");
        }
        if (id == 3) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("En chemin, vous rencontrez des personnages emblématiques de l’univers de One Piece.");
            System.out.println("Choisissez judicieusement vos alliés car ils vous guideront vers votre but final.");
        }
    }

    @Override
    public Node chooseNext(int id) {
        if (id == 1) {
            return new DecisionNode(id, "fze",monde);
        }
        if (id == 2) {
            return new DecisionNode(id, "22",monde);
        }
        if (id == 3) {
            return new DecisionNode(id, "zz",monde);
        }
        if (id == 50) {
            return new ChanceNode(id, "D", monde);
        }
        throw new IllegalArgumentException("ID non reconnu : " + id);
    }
}
