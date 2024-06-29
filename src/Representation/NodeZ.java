package Representation;

import Univers.Cle;
import Univers.Monde;
import Univers.Personnage;

import java.util.Scanner;

/* cette classe represente le choix de suivre NAMI
la fonction afficher points retourne le nombre de points que le joueur possede
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
méthode résoudreclé1 est une méthode dans laquelle la clé 1 pour avancer est créée
méthode resoudreclé2 est une méthode dans laquelle la clé 2 pour avancer est créée
méthode poserenigmeBonus est une méthode dans laquelle l'énigme pour gagner des points est créée
méthode résoudrecleetEnigmeZoro est une méthode dans laquelle on demande a l'utilisateur de répondre a l'enigme et trouver les deux clés avec le respect de l'utilisation unique de l'indice
 */

public class NodeZ extends Node {
    private Monde monde;
    private Scanner scanner;
    private boolean enigmeSurpriseUtilisee = false;
    private boolean aideUtilisee = false;
    private boolean flag = true;
    private NoeudTerminal fin;
    private Cle cle = new Cle(true);

    public NodeZ(int id, String description, Monde monde) {
        super(id, description);
        this.monde = monde;
        this.scanner = new Scanner(System.in);
        this.fin = new NoeudTerminal(1000,"fin",monde);
    }

    public void afficherPoints() {
        System.out.println("Points actuels: " + monde.getPersonnage().getPoints());
    }

    private void resoudreClesEtEnigmeZoro() {
        // Première clé
        resoudreCle1();
        afficherPoints();
        aideUtilisee = false;

        // Deuxième clé
        resoudreCle2();
        afficherPoints();
        aideUtilisee = false;

        // Enigme bonus
        resoudreEnigmeBonus();
        afficherPoints();
        aideUtilisee = false;
    }

    private void resoudreCle1() {
        System.out.println("Clé : 'Vous avez 9 pièces devant vous et une balance a deux plateaux. Une des pièces est plus légère que les autres. En combien de peser minimale pouvez-vous trouver la pièce légère ?'");
        if(!aideUtilisee){
            System.out.println("1: Répondre (1)\n2: Répondre (2)\n3: Répondre (3)\n4: Répondre (4)\n5: Demander de l'aide à Zoro");
        }else{
            System.out.println("1: Répondre (1)\n2: Répondre (2)\n3: Répondre (3)\n4: Répondre (4)");
        }
        String choix = scanner.next();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")) {
            System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
            choix = scanner.next();
        }
        if (choix.equals("2")) {
            System.out.println("Bonne réponse ! +20 points");
            monde.getPersonnage().ajouterPoints(20);
        } else if (choix.equals("5") && !aideUtilisee) {
            System.out.println("Indice : Pensez à la méthode du tri par comparaison.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour demander de l'aide");
            aideUtilisee = true;
            resoudreCle1(); // Redemande l'énigme après l'indice
        } else {
            cle.setFlag(false);
            fin.cleNonTrouvee(cle);
        }
    }

    private void resoudreCle2() {
        System.out.println("Clé : 'Quel est l'objet qui appartient à vous, mais que les autres utilisent plus souvent que vous ?'");
        if(!aideUtilisee){
            System.out.println("1: Répondre ('Le temps')\n2: Répondre ('La patience')\n3: Répondre ('Notre prénom')\n4: Répondre ('Notre argent')\n5: Demander de l'aide à Zoro");
        }else{
            System.out.println("1: Répondre ('Le temps')\n2: Répondre ('La patience')\n3: Répondre ('Notre prénom')\n4: Répondre ('Notre argent')");
        }
        String choix = scanner.next();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")) {
            System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
            choix = scanner.next();
        }
        if (choix.equals("3")) {
            System.out.println("Bonne réponse ! +20 points");
            monde.getPersonnage().ajouterPoints(20);
        } else if (choix.equals("5") && !aideUtilisee) {
            System.out.println("Indice : C'est quelque chose d'intangible mais personnel.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour demander de l'aide");
            aideUtilisee = true;
            resoudreCle2(); // Redemande l'énigme après l'indice
        } else {
            cle.setFlag(false);
            fin.cleNonTrouvee(cle);
        }
    }

    private void resoudreEnigmeBonus() {
        System.out.println("Enigme : Quel événement a marqué la fin de la Première Guerre mondiale ?");
        if(!aideUtilisee){
            System.out.println("1: La signature du Traité de Versailles\n2: L'assassinat de l'archiduc François-Ferdinand\n3: La bataille de la Somme\n4: La Révolution russe de 1917\n5: Demander de l'aide à Zoro. \n6: Ne pas répondre et passer à autre chose");
        }else{
            System.out.println("1: La signature du Traité de Versailles\n2: L'assassinat de l'archiduc François-Ferdinand\n3: La bataille de la Somme\n4: La Révolution russe de 1917\n6: Ne pas répondre et passer à autre chose");
        }
        String choixEnigme = scanner.next();
        while (!choixEnigme.equals("1") && !choixEnigme.equals("2") && !choixEnigme.equals("3") && !choixEnigme.equals("4") && !choixEnigme.equals("5") && !choixEnigme.equals("6")) {
            System.out.println("Erreur. Entrez 1 ou 2 ou 3 ou 4 ou 5 ou 6:");
            choixEnigme = scanner.next();
        }
        if (choixEnigme.equals("1")) {
            System.out.println("Bonne réponse ! +30 points");
            monde.getPersonnage().ajouterPoints(30);
        } else if (choixEnigme.equals("5") && !aideUtilisee) {
            System.out.println("Indice : C'était un traité qui a été signé après la guerre.");
            monde.getPersonnage().retirerPoints(5);
            System.out.println("-5 points pour demander de l'aide");
            aideUtilisee = true;
            resoudreEnigmeBonus(); // Redemande l'énigme après l'indice
        } else if (choixEnigme.equals("6")) {
            System.out.println("Vous avez choisi de ne pas répondre et de passer à autre chose.");
        } else {
            System.out.println("Mauvaise réponse. -10 points");
            monde.getPersonnage().retirerPoints(10);
        }
    }


    public boolean getFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void display(int id) {
        if(id==12){
            resoudreClesEtEnigmeZoro();
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
