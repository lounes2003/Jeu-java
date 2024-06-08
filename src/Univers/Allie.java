package Univers;

public class Allie extends PersonnageDeBase {
    private int pointAide;

    public Allie(int pointsDeVie, int force, int pointAide) {
        super(pointsDeVie, force);
        this.pointAide = pointAide;
    }

    @Override
    public void combattre() {
        System.out.println("L'allié combat avec une force de " + force);
    }

    @Override
    public void avancer() {
        System.out.println("L'allié avance.");
    }

    @Override
    public void ouvrir() {
        System.out.println("L'allié ouvre une porte.");
    }

    public void naviguer() {
        System.out.println("L'allié navigue.");
    }

    public void donnerIndice() {
        System.out.println("L'allié donne un indice.");
    }

    public int getPointAide() {
        return pointAide;
    }
}
