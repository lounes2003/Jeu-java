package Univers;

public class Univers {
    private String titre;
    private String introduction;
    private int points;
    private String premierChoix;
    private String rencontreAllies;

    public Univers(String titre, String introduction, int points, String premierChoix, String rencontreAllies) {
        this.titre = titre;
        this.introduction = introduction;
        this.points = points;
        this.premierChoix = premierChoix;
        this.rencontreAllies = rencontreAllies;
    }

    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPremierChoix() {
        return premierChoix;
    }

    public void setPremierChoix(String premierChoix) {
        this.premierChoix = premierChoix;
    }

    public String getRencontreAllies() {
        return rencontreAllies;
    }

    public void setRencontreAllies(String rencontreAllies) {
        this.rencontreAllies = rencontreAllies;
    }
}
