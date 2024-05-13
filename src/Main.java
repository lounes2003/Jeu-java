import java.util.Scanner;
import Univers.PersonnageDeBase;

public class Main {

    public static void main(String[] args) {
        // Début du Jeu
        System.out.println("Que le jeu One Piece commence !");

        // Demande à l'utilisateur de choisir son sexe

        System.out.println("Choisissez votre sexe (homme/femme) : ");

        // Scanner pour récupérer l'entrée de l'utilisateur

        Scanner scanner = new Scanner(System.in);
        String sexe = scanner.nextLine();

        // Création des instances des personnages en fonction du sexe choisi

        PersonnageDeBase personnage;
        if (sexe.equalsIgnoreCase("homme")) {
            personnage = new PersonnageDeBase("Monkey D. Luffy", "Un jeune pirate plein de fougue et d'espoir avec des techniques plus fortes les unes que les autres.");
        } else {
            personnage = new PersonnageDeBase("Yamato", "Une kunoichi déterminée à prouver sa valeur dotée d’une force brute incroyable.");
        }

        // Utilisation de l'instance
        System.out.println("Personnage : " + personnage.getNom());
        System.out.println("Description : " + personnage.getDescription());
        System.out.println("Points : " + personnage.getPoints());

        // Fermeture du scanner
        scanner.close();

        // Suite du scénario ...
    }
}
