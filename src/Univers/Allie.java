package Univers;

public class Allie {
    private String nom;
    private int pointsAide;

    public Allie(String nom,int pointsAide) {
        this.nom = nom;
        this.pointsAide = pointsAide;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsAide() {
        return pointsAide;
    }

    public void setPointsAide(int pointsAide) {
        this.pointsAide = pointsAide;
    }
}

