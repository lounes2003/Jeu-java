package Representation;

import Univers.Cle;
import Univers.Monde;
/* cette classe represente la phase terminale
la méthode evaluerfin est une méthode qui permet de voir si on a gagné ou pas suivant des criteres précisés dans le scenario
la méthode pointnégatifs est une méthode qui vérifie si y a des points négatifs et si c'est le cas alors c'est la fin du jeu
la méthode clénontrouvée est une méthode qui vérifie si le joueur a trouvé toutes les clés qu'il faut afin d'avancer dans le jeu si elles ne sont pas trouvées alors c'est la fin
la méthode clénontrouvée et pointsnégatifs sont appeles dans la quasi-totalité des classes
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
 */
public class NoeudTerminal extends Node {
    private Monde monde;

    public NoeudTerminal(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
    }

    public void evaluerFin() {
        int points = monde.getPersonnage().getPoints();

        if (points < 0) {
            System.out.println("VOUS ETES MORT. C'est la fin de la partie pour vous.");
            System.exit(0);
        } else if (points == 0) {
            System.out.println("Vous avez vaincu Doflamingo mais vous n'arrivez pas à transmettre le message.");
            System.out.println("C'est la fin de la partie pour vous.");
            System.exit(0);
        } else {
            System.out.println("Vous gagnez la partie en transmettant votre message à Barbe Blanche.");
            //Chemin de l'image
            String imagePath0 = "C://Users//boudi/Downloads/vic.jpg";
            // Créer une instance de ImageDisplay
            ImageDisplay imageDisplay0 = new ImageDisplay(imagePath0);
            // Afficher l'image dans un cadre
            imageDisplay0.showImageInFrame();
        }
        System.out.println("----------------------------------------------------------------------------");
        //System.exit(0);
    }

    public void pointsNégatifs() {
        int points = monde.getPersonnage().getPoints();
        if (points <= 0) {
            System.out.println("Vous n'avez plus de points. Vous avez perdu!");
            System.exit(0);
        }
    }

    public void cleNonTrouvee(Cle cle) {
        if (!cle.getFlag()) {
            System.out.println("Vous n'avez pas trouvé la clé, vous avez perdu !");
            System.exit(0);
        }
    }

    @Override
    public void display(int id) {
        if (id == 30) {
            pointsNégatifs();
            evaluerFin();
        }
    }

    @Override
    public Node chooseNext(int id) {
        System.out.println("Vous êtes à la fin du jeu. Il n'y a pas de prochain noeud.");
        return null; // Pas de prochain noeud car c'est la fin du jeu
    }
}
