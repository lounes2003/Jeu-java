package Representation;

/* cette classe represente la classe abstract node
méthode display est une méthode pour afficher les scénarios possible cette fonction dépend de la trame de l'histoire qui est défini par des id
méthode choosenext est une méthode qui permet de passer vers un autre node grace a un id spécifique
méthode getId permets de récuperer les id de chaque noeud
méthode getdescription récupere la description que chaque node possede
 */
public abstract class Node {
    
    private int id;
    private String description;

    public Node(int id, String description){
        this.id = id;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public abstract void display(int id);

    public abstract Node chooseNext(int id);
}
