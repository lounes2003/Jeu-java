package Univers;

public class PersonnageDeBase {
    private String nom;
    private String description;
    private int points;

    public PersonnageDeBase(String nom, String description, int points) {
        this.nom = nom;
        this.description = description;
        this.points = points;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
