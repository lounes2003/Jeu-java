package Univers;

public class Allie {
    private String nom;
    private String description;
    private int pointsAide;

    public Allie(String nom, String description, int pointsAide) {
        this.nom = nom;
        this.description = description;
        this.pointsAide = pointsAide;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPointsAide() {
        return pointsAide;
    }

    public void setPointsAide(int pointsAide) {
        this.pointsAide = pointsAide;
    }
}

