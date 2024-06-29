package Representation;

import Univers.Cle;
import Univers.Monde;
import Univers.Personnage;

import java.util.Scanner;

/* cette classe represente le combat finale
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
méthode getflag permet de récuperer le drapeau pour savoir si la clé a ete recupere ou bien l'enigme a ete utilisé
méthode combatfinale fait appelle a la méthode combat et remet aideutilisé en false
méthode combat represente la méthode de combat avec les multiples choix possibles
 */

public class NodeCombat extends Node {
    private Monde monde;
    private Scanner scanner;
    private boolean enigmeSurpriseUtilisee = false;
    private boolean aideUtilisee = false;
    private int vieDoflamingo = 30;
    private boolean flag = true;
    private NoeudTerminal fin;
    private Cle cle = new Cle(true);
    private int gagne;

    public NodeCombat(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
        this.scanner = new Scanner(System.in);
        this.fin = new NoeudTerminal(1000,"FIN",monde);
    }

    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }
    public void combatFinal() {
        combat();
        enigmeSurpriseUtilisee=false;
    }
    public void combat() {
        System.out.println("----------------------------------------------------------------------------");
        if (enigmeSurpriseUtilisee) {
            System.out.println("Vous revenez vous battre avec Doflamingo.Bonne Chance !");
        }else {
            System.out.println("Vous faites maintenant face à Doflamingo, un ennemi ultra fort avec " + vieDoflamingo + " points de vie.");
            System.out.println("Voulez-vous voir à quoi ressemble votre ennemi. Entrez 'O' pour oui et 'N' pour non.");
            Scanner s = new Scanner (System.in);
            String c = s.next().toUpperCase();
            while (!c.equals("O") && !c.equals("N")) {
                System.out.println("Erreur. Entrez O ou N :");
                c = scanner.next();
            }
            if(c.equals("O")){
            // Chemin de l'image
                String imagePath = "C://Users//boudi/Downloads/DO.jpg";
            // Créer une instance de ImageDisplay
                ImageDisplay imageDisplay = new ImageDisplay(imagePath);
            // Afficher l'image dans un cadre
                imageDisplay.showImageInFrame();
            }
        }
        Personnage personnage = monde.getPersonnage();
        while (vieDoflamingo > 0 && personnage.getPoints() > 0) {
        if (enigmeSurpriseUtilisee) {
            System.out.println("Choisissez votre action:");
            System.out.println("1: Attaquer avec force brute.\n2: Utiliser une technique spéciale.");
        }else{
            System.out.println("Choisissez votre action:");
            System.out.println("1: Attaquer avec force brute. \n2: Utiliser une technique spéciale\n3: Fuir (énigme surprise pour des points bonus)");
        }
        String choix = scanner.next();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3")) {
                System.out.println("Erreur. Entrez un chiffre valable:");
                choix = scanner.next();
        }
        if (choix.equals("1")) {
                vieDoflamingo -= 5;
                personnage.retirerPoints(10);
                fin.pointsNégatifs();
                System.out.println("Vous avez attaqué Doflamingo. Vie de Doflamingo: " + vieDoflamingo + ". Vos points: " + personnage.getPoints());
        } else if (choix.equals("2")) {
                vieDoflamingo -= 10;
                personnage.retirerPoints(5);
                System.out.println("Vous avez utilisé une technique spéciale contre Doflamingo. Vie de Doflamingo: " + vieDoflamingo + ". Vos points: " + personnage.getPoints());
        } else if (choix.equals("3") && !enigmeSurpriseUtilisee) {
                personnage.retirerPoints(5);
                System.out.println("Vous avez fui. Vos points vont diminué vous avez maintenant: " + personnage.getPoints());
                enigmeSurprise();
        } else if (enigmeSurpriseUtilisee) {
                    System.out.println("Vous avez déjà utilisé l'énigme surprise. Vous ne pouvez plus fuir. Fin du jeu.");
                    System.out.println("Vous avez perdu.");
                    gagne=1;
                    System.exit(0);
                    return;
        }
        }
        fin.pointsNégatifs();
    }

    public void enigmeSurprise() {
        System.out.println("----------------------------------------------------------------------------");
        if(!aideUtilisee){
            System.out.println("Enigme surprise : 'Qu'est-ce qui marche à quatre pattes le matin, à deux pattes à midi et à trois pattes le soir ?'");
            System.out.println("1: Répondre ('L'homme')\n2: Répondre ('Un chien')\n3: Répondre ('Un chat')\n4: Répondre ('Un serpent')\n5: Ne pas répondre et demander de l'aide à un allié");
        }else{
            System.out.println("Enigme surprise : 'Qu'est-ce qui marche à quatre pattes le matin, à deux pattes à midi et à trois pattes le soir ?'");
            System.out.println("1: Répondre ('L'homme')\n2: Répondre ('Un chien')\n3: Répondre ('Un chat')\n4: Répondre ('Un serpent')");
        }
        String choix = scanner.next();
        if (choix.equals("1")) {
            System.out.println("Bonne réponse ! +20 points");
            monde.getPersonnage().ajouterPoints(20);
            vieDoflamingo += 5;
            afficherPoints();
            System.out.println("Doflamingo récupère 5 points de vie. Vie de Doflamingo: " + vieDoflamingo);
            enigmeSurpriseUtilisee = true;
            combatFinal(); // Reprendre le combat avec Doflamingo
        } else if (choix.equals("5") && !aideUtilisee) {
            System.out.println("Indice : Pensez aux différentes étapes de la vie humaine.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour demander de l'aide");
            aideUtilisee = true;
            enigmeSurprise(); // Redemande l'énigme après l'indice
        } else if (choix.equals("5") && aideUtilisee) {
            System.out.println("Vous avez déjà utilisé l'aide pour cette énigme.");
        } else {
            System.out.println("Mauvaise réponse. Vous êtes mort.");
            gagne=1;
            System.exit(0);
        }
        fin.pointsNégatifs();
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void display(int id) {
        if(id==22){
            combatFinal();
            NoeudTerminal fin = new NoeudTerminal(1000,"hehe",monde);
            fin.display(30);
        }
    }

    @Override
    public Node chooseNext(int id) {
        if(id==30){
            return new NoeudTerminal(1000,"deee",monde);
        }
       return null; }

}
