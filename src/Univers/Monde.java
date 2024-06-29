package Univers;

/*
 * La classe Monde représente un environnement dans lequel un personnage évolue.
 * Elle maintient une référence à un personnage et à la localisation actuelle dans ce monde.
 */

public class Monde {
    private Personnage personnage;
    private String lieuActuel;

    public Monde() {
        this.lieuActuel = "East Blue";
    }

    public Monde(Personnage personnage) {
        this.personnage = personnage;
        this.lieuActuel = "East Blue";
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public String getLieuActuel() {
        return lieuActuel;
    }

    public void setLieuActuel(String lieuActuel) {
        this.lieuActuel = lieuActuel;
    }
}
