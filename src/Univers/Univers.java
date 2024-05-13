package Univers;

public class Univers {
    private String titre;
    private String introduction;


    public Univers(String titre, String introduction, int points) {
        this.titre = titre;
        this.introduction = introduction;
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
}
