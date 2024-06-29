package Univers;
/*
 * La classe Personnage représente un personnage avec un nom, un type et des points.
 * Le type peut être spécifié, comme 'Luffy' ou 'Sakura', et les points peuvent être modifiés.
 */
public class Personnage {
    private String nom;
    private int points;
    private String type; // Luffy ou Sakura

    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.points = 10; // Commence avec 10 points
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }

    public void ajouterPoints(int points) {
        this.points += points;
    }

    public void retirerPoints(int points) {
        this.points -= points;
    }

    public String getType() {
        return type;
    }
}
