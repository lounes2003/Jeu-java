package Univers;

public abstract class PersonnageDeBase {
    protected int pointsDeVie;
    protected int force;

    public PersonnageDeBase(int pointsDeVie, int force) {
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }

    public abstract void combattre();
    public abstract void avancer();
    public abstract void ouvrir();

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getForce() {
        return force;
    }
}
