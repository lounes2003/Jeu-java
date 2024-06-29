package Univers;
/*
 * La classe Cle représente une clé avec un indicateur pouvant être activé ou désactivé.
 * Elle permet de manipuler cet indicateur grâce à ses méthodes.
 * getFlag pour récuperer la donnée
 * setFlag pour modifier la donnée
 */
public class Cle {
    private boolean flag;

    public Cle(boolean flag){
        this.flag = flag;
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
