package Univers;

public class Cle {
    private String description;
    private String indication;

    public Cle(String description, String indication) {
        this.description = description;
        this.indication = indication;
    }

    public void resoudre() {
        System.out.println("Résolution avec la clé : " + description);
    }

    public void ouvrir() {
        System.out.println("Ouverture avec la clé : " + description);
    }

    public String getDescription() {
        return description;
    }

    public String getIndication() {
        return indication;
    }
}
