package Univers;

public class PersonnageDeBase extends Personnage {
    private String description;
    private int points;

    public PersonnageDeBase(String nom, String description) {
        super(nom);
        this.description = description;
        this.points = 10;
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
