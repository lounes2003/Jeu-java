import Representation.Jeu;

/*
 * Classe principale pour démarrer le jeu.
 * Cette classe contient la méthode main, qui est le point d'entrée du programme.
 * Elle crée une instance de la classe Jeu et démarre le jeu en appelant la méthode jeu.
 */

public class Main {
    public static void main(String[] args) {
        Jeu jeu1 = new Jeu();
        jeu1.jeu();
    }
}