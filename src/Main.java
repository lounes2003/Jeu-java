import Univers.PersonnageDeBase;

public class Main {
    public static void main(String[] args) {
        System.out.println("Que le jeu one piece commence !");
        // Création des instances des personnages
        PersonnageDeBase luffy = new PersonnageDeBase("Monkey D. Luffy", "Un jeune pirate plein de fougue et d'espoir avec des techniques plus fortes les unes que les autres", 10);
        PersonnageDeBase yamamoto = new PersonnageDeBase("Yamamoto", "Une kunoichi déterminée à prouver sa valeur dotée d’une force brute incroyable", 10);

        // Utilisation des instances
        System.out.println("Personnage 1 : " + luffy.getNom());
        System.out.println("Description : " + luffy.getDescription());
        System.out.println("Points de vie : " + luffy.getPoints());

        System.out.println("Personnage 2 : " + yamamoto.getNom());
        System.out.println("Description : " + yamamoto.getDescription());
        System.out.println("Points de vie : " + yamamoto.getPoints());
    }
}
