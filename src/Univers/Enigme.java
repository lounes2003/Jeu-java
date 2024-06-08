package Univers;

public class Enigme {
    private String question;
    private String[] options;

    public Enigme(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    public void resoudre() {
        System.out.println("Résolution de l'énigme : " + question);
    }

    public void joueurInactif() {
        System.out.println("Le joueur est inactif.");
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }
}
