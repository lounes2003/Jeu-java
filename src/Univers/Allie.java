package Univers;

public class Allie extends Personnage {
    private int pointsAide;

    public Allie(String nom, int pointsAide) {
        super(nom);
        this.pointsAide = pointsAide;
    }

    public int getPointsAide() {
        return pointsAide;
    }

    public void setPointsAide(int pointsAide) {
        this.pointsAide = pointsAide;
    }
}
