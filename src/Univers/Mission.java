package Univers;

public class Mission {
    private String description;
    private int pointsImpact;

    public Mission(String description, int pointsImpact) {
        this.description = description;
        this.pointsImpact = pointsImpact;
    }

    public void executer() {
        System.out.println("Mission exécutée : " + description);
    }

    public String getDescription() {
        return description;
    }

    public int getPointsImpact() {
        return pointsImpact;
    }
}
