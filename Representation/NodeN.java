package Representation;

import Univers.Cle;
import Univers.Monde;
import Univers.Personnage;

import java.util.ArrayList;
import java.util.Scanner;

/* cette classe represente le choix de suivre NAMI
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
méthode poserenigmeNAMI est une méthode dans laquelle l'énigme pour gagner des points est créée
méthode résoudreEnigmeNami est une méthode dans laquelle on demande a l'utilisateur de répondre a l'enigme avec le respect de l'utilisation unique de l'indice
 */
public class NodeN extends Node {
    private Monde monde;
    private Scanner scanner;
    private boolean aideUtilisee = false;
    private NoeudTerminal fin;
    private boolean flag = true;
    private Cle cle = new Cle(true);

    public NodeN(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
        this.scanner = new Scanner(System.in);
        this.fin = new NoeudTerminal(1000,"FIN",monde);
    }

    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }

    private void poserEnigmeNami() {

            ArrayList<String> listeReponses = new ArrayList<String>();
            listeReponses.add("1: Répondre (1)");
            listeReponses.add("2: Répondre (2)");
            listeReponses.add("3: Répondre (3)");
            listeReponses.add("4: Répondre (4)");
            if(!aideUtilisee){
                listeReponses.add("5: Demander de l'aide à Nami");
            }

            listeReponses.add("6: Ne pas répondre et passer à autre chose");
            System.out.println("Enigme : ‘Vous avez 9 pièces devant vous et une balance à deux plateaux.\n Une des pièces est plus légère que les autres. \nEn combien de peser minimale pouvez-vous trouver la pièce légère ?’");

            for (int i=0; i < listeReponses.size(); i++)
            {
                System.out.println(listeReponses.get(i));
            }

            String choix = scanner.next();
            while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")) {
                System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
                choix = scanner.next();
            }
            if (choix.equals("2")) {
                System.out.println("Bonne réponse ! +50 points.");
                monde.getPersonnage().ajouterPoints(50);
            } else if (choix.equals("5")) {
                if (aideUtilisee) {
                    System.out.println("Mauvaise réponse. -10 points");
                    monde.getPersonnage().retirerPoints(10);
                } else {
                    System.out.println("Indice : Pensez à la méthode du tri par comparaison et comparez 3 pièces avec 3 autres.");
                    monde.getPersonnage().retirerPoints(5);
                    System.out.println("-5 points pour avoir demandé de l'aide.");
                    aideUtilisee = true;
                    poserEnigmeNami();
                }
            } else if (choix.equals("6")) {
                System.out.println("Vous avez choisi de ne pas répondre et de passer à autre chose.");
            } else {
                System.out.println("Mauvaise réponse. -10 points");
                monde.getPersonnage().retirerPoints(10);
            }
    }

    public void resoudreEnigmeNami() {
        poserEnigmeNami();
        afficherPoints();
        aideUtilisee = false;
        fin.pointsNégatifs();
    }


    @Override
    public void display(int id) {
        if(id==10){
            resoudreEnigmeNami();
            NodeCombat combat = new NodeCombat(1000,"hehe",monde);
            combat.display(22);
        }
    }

    @Override
    public Node chooseNext(int id) {
        if(id==22){
            return new NodeCombat(1000,"deee",monde);
        }
       return null;
    }


}
