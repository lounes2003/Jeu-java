package Representation;

import Univers.Personnage;
import java.util.Random;
import java.util.Scanner;
import Univers.Monde;
/* cette classe represente l'aléatoire
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
 */
public class ChanceNode extends Node {

    private Monde monde;

    public ChanceNode(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
    }
    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }
    @Override
    public void display(int id) {
        if(id == 50) {
            Scanner scanner = new Scanner(System.in);
            String choix;
            Personnage personnage;
            System.out.println("La decision de combattre ou non se jouera au pile ou face");
            System.out.println("Tapez 0 pour lancer la pièce");
            choix = scanner.next();

            while (!choix.equals("0")) {
                System.out.println("Erreur. Entrez 0.");
                choix = scanner.next();
            }
            if (choix.equals("0")) {
                Random random = new Random();
                int x = random.nextInt(2) + 1;
                System.out.println("...");
                if(x == 1) {
                    System.out.println("Pile : il faudra donc se Battre.");
                    System.out.println("Combat en cours...");
                    System.out.println("Vous avez survécu à ce combat et gagnez donc 10 points.");
                    monde.getPersonnage().ajouterPoints(10);
                    afficherPoints();
                }
                if(x == 2) {
                    System.out.println("Face : Vous devez donc fuir.");
                    System.out.println("Par conséquent vous ne gagnez pas de points.");
                    afficherPoints();
                }
            }
        }
    }

    @Override
    public Node chooseNext(int id) {
        if(id == 3) {
            return new InnerNode(id, "dd", monde);
        }
        throw new IllegalArgumentException("ID non reconnu : " + id);
    }
}
