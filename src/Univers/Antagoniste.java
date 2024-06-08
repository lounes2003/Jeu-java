package Univers;

public class Antagoniste extends PersonnageDeBase {
    public Antagoniste(int pointsDeVie, int force) {
        super(pointsDeVie, force);
    }

    @Override
    public void combattre() {
        System.out.println("L'antagoniste combat avec une force de " + force);
    }

    @Override
    public void avancer() {
        System.out.println("L'antagoniste avance.");
    }

    @Override
    public void ouvrir() {
        System.out.println("L'antagoniste ouvre une porte.");
    }
}
